package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 나 클라이언트 담당!
 응용문제 
 해당 프로세서 네트워크를 이용하여 UDP 방식의 서버와 클라이언트 완성
 [클라이언트]
 "전송할 메뉴를 선택하세요[1.콜라 2.사이다 3.소주 4.맥주 5.막걸리]:"
 
 [서버]
 "주문한 메뉴는 : 소주를 신청하셨습니다"
 */
public class client_udp {
	public static void main(String[] args) {
		new chat_ct();
	}
}

class chat_ct{
	private final String ip="172.30.1.10";  //서버 ip
	private final int port=9090;  //서버 port (송,수신)
	private final int myport=51223;  //client 사용할 pc port(송,수신)
	
	private DatagramSocket ds=null;
	private DatagramPacket dp=null;
	private InetAddress ia=null;  
	private String msg=null;  //client (송,수신) 메세지 담는 변수 
	private InputStreamReader isr=null;
	private BufferedReader br=null;
	
	public chat_ct() {
		this.udp();
	}
	
	//"" 삭제 하는법 변수.replaceAll("\","");
	
	public void udp() {
		try {
			//서버주소
	        this.ia = InetAddress.getByName(this.ip);
	        this.ds = new DatagramSocket(this.myport);
	        
			System.out.println("전송할 메뉴를 선택하세요[1.콜라 2.사이다 3.소주 4.맥주 5.막걸리]:");
			this.isr=new InputStreamReader(System.in);
			this.br=new BufferedReader(this.isr);
			this.msg =this.br.readLine();
			
			byte by[]=this.msg.getBytes();
			this.dp=new DatagramPacket(by,by.length,this.ia,this.port);  
			this.ds.send(this.dp);
			System.out.println("★메뉴 전송완료★");	
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("서버 접속 오류 발생!");
		}

		
	}
	
}