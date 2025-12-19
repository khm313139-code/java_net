package example;

/*
자바의 전체적인 파트

- oop => 조건문, 반복문, 선택문, class, method, 배열, 예외처리, dto, dao, 상속 class, interface, 자료형

- thread => thread(클래스), runnable(인터페이스)

- i/o(input/output) - 파일, 문서
=> io/nio
=> reader, writer => .txt => printwriter => javascript
=> buffered => 핵심
=> stream => inputstream, outputstream => byte단위 + buffered
=> writer, outputstream => flush() 메소드 활용
=> close();

- network => osi 7 계층
=> 1계층과 2계층에 해당 => network interface
=> 3계층 => internet => ip, gateway, dns
=> 4계층 => java => tcp, udp
=> 5계층 => servlet => http, dns, ftp, snmp, smtp... 
=> 6,7계층 => 보안 => 전송방식

=> URL => 외부에서 http => 접근
=> inetaddress => ipv4 / ipv6 => port

*/

/*
//ipv6 확인법
try { 
		String ip6 = "fe80::9980:5413:8ee2:347e%11";
		InetAddress addr = Inet6Address.getByName(ip6);
		if (addr.getClass() == Inet6Address.class) {
			System.out.println("해당 IP는 IPv6 입니다.");
		}
		
		}catch (Exception e) {
			
		}

*/

public class ex1 {
	
	public static void main(String[] args) {
		
	}

}
