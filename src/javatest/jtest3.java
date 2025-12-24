package javatest;

import java.util.Arrays;
/*
[문항3] 원시배열만 이용하여 5번의 숫자 값을 입력 받은 후 해당 배열의 짝수가 몇개 인지를 확인하는 코드를 작성하시오.
숫자를 입력하세요 :

[결과 - 콘솔로 출력]
[15,10,8,1,22]
짝수는 총 3개 입력하였습니다.
*/
import java.util.Scanner;

public class jtest3 {
	public static void main(String[] args) {
		new jtest3_box().ccc();
	}
}

class jtest3_box{
	Scanner sc = new Scanner(System.in);
	public void ccc() {
	
		int arr[] = new int[5];
		int count = 0;
	
			for(int i=0 ; i<arr.length; i++) {
				System.out.println("숫자를 입력하세요: ");
				arr[i] = sc.nextInt();
			
					if(arr[i]%2 == 0) {
						count++;
			}
		
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("짝수는 총 "+ count+"개 입력하였습니다.");
	}
}