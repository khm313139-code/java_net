package net;

//UDP - 메세지 수신(server) - 연습
//키오스크 서버 메뉴 리시브 파트(주문 받는 쪽)


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class java_net14 {

	public static void main(String[] args) {
		new java_net14().test();

	}
	private final String ip ="172.30.1.10";
	private final int port = 9090;
	private DatagramSocket ds = null; //socket - server
	private DatagramPacket dp = null;
	private InetAddress ia = null; //클라이언트 정보 확인
	private byte msg[] = null;
	
	public void test() {
		try {
			this.ia = InetAddress.getByName(this.ip);
			this.ds = new DatagramSocket(this.port);
			
			//while(true) {
				byte server_byte[] = new byte[4098];
				this.dp = new DatagramPacket(server_byte, server_byte.length);
				System.out.println("메뉴 오더 준비중...");
				this.ds.receive(this.dp);
				
				
				this.msg = this.dp.getData();
				int msglength = this.dp.getLength();
				Object menus = this.arrdata(this.msg, msglength);
				System.out.println(menus);
				
			
			//}

		} catch (Exception e) {
			System.out.println("UDP 서버 오픈 오류 발생!!");
		}
		
	}
	
	public Object arrdata(byte by[], int length) {
		try {
			ByteArrayInputStream os = new ByteArrayInputStream(by,0,length);
			ObjectInputStream oos = new ObjectInputStream(os);
			return oos.readObject();
		}catch (Exception e) {
			System.out.println("전송된 배열값이 잘못 되었다.");
			return null;
		}
		
	}
	
}
