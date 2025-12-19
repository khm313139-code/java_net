package example;

import java.util.ArrayList;
import java.util.Scanner;

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
=> server 구축 => proxy server => 내부망 / 외부에서는 들어오지 못하고 내부만으로 연결만 되는 망
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


/*

응용문제 1
DTO를 활용하여 2차 클래스에 사용자 정보를 입력하여, 저장하는 코드를 작성합니다.

[실행]
"사용자 아이디 입력하세요 : "
"사용자 패스워드 입력하세요 : "
"사용자 이름 입력하세요 : "
"사용자 이메일 입력하세요 : "
"사용자 연락처 입력하세요 : "
반복 실행

[결과]
[
[hong, a1234, 홍길동, hong@nate.com, 01012345678]
]

*****결과 출력 후 다시 사용자 정보가 입력되도록 합니다.
*/
public class ex1 {
	
	public static void main(String[] args) {
		new ex1_box().abc();
	}
	
}
class ex1_box{
	Scanner sc = null;
	ArrayList<ArrayList<String>> alluser = null;
	ex1_dto dto = new ex1_dto(); //model class 로
	final String mb []= {"아이디","패스워드","이름","이메일","연락처"};
	
	
	public ex1_box() {
		this.sc = new Scanner(System.in);
		this.alluser = new ArrayList<ArrayList<String>>();
	}
	
	public void abc() {
		int w = 0;
		while(w<this.mb.length) {
			System.out.println("사용자 "+this.mb[w]+" 입력하세요 : ");
			String mb = this.sc.nextLine(); //필드에 있는거랑 다른 mb임
			switch (w) {
			case 0:
				this.dto.setMid(mb);
				break;

			case 1:
				this.dto.setMpass(mb);
				break;
			case 2:
				this.dto.setMname(mb);
				break;
			case 3:
				this.dto.setMemail(mb);
				break;
			case 4:
				this.dto.setMtel(mb);
				break;
			
			}
			w++;
		}
		this.alluser.add(this.dto.getAl());
		System.out.println(alluser);
		abc(); //재귀함수 사용
		
		
	}
}
		
		
//내 코드
//		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//		Scanner sc = new Scanner(System.in);
//		
//		
//		while(true) {
//			ex1_dto dto = new ex1_dto();
//			
//			System.out.println("사용자 아이디 입력하세요 : ");
//			dto.setUid(sc.nextLine());
//			System.out.println("사용자 패스워드 입력하세요 : ");
//			dto.setUpw(sc.nextLine());
//			System.out.println("사용자 이름 입력하세요 : ");
//			dto.setUname(sc.nextLine());
//			System.out.println("사용자 이메일 입력하세요 : ");
//			dto.setUem(sc.nextLine());
//			System.out.println("사용자 연락처 입력하세요 : ");
//			dto.setUtel(sc.nextLine());
//			
//			
//			ArrayList<String> user = new ArrayList<String>();
//			user.add(dto.getUid());
//			user.add(dto.getUpw());
//			user.add(dto.getUname());
//			user.add(dto.getUem());
//			user.add(dto.getUtel());
//			
//			result.add(user);
//			
//			System.out.println(result);
//			
//			
//			System.out.println("계속 입력할래?(y/n) ");
//			String yn = sc.nextLine();
//			
//			if(yn.equalsIgnoreCase("n")) {
//				break;
//			}
//		}
//}
//}


