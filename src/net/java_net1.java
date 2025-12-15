package net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;

/*
네트워크 JAVA
ipv4: 32bit로 구성 (0.0.0.0) 0 ~ 255 => 172.30.1.254
ipv6: 128bit로 구성 0:0:0:0:0:0:0:0 => 2001:0dba:aac9:0000:0067:8a2e:0000:7321 이런식으로 형성
ipv6는 고갈이 되려면 멀었음.

Netmask(서브넷 마스크) - 다른 네트워크에 속하는지, 같은 네트워크에 속하는지 확인하는 정보 
255.0.0.0 - 소수의 호스트 수(매우 많은 호스트 수 0~255) - 이 뿌리에서 나올 수 있는 가지수가 많다. A클래스
255.255.0.0 - 중간 호스트 수 - 중간 호스트 수 0~255 B클래스
255.255.255.0  - 다수의 호스트 수를 말함(얘를 제일 많이 볼 수 있다.) - 적은 호스트 수 255 C클래스

192.168.0.1(공유기), 192.168.0.255(게이트 웨이) - 이렇게는 우리가 개인 PC IP로 사용할 수 없음
2~254까지 사용가능

유동ip(dynamic ip) => 지속적으로 할당 ip가 변동됨, 고정ip(static ip) => 고정적인 ip 할당, 고정 ip는 비용이 비싸다.(vpn 사용하는거)

port => 네트워크 => 포트는 중복시 무조건 통신 불능
0~1500 => 실제 서비스 되는 port가 많음
1501~9000 => 각 app에 할당 되는 port가 많음.
9001~10000 => 임시 포트에 연결
10001~50000 => 테스트 포트, 사설포트

TCP, UDP

TCP => 외부망 => HTTP, HTTPS, FTP, Email => 속도는 느린편이다. but 보안같은 신뢰성은 높다.
UDP => 외부망, 내부망 => 온라인 게임(channel들 1channel 2channel => 혼잡 보통 이런 채널 들 / 실시간 스트리밍) => 속도면에서는 빠르다. / 신뢰성 미보장(신뢰성 낮다)
tcp와 udp는 ip중복 나도 에러 안남 따로 돌고 있는 프로토콜
*/
public class java_net1 {

	public static void main(String[] args) {
		try {
		
			/*
			 * inetaddress : 도메인 ip를 이용하여 통신정보를 확인할 수 있음.
			 * getbyname : 접속할 도메인 또는 ip 주소명을 말합니다.
			 */
			
			//Inet4Address ia = (Inet4Address)Inet4Address.getByName("naver.com"); //new 안들어간다. inet4address 때리면 4, 6 다나와서 지정해줘야함.
			InetAddress ia = Inet4Address.getByName("naver.com"); //부모 더 큰거 사용
			System.out.println(ia);
			System.out.println(ia.getHostAddress()); //ip를 출력하는 getter
			System.out.println(ia.getHostName()); //도메인을 출력하는 getter
			
			//getAllByName: 접속할 도메인이나 ip관련 모든 서버 주소의 리스트를 가져옴(배열)
			InetAddress all[] = Inet4Address.getAllByName("coupang.com"); //하나일때는 상관없지만 배열 형태로 여러개면 getbyname안되고 allbyname써야함.
			System.out.println(Arrays.toString(all)); //쿠팡의 모든 서버의 ip 다 조회가능
			//배열 list를 출력
			
		}catch (Exception e) {
			System.out.println("해당 통신이 불안정합니다.");
		}
	}

}











