package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
응용문제 2.
해당 프로세서 네트워크를 이용하여 udp 방식의 서버와 클라이언트를 완성하시오.
[클라이언트]
"전송할 메뉴를 선택하세요 [1.콜라, 2.사이다, 3.소주 4.맥주 5.막걸리]: 3"

[서버]
"주문한 메뉴는: 소주를 신청하셨습니다."

*/
public class server_udp {

	public static void main(String[] args) {
		new choice_box().choice();

	}

}


class choice_box{
	private final String ip = "172.30.1.10";
	private final int port = 9090;
	private DatagramSocket ds = null;
	private DatagramPacket dp = null;
	private InetAddress ia = null;
	private String msg = "";
	private InputStreamReader isr = null;
	private BufferedReader br = null;
	
	
	
	public void choice() {
		try {
			this.ia = InetAddress.getByName(this.ip);
			this.ds = new DatagramSocket(this.port);
			this.udp();
			
			
		} catch (Exception e) {
			System.out.println("포트 충돌로 인하여 서버 가동 안됨");
		}

	}
	private void udp() {
		try {
			byte [] buffer = new byte[1024]; //=> 저장용량
			//원시배열의 단점은 new byte[1] 크기를 지정을 해버리면 변경이 어렵다.
			//switch case에서 1024로 지정하면 숫자 하나가 1byte 차지하고 나머지는 1023바이트는 공백으로 나오는 것임
			this.dp = new DatagramPacket(buffer, buffer.length);
			
			
			this.ds.receive(this.dp);
			int word_ea = this.dp.getLength(); //client에서 byte에 대한 길이 값을 정하지 않은 상황에서 전송된 byte 길이를 확인하기 위한 사항
			
			//아래가 해결법 공백을 없애는
			this.msg = new String(this.dp.getData(),0,word_ea);
			System.out.println(this.msg);

			String no = this.msg.replace("\"", "");
			int nno = Integer.parseInt(no);
			System.out.println(nno);
			String menu = "";
			switch (no) {
			case "1":
				menu = "콜라";
				break;
			case "2":
				menu = "사이다";
				break;
			case "3":
				menu = "소주";
				break;
			case "4":
				menu = "맥주";
				break;
			case "5":
				menu = "막걸리";
				break;
			default:
				menu = "없어 돌아가";
				break;
			}
			System.out.println("주문한 메뉴는: "+menu+"를 신청하셨습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("udp 수신 오류 발생");
		}
	}
}






