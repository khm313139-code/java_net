package net;

import java.net.InetSocketAddress;
import java.net.Socket;

//client - socket 통신
public class java_net3 {

	public static void main(String[] args) {
		try {
			
			//상대방 pc로 접속하는 코드 - 클라이언트
			
			//InetSocketAddress: 서버 정보를 입력하는 클래스
			
			//10005번 포트를 이용하여 소켓 통신을 시작함
			InetSocketAddress ia2 = new InetSocketAddress("172.30.1.72",10005); //상대방 열려있는 포트로 접속
			
			Socket sk = new Socket();
			
			//connect : 해당 서버에 client가 접속하는 메소드
			sk.connect(ia2);
			System.out.println("연결확인");
			//연결확인 되면 끝내고 종료시킴
			sk.close();
			
		}catch (Exception e) {
			System.out.println("서버쪽에 통신이 불능상태 입니다.");
		}

	}

}
