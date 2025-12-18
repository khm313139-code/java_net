package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//UDP 양방향 통신 - server
//100% 쓰레도 사용

/*
서버에서는 두개의 port가 작동을 한다. : 10000(클라이언트에게 메세지 받는 포트), 10001(클라이언트에게 전송하는 전용포트) open
thread 2개를 각각 송신, 수신으로 나누어서 작업을 한다.


*/

public class java_net16 {

	public static void main(String[] args) throws Exception{
		
		//클라이언트에게 메세지를 받는 전용 쓰레드
		Thread th1 = new client_receive();
		th1.start();
		
		//클라이언트에게 메세지를 보내는 전용 쓰레드
		Thread th2 = new client_send();
		th2.start();

	}

}



//client_receive => 17에 server_send 메소드와 연결
class client_receive extends Thread{ //receive - 서버에서 클라이언트 수신
	//private final String ip = "172.30.1.32"; //클라이언트 ip - 받는 쪽은 지금은 넣을 필요 없음
	private final int port = 10000; //서버에서 받는 port
	private DatagramSocket ds = null;
	private DatagramPacket dp = null;
	private String msg = "";
	
	
	public client_receive() { //즉시실행
		try {
			//서버에서 클라이언트 메세지를 받는 역할을 하는 포트를 오픈 
			this.ds = new DatagramSocket(this.port);
		} catch (Exception e) {
			System.out.println("서버에서 받는 포트가 충돌 발생 하였습니다.");
		}
	}
	
	
	@Override
	public void run() {
		try {
			System.out.println("[서버시작]");
			
			while(true) {
				//통신에서 받을 수 있는 크기 지정
				byte client_byte[] = new byte[1024];
				this.dp = new DatagramPacket(client_byte, client_byte.length);
				this.ds.receive(this.dp); //클라이언트에서 보낸 메세지를 받는 메소드
				int len = this.dp.getLength();
				this.msg = new String(this.dp.getData(),0,len);
				System.out.println("클라이언트 메세지 : "+this.msg); //서버에서 최종 출력
			}
			
		} catch (Exception e) {
			System.out.println("UDP 서버 오픈 오류 발생!!");
		
		}
		
		
	}
}




//client_send => 17에 server_receive 메소드와 연결
class client_send extends Thread{ //send - 서버에서 클라이언트 송신
	
	private final String ip = "172.30.1.72"; //클라이언트의 ip
	private final int port = 20000; //클라이언트 받는 포트
	private final int myport = 10001; //서버에서 클라이언트로 파일을 보내는 포트
	
	
	private DatagramSocket ds = null;
	private DatagramPacket dp = null;
	private String msg = "";
	private InetAddress ia = null;
	private InputStreamReader isr = null;
	private BufferedReader br = null;
	
	
	public client_send() {
		try {
			
			//클라이언트의 ip와 서버에서 보내는 포트를 생성
			this.ia = InetAddress.getByName(this.ip);
			this.ds = new DatagramSocket(this.myport);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("메세지를 입력하세요: ");
				this.isr = new InputStreamReader(System.in); //서버에서 메세지 작성
				this.br = new BufferedReader(this.isr); //서버 메모리에 저장
				this.msg = this.br.readLine(); //메모리에 저장된 모든 내용을 문자 변수로 이관
				byte by[] = this.msg.getBytes(); //데이터 패킷을 생성하기 위해 바이트 배열로 저장(byte로 전환해서)
				
				
				this.dp = new DatagramPacket(by, by.length, this.ia, this.port);
				this.ds.send(this.dp);
				
				
			}
		} catch (Exception e) {
			System.out.println("클라이언트 메세지 전송 오류");
		}
	}
}