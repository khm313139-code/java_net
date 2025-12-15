package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class java_net9 {
	//UDP 연결방식 (Server) => socket 형태가 없음.
	//client
	public static void main(String[] args) {
		String ip = "172.30.1.72"; //상대방 서버 ip주소
		
		int port = 10000;
		try {
			InetAddress ia = InetAddress.getByName(ip); //서버 아이피 정보를 가져옴(udp 포트)
			DatagramSocket ds = new DatagramSocket(port);//이거는 서버의 소켓임(내꺼임 내 서버) 내 포트임

			while(true) { //클라 쪽에 무한루프 걸어버림
				byte b[] = new byte[1024];
				DatagramPacket dp = new DatagramPacket(b,b.length,ia,port); //클라는 4가지를 넣어야함
				ds.send(dp); // 메세지 전송
				System.out.println("서버에 해당 정보 발송완료!!");
				
				byte b2[] = new byte[1024];
				dp = new DatagramPacket(b2, b2.length);
				ds.receive(dp);
				System.out.println(new String(dp.getData()));
			}
			
		}catch (Exception e) {
			System.out.println("서버 접속에 실패 하였습니다. ");
		}
		
	}

}
