package javatest;

import java.util.Scanner;

/*
[문항1]  사용자가 숫자 하나를 입력합니다.
단, 숫자 이외에 단어를 입력시 "숫자만 입력하세요" 라는 예외처리 후 "숫자를 입력하세요 : " 를 다시 실행 되도록 합니다.
숫자 입력 후 "짝수" 혹은 "홀수"인지를 결과를 콘솔로 출력하는 코드를 작성하시오.
*/

public class jtest1 {

	public static void main(String[] args) {
		new jtest1_box().aaa();

	}

}

class jtest1_box{
	Scanner sc = new Scanner(System.in);
	
	public void aaa() {
	
		while(true) {
			System.out.println("숫자를 입력하세요: ");
			try {
				int num = sc.nextInt();
				if(num%2==0) {
					System.out.println("짝수");
				}
				else {
					System.out.println("홀수");
				}
				break;
			
			}catch (Exception e) {
				System.out.println("숫자만 입력하세요!!");
				sc.nextLine();
			}
		}
	}
}