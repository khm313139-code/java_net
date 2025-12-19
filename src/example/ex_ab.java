package example;
//추상 클래스

import java.text.SimpleDateFormat;
import java.util.*;





public abstract class ex_ab {
	private Date times = null; //날짜
	Scanner sc = null;
	
	public ex_ab() { //private 쓰기 위한 즉시실행
		//즉시 실행은 상속 받은 클래스에서 즉시 실행 new를 사용시 발동
		this.useremail();
	}
	
	//private : 내부 추상 클래스에서만 사용가능하며, 상속 받는 클래스에서 직접 로드는 불가능하다.
	private void useremail() { //이거 쓰고 싶으면 즉시 실행 시켜야함
		System.out.println("추상 클래스 내부 메소드 출력!!");
	}
	
	
	abstract void userinfo(); //default(void만 있는거) / public 붙이는거 사용가능 여기에 사용할 수 있는 것 
	
	//abstract protected void userpass(); //이러면 같은 패키지 안에서만 사용하겠다.
	
	
	//추상 클래스에 있는 메소드를 활용해서 메인 클래스에서 사용하기 위함
	public String datecheck(String part) {
		this.times = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(part);
		String dates = sf.format(this.times);
		
		return dates;
	}
}
