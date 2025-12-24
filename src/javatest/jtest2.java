package javatest;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
[문항2]  인증번호 난수 6자리를 생성하는 코드를 작성 후 사용자가 인증번호를 입력하는 프로세서를 제작해야 합니다.
[결과]
인증번호 : 562214
동일한 인증번호 입력 :

단, 인증번호와 다른 경우 "인증번호를 확인 후 동일한 번호를 입력하세요" 이며, 동일할 경우 "인증이 완료 되었습니다." 라고 콘솔로 출력합니다.
*/
public class jtest2 {

	public static void main(String[] args) {
		new jtest2_box().eee();
	}
}

class jtest2_box {
	public void eee() {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		String ck1 = "";
		for(int i = 0; i<6; i++) {
			ck1 += rd.nextInt(10);
		}
		
		System.out.println("인증번호 : " +ck1);
		System.out.println("동일한 인증번호 입력: ");
		String input = sc.next();
		
		if(ck1.equals(input)) {
			System.out.println("인증이 완료 되었습니다.");
		}
		else {
			System.out.println("인증번호를 확인 후 동일한 번호를 입력하세요!!");
		}
	}
}
