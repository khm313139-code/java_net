package net;
//udp 통신
/*
응용문제 1 
해당 서버와 클라이언트 서로 통신할 수 있도록 어플을 제작 하시길 바랍니다.

[서버 실행]
"udp를 오픈할 포트번호를 입력하세요: 10006"
"해당 포트가 오픈 되었습니다."
[클라이언트 서버에 접근을 할 경우]
"접속한 클라이언트 정보 : "

[클라이언트 실행]
"서버 접속 ip를 입력하세요 : "
"서버에 접속할 포트 번호를 입력하세요: "
"자신의 udp를 오픈할 포트 번호를 입력하세요: "
"서버에 올바르게 접속 되었습니다."


*/

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ex_client {

	public static void main(String[] args) {
		new make_client();

	}

}

class make_client{
	public String ip = null;
	public int port;
	public int myport;
	public DatagramSocket ds = null;
	public InetAddress ia = null;
	public String msg = "";
	Scanner sc = new Scanner(System.in);
	
	public make_client() {
		this.udp();
	}
	
	
	public void udp() {
		try {
			System.out.println("서버 접속 ip를 입력하세요: ");
			String uip = sc.nextLine();
			System.out.println("서버에 접속할 포트번호를 입력하세요: ");
			int uport = sc.nextInt();
			System.out.println("자신의 udp를 오픈할 포트 번호를 입력하세요: ");
			int myport = sc.nextInt();
		
			
			this.ds = new DatagramSocket(myport);
			
			this.ia = InetAddress.getByName(uip);
			
			String msg = "클라이언트 접속 요청";
			byte data[] = msg.getBytes();
			
			DatagramPacket dp = new DatagramPacket(data, data.length, ia, uport);
			
			ds.send(dp);
			
			System.out.println("서버에 올바르게 접속했다.");
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("서버 접속 오류 발생!!");
		}
		
		
		
		
	}
	
}