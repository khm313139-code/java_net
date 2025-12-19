package example;
/*
시험 제출

server: test_server.java
client: test_client.java
*/

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//server - java network

public class ex7 {

	public static void main(String[] args) {
		Thread th1 = new ex7_tcp();
		th1.start();
		Thread th2 = new ex7_udp();
		th2.start();
	}
}
//tcp
class ex7_tcp extends Thread { //thread를 이용하여 각각의 통신을 분리시킬 수 있음 tcp, udp
	int port = 9000;
	ServerSocket ss = null; //TCP 서버 전용 Class
	Socket sk = null; //tcp server & client 모두 사용
	
	
	@Override
	public void run() { //thread 전용 가동 메소드
		try {
			while(true) {
				this.sk = ss.accept(); //포트 연결을 유지한다. tcp, udp 동시에 돌리려면 쓰레드 써야함
			}
		} catch (Exception e) {
			System.out.println("해당 서버에 포트가 충돌 발생 하였습니다.");
		}
	}
	
	public ex7_tcp() { //즉시 실행
		try {
			this.ss = new ServerSocket(this.port); //얘 반복문 안에 넣으면 안됨
		}catch (Exception e) {
			
		}
	}
}



//udp
class ex7_udp extends Thread{
	String ip = "172.30.1.10"; //서버 udp ip
	int port = 9000; //서버에서 송신, 수신을 하기 위한 port
	DatagramSocket ds = null; //자신의 ip 정보와 자신의 포트 정보를 이용하여 open
	DatagramPacket dp = null; //byte의 크기 및 데이터 자료
	InetAddress ia = null; //ipv4, ipv6
	
	@Override
	public void run() { //thread 전용 가동 메소드
		try {
			while(true) {
				byte[] by = new byte[1024]; 
				//udp 송수신 크기를 정한 후 datagrampacket에 적용
				this.dp = new DatagramPacket(by, by.length);
				this.ds.receive(this.dp); //receive() : 수신 / send() : 송신
			}
		}catch (Exception e) {	
			System.out.println("해당 UDP 포트가 충돌 발생 하였습니다.");
		}
}
	

	public ex7_udp() {
		try {
			this.ia = InetAddress.getByName(this.ip);
			this.ds = new DatagramSocket(this.port); //최종 자신의 ip 및 port를 제작
	
		} catch (Exception e) {
			
		}
	}
}
