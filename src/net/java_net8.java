package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//TCP 연결방식 => Socket 형태로 접속
//UDP 연결방식 (Server) => socket 형태가 없음.
//server

/*
server => 10000 => client => 7000(open)
client => 7000 => udp open => 10000(open)

tcp는 포트가 하나라 오래 걸림 시간이
but udp는 양방향 통신을 해버려 패킷을 교환해버려서 속도가 빠르다.

*/

public class java_net8 {

	public static void main(String[] args) {
		String ip = "172.30.1.10"; //tcp ip
		int port = 10001;
		try {
			//서버에서 사용하는 ip(tcp ip임) 가져옴
			InetAddress ia = InetAddress.getByName(ip);
			
			//DatagramSocket => UDP 내부 소켓 / tcp ip를 가지고 udp에 대한 포트에 적용을 하는 것
			//tcp ip를 가져와서 내부망을 open 
			DatagramSocket ds = new DatagramSocket(port); //내부망 통신 port 오픈
			
			byte by[] = new byte[1024];
			
			//DatagramPacket => UDP 송수신 패킷
			DatagramPacket dp = new DatagramPacket(by, by.length);
			System.out.println("서버 오픈.... ");
			ds.receive(dp); //작동하는 코드 client 에서 보낸 메세지를 서버에서 받는 역할
			
			InetAddress client_ip = dp.getAddress(); //상대방 접속 ip 정보
			int client_port = dp.getPort();
			System.out.println(client_ip);
			System.out.println(client_port);
			
			
			
			
		} catch (Exception e) {
			System.out.println("UDP 포트 충돌로 인하여 서버가 중지됩니다.");
		}

	}

}
