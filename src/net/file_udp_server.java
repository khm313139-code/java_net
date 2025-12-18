package net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
응용문제
udp로 양방향 통신을 이용하여 서로 파일을 교환하는 프로세서를 제작

이미지 전용
["전송할 파일 경로 및 파일명을 입력하세요 : "]

["전송 종료"] - 전송

["다운로드 종료"] - 받는 입장
*/

public class file_udp_server {

	public static void main(String[] args) throws Exception{
		
		Thread th1 = new client_receive1();
		th1.start();
		
		Thread th2 = new client_send1();
		th2.start();

	}

}

class client_receive1 extends Thread{
	
	private final int port = 10000;
	private DatagramSocket ds = null;
	private DatagramPacket dp = null;
	private String msg = "";
	
	
	public client_receive1() {
		try {
			this.ds = new DatagramSocket(this.port);
			
			
			
		} catch (Exception e) {
			System.out.println("서버에서 받는 포트 충돌 발생");
		}
	}
	
	
	//서버에서 전송한 파일을 받는 thread
	@Override
	public void run() {
		try {
				System.out.println("[수신 대기]");
				//server 패킷과 동일한 byte
				byte [] buffer = new byte[2048];
				dp = new DatagramPacket(buffer, buffer.length);
				FileOutputStream fos = new FileOutputStream("D:\\java_net\\download\\new.jpg");
				
				
				
				//반복문 돌면서 파일을 입력받고 write 시킴 저장시키는거지
				while(true) {
					ds.receive(dp);
					String check = new String(dp.getData(),0,dp.getLength());
					if(check.equals("전송 종료")) {
						System.out.println("[다운로드 종료]");
						break;
					}
					fos.write(dp.getData(),0,dp.getLength()); //자신의 pc에 파일 저장
				}
				
				fos.close(); //파일 저장 스트림 종료
				ds.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




class client_send1 extends Thread{
	
	private final String ip= "172.30.1.32";
	private final int port = 30000;
	private final int myport = 10002;
	
	private DatagramSocket ds = null;
	private DatagramPacket dp = null;
	private String msg = "";
	private InetAddress ia = null;
	private InputStreamReader isr = null;
	private BufferedReader br = null;
	
	
	public client_send1() {
		try {
			this.ia = InetAddress.getByName(this.ip);
			this.ds = new DatagramSocket(this.myport);
			
		} catch (Exception e) {
			System.out.println(e);
		
		}
	}
	
	@Override
	public void run() {
		try {
			System.out.println("전송할 파일 경로를 입력하세요: ");
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			String path = br.readLine();
			
		
			FileInputStream fis = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] buffer = new byte[2048];
			
			
			int size = 0;
			while((size = bis.read(buffer)) != -1) {
				dp = new DatagramPacket(buffer, size, ia, port);
				ds.send(dp);
			}
			
			
			byte[] end = "전송 종료".getBytes();
			dp = new DatagramPacket(end, end.length, ia, port);
			ds.send(dp);
			
			
			bis.close();
			ds.close();
			
		} catch (Exception e) {
			System.out.println("클라이언트 메세지 전송 오류");
			e.printStackTrace();
		}
	}
}






















