package net;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//tcp - server (i/o) - 파일처리
//하나의 서버에 여러개의 ip를 적용할 수 있다. -dns 사용해서 매핑해서 ip가 할당이 된다.
//하지만 하나의 서버가 죽으면 여러개의 ip를 다 사용할 수가 없게 된다.


public class java_net10 {

	public static void main(String[] args) {
		new java_net10_server("172.30.1.10",10008);

	}
}


class java_net10_server{
	
	//tcp 방식
	String ip = null;
	int port = 0;
	
	Socket sk = null;
	ServerSocket ss = null; //소켓이 붙으면 server 없으면 client
	InputStream is = null;
	OutputStream os = null;
	
	//udp
	//datagram socket, packet 들어가면 udp
	
	
	public java_net10_server(String severip, int serverport) { //즉시실행
		this.ip = severip;
		this.port = serverport;
		this.ftp_server();
	}
	public void ftp_server() {
		try {
			this.ss = new ServerSocket(this.port);
			this.sk = this.ss.accept(); //서버 유지 시킴
			System.out.println("********************서버 가동중*********************");
			String url = "d:\\java_net\\upload\\"; //클라이언트가 전송한 파일 저장소
			
			
			//클라이언트가 전송한 파일을 수신 역할
			this.is = this.sk.getInputStream();
			byte data[] = new byte[2097152]; //최대 업로드는 2MB 이하
			
			//클라이언트가 전송한 파일을 저장
			this.os = new FileOutputStream(url + "data.jpg");
			int filesize = 0;
			while((filesize = this.is.read(data))!=-1) {
				this.os.write(data,0,filesize); //통신은 한번에 못 읽고 쪼개서 읽어야 한다.
				this.os.flush();
			}
			System.out.println("정상적으로 전송파일을 저장 하였습니다.");
			this.os.close();
			this.is.close();
			this.sk.close();
			
			
			
			
		}catch (Exception e) {
			e.getMessage(); //=> bind error
			System.out.println("서버 포트가 충돌 하였습니다.");
		}
		
	}
}