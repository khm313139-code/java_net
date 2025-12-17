package net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//socket 관련사항 -> port 오픈
//server - socket 통신

/*
OSI 7계층(통신 7계층)
1계층: 물리 계층(랜선연결, 노트북으로 무선 통신(와이파이))
2계층: 데이터 링크 계층(링크통신) - IP할당
3계층: 장치식별(통신의 최적화) - NETMASK, GATEWAY...
4계층: tcp,udp => port <==> 소켓과 포트는 다른 것임.(만약 다른 pc로 접속을 한다고 할때 ip를 알려주고 그 pc로 접속 하는 것을 소켓이라고 함 - 소켓 통신)
5계층: session - 통신이 유지되고 있는 파트(로그인) / 통신 유지 상태(로그인)
6계층: md5, sha1 - 표현 계층 등 암호화 복호화 작업
7계층: 웹사이트의 결제, 장바구니 등 화면 구역 영역
*/
public class java_net2 {
//server-socket
	public static void main(String[] args) {
		try {
			//ServerSocket: 서버 컴퓨터에 필요한 정보를 오픈하는 클래스
			ServerSocket ss = new ServerSocket();
			
			//InetSocketAddress: 해당 port를 이용하여 통신을 오픈하는 형태
			InetSocketAddress ia = new InetSocketAddress("192.168.45.171",10000); //10000번 포트를 열겠다. 내 아이피(내 pc임)
			
			//bind = add(바인딩한다.) / append => 정적(자식 생성 후 호출), 동적(부모에게 접근 형태)으로 생성
			ss.bind(ia);
			System.out.println("연결 오픈 중 입니다....");
			
			//소켓을 활성화하는 작업코드 - accept 안쓰면 연결을 못한다.
			Socket sc = ss.accept(); 
			
			
			
			//어떤 pc가 접속했는지 확인할 수 있는 코드 - 이건 클라이언트 ip가 뜬다.
			//client 접속 환경을 체크 - getRemoteSocketAddress() : 상대방의 대한 ip정보 및 접속 환경을 확인하는 메소드
			InetSocketAddress isa = (InetSocketAddress)sc.getRemoteSocketAddress(); //자기 서버환경 확인
			
			//isa.getAddress().getHostAddress() - 해당되는 ip정보를 확인해서 핸들링하는 내용까지 체크를 해야하므로 
			//client 접속 정보를 확인(ip)를 확인
			System.out.println("client 확인: " + isa.getAddress().getHostAddress());
			
			ss.close();
			
			/* - 안써도 관계없음.
			ss.close();
			sc.close();
			*/
			
		} catch (Exception e) {
			System.out.println("해당 포트가 충돌 발생 하였습니다.");
		} 
	}
}
