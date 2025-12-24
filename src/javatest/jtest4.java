package javatest;

/*
[문항4] PC가 1~50까지의 숫자를 총 10개를 무작위로 추출 합니다. 추출된 값을 배열에 담은 후 내림차순으로 정렬되어 출력되는 코드를 작성하시오. (숫자 중복허용)
*/


import java.util.Arrays;
import java.util.Random;

public class jtest4 {

	public static void main(String[] args) {
		new jtest4_box().bbb();

	}

}


class jtest4_box{
	public void bbb() {
		
		Random rd = new Random();
		int arr[] = new int[10];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = rd.nextInt(50)+1;
		}
		
		Arrays.sort(arr);
		
		//일단 오름차순 됐는지 확인
		//System.out.println(Arrays.toString(arr));
		
		System.out.print("결과: ");
		for(int j = arr.length-1; j >= 0 ; j--) {
			System.out.print(arr[j]+" ");
			
			
		}
	}
}