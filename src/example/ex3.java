package example;

import java.util.ArrayList;
import java.util.Scanner;
/*
응용문제3
상품을 추가하는 프로세서를 제작해야 합니다.
다음과 같이 프로세서 진행 됩니다. 
(abstract를 이용하여 1차배열이 만들어 지는 프로세서)

"추가할 상품명을 입력하세요 : 선풍기"
"추가할 상품명을 입력하세요 : 선풍기 날개"
"추가할 상품명을 입력하세요 : 종료"  
 [결과]
 [선풍기,선풍기 날개] 

*/
import java.util.ArrayList;

public class ex3 extends ex3_ab {
	Scanner sc = null;
	
	@Override
	public void product_in() {
		
		this.sc = new Scanner(System.in);
		System.out.println("추가할 상품명을 입력하세요: ");
		String data = this.sc.nextLine();
		if(data.equals("종료")) {
			
			this.product_out();
			return;
		}
		
	
		this.product.add(data);
		
		product_in();
	}
	
	
	@Override
	public void product_out() {
		System.out.println(this.product);
		
	}
	
	
	
    public static void main(String[] args) {
       /* 내코드
       ex3 e = new ex3();
       ArrayList<String> result = e.userpass();
       System.out.println(result);
       */
    	ex3 e = new ex3();
    	e.product_in();
    	
    }
}

