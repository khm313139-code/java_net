package net;

//UDP - 메세지 수신(server) - 연습
//키오스크 서버 메뉴 리시브 파트(주문 받는 쪽)

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringBufferInputStream;
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
				
				
				//byte -> arraylist 해석 후 -> object
				Object menus = this.arrdata(this.msg, msglength);
				System.out.println(menus);
				
			
			//}

		} catch (Exception e) {
			System.out.println("UDP 서버 오픈 오류 발생!!");
		}
		
	}
	
	
	//byte[] => object(자료형) => 변환된 내용 출력
	
	public Object arrdata(byte by[], int length) {
		try {
			
			/*
			bytearrayinputstream은 => stream + buffered를 애초에 사용해버린다.
			
			ByteArrayInputStream => 네트워크 전용 I/O 
			File I/O, 일반 stream I/O 보다 빠르다 bytearrayinputstream이 => 이거는 jvm memory를 사용한다.
			*/
			
			ByteArrayInputStream os = new ByteArrayInputStream(by,0,length);
			
			/*
			
			ObjectInputStream(여러가지 타입을 제공하는 stream - 이거 filter 역할임 단독 사용은 불가능함.) : FileInputStream 같은 형태
			object => int,string,boolean,float
			다 변환이 가능하다
			
			*/
		
			ObjectInputStream oos = new ObjectInputStream(os);
			
			
			
			/*
			원래 코드 - 아래처럼 작성할 수 있음.
			
			String word = "d:\\java_io\\123.jpg";
			InputStream fs = new FileInputStream(word);
			ObjectInputStream oos2 = new ObjectInputStream(fs);
			Object result = oos2.readObject();
			*/
			
			
			return oos.readObject(); //읽기 전용
		}catch (Exception e) {
			System.out.println("전송된 배열값이 잘못 되었다.");
			return null;
		}
		
	}
	
}
