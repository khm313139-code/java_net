package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TCP 통신이며 양방향 통신 - server & thread + (guest, admin) 만드려면 각각 핸들링

public class multi_server {

	public static void main(String[] args) {
		multi_server msr = new multi_server();
		msr.start();

	}
	
	public void start() { //서버의 소켓을 유지하기 위한 메소드
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(20000); //포트 오픈
			System.out.println("[채팅 시작]"); //서버 가동시 출력되는 메세지
			
			new admin().start(); //쓰레드 돌리기 위해 필요함
			
			while(true) {
				socket = serverSocket.accept(); // 소켓 유지
				ms m = new ms(socket); //thread에 해당 소켓 전달
				m.start(); //run을 의미함, - thread 가동
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
					System.out.println("서버를 강제 종료");
				} catch (Exception e2) {
					System.out.println("서버 소켓이 완전히 종료 되지 않았습니다.");
				}
			}
		}
		
		
	}

//모든 서버에 접속된 사용자에게 메세지 발송
	public static void sendall(String s) {
		System.out.println(ms.list.get(0).toString()); //send날릴때 출력시켜서 뭐가 출력되나 보려고 출력시킴
		for(PrintWriter out : ms.list) {
			System.out.println(out.toString());
			out.println(s); //여기서 발송되는 역할임. / 발송시 한 줄 아래(라인변경)로 라인 변경하여 적용하기 위한 메소드
			//out.write(s);//여기서 발송되는 역할임.(이렇게 써도 된다.) ln쓴 이유는 줄바꿈 때문에 쓴 것
			out.flush();//해당 메세지를 발송시 메모리에서 내용을 비움
		}
	}
}



//서버 관리자 관제에 대한 메세지 전송
class admin extends Thread{
	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void run() {
			while(true) {
				System.out.println("관리자 입력 사항: ");
				try {
					
				String admin_msg = this.sc.nextLine();
				String m = "[관리자] : "+admin_msg;
				if(admin_msg.equals("shutdown")) {
					multi_server.sendall("해당 채팅방은 관리자가 강제 종료 하였습니다."); //관리자가 입력한 사항을 guest에게 모두 발송
					System.exit(0); //해당 서버를 강제 종료시킴
				}
			
				}catch (Exception e) {
					System.out.println("서버 관리자 입력사항 오류 발생!!");
					break;
				}
		}
			this.sc.close();
	}
	
}



//Guest가 접속시 송수신을 역할하는 클래스 - 접속자가 많으면 서버쪽에서 쓰레드가 계속 만들어지는 구조이다.
class ms extends Thread{
	
	//쓰레드가 별도로 돌아도 메모리 공간은 static으로 인해서 하나임
	//여러개가 생기는 것이 아니다.
	//이 부분은 해당 서버에 접속한 모든 사용자의 리스트를 메모리에 저장한다. 
	static List<PrintWriter> list = new ArrayList<PrintWriter>();
	
	
	
	InputStream is = null;
	OutputStream os = null;
	InputStreamReader isr = null;
	Socket socket = null;
	
	BufferedReader in = null;
	PrintWriter out = null;
	

	public ms(Socket socket) {
		this.socket = socket;
		
		
		try {
			//client로 송신
			this.out = new PrintWriter(this.socket.getOutputStream());
			
			//client로 수신
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			
			list.add(out);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() { //client에서 메세지 정보를 출력하는 역할
		String name = ""; //client가 로그인 한 사용자 이름
		try {
			name = this.in.readLine();
			System.out.println("["+name+"]님 환영합니다.");
			multi_server.sendall("["+name+"]님 환영합니다.");
			
			
			
			while(this.in != null) {
				String msg = in.readLine();
				//서버에서 채팅 내용 관제 
				System.out.println(name+"님: "+msg);
				if(msg.equals("종료")) {
					break;
				}
				
				else {
					multi_server.sendall(name+"님: "+msg); //전체 접속한 모든 사용자에게 메세지 발송					
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("해당 사용자 로그인 에러 발생!!");
		} finally {
			multi_server.sendall("["+name+"] 퇴장하셨습니다.");
			list.remove(out);
			try {
				this.socket.close();
				
			} catch (Exception e2) {
				System.out.println("정상적으로 종료하지 못했습니다.");
			}
		}
		System.out.println("["+name+"] 퇴장하였습니다.");
		
	}
	
}


