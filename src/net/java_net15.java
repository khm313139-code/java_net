package net;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

//UDP - 메세지 송신(client) - 연습
//키오스크 서버 메뉴 오더 파트(주문 하는 쪽 - 테이블)




public class java_net15 {

	public static void main(String[] args) {
		new java_net15().test();

	}
	
	
	private final String ip ="172.30.1.72"; //서버 ip
	private final int port = 9090; //서버 port(송, 수신)
	private final int myport = 51224; //client 사용할 pc port (송, 수신)
	private DatagramSocket ds = null; 
	private DatagramPacket dp = null;
	private InetAddress ia = null; 
	private String msg = ""; //client (송수신) 메세지를 담는 변수
	private ArrayList<String> datalist = null;
	
	
	
	
	public byte[] arr_byte(Object obj) { //특수한 형태에서만 사용
		try {
			//array 클래스 배열을 byte 형태로 변환 시키는 stream
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			
			//object 형태로 변환
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			//writeobject, readobject는 objectstream에만 해당
			oos.writeObject(obj); //arraylist 배열 값을 => objectstream 변환(1차)
			oos.flush();
			
			return os.toByteArray(); //바이트 배열로 반환해서 사용하는 형태
			
		} catch (Exception e) {
			System.out.println("해당 배열 클래스 오류 발생!!");
			return null;
		}
	}
	
	
	
	public void test() {
		try {
			this.ia = InetAddress.getByName(this.ip); //서버 아이피
			this.ds = new DatagramSocket(this.myport); //서버에게 자신의 접속 udp port 정보를 전송(datagram안에는 배열이 들어있음.)
			
			
			//클래스 배열에 메뉴를 선택한 사항 정보를 저장
			this.datalist = new ArrayList<String>();
			this.datalist.add("메뉴1");
			this.datalist.add("메뉴2");
			this.datalist.add("메뉴3");
			
			
			//클래스 배열 => 바이트로 변환을 시켜서 전송
			
			while(true) {
				byte by[] = this.arr_byte(this.datalist);
				//서버에게 전송할 내용을 packet 생성해서 보냄
				this.dp = new DatagramPacket(by,by.length,this.ia,this.port); //서버 쪽으로 보내기 위함
				this.ds.send(this.dp);
				System.out.println("상담 내용 전송 완료!!");
			}
			
		}catch (Exception e) {
			e.getMessage();
			System.out.println("서버 접속 오류 발생!!");
		}
	}
}
