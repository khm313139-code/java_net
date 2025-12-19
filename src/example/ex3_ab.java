package example;

import java.util.Scanner;
//http://mekeyace.kbsn.or.kr/example.txt
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
import java.util.Scanner;

public abstract class ex3_ab {
	/* 내코드
	public Scanner sc = new Scanner(System.in);

    public ArrayList<String> userpass() {
    	ArrayList<String> pr = new ArrayList<String>();

    	while(true) {
    		System.out.println("추가할 상품명을 입력하세요 : ");
    		String name =  sc.nextLine();
    		
    		if(name.equals("종료")) {
    			
    			break;
    		}
    		pr.add(name);
    		
    		
    	}
    	return pr;
    }*/
    
	
	//강사님 코드
	ArrayList<String> product = null;
	public ex3_ab() {
		this.product = new ArrayList<String>();
	}
	
	abstract public void product_in();
	abstract public void product_out();
	
	
	
	
	
	
	
	
	
}
