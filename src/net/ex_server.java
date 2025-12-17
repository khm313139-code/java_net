package net;
//udp 통신
/*
[서버 실행]
"udp를 오픈할 포트번호를 입력하세요: 10006"
"해당 포트가 오픈 되었습니다."

[클라이언트 서버에 접근할 경우]
"접속한 클라이언트 정보 : "
*/

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class ex_server {

	public static void main(String[] args) {
		new make_server();
	}

}

class make_server {
	public DatagramSocket ds = null;
	public DatagramPacket dp = null;
	Scanner sc = new Scanner(System.in);

	public make_server() {
		this.udp();
	}

	public void udp() {
		try {
			// 1. 포트 입력
			System.out.print("udp를 오픈할 포트번호를 입력하세요: ");
			int port = sc.nextInt();

			// 2. UDP 포트 오픈
			this.ds = new DatagramSocket(port);
			System.out.println("해당 포트가 오픈 되었습니다.");

			// 3. 클라이언트 접속 대기
			while (true) {
				byte[] by = new byte[1024];
				this.dp = new DatagramPacket(by, by.length);

				// 클라이언트 수신 (접속 신호)
				ds.receive(dp);

				// 4. 접속한 클라이언트 정보 출력
				String clientMsg = new String(dp.getData(), 0, dp.getLength());
				System.out.println("접속한 클라이언트 정보 : "
						+ dp.getAddress().getHostAddress()
						+ " : " + dp.getPort());

				
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UDP 서버 오류 발생!!");
		}
	}
}
