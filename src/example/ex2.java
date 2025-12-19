package example;

//상속 클래스

public class ex2 {

	public static void main(String[] args) {
		new ex2_box().today();

	}

}



//extends : 상속 받았음 => void aaa() => default / public void aaa() => public 
class ex2_box extends ex_ab{
	
	@Override
	void userinfo() {
		
	}
	
	public void today() {
		String day = super.datecheck("yyyy-MM-dd hh:mm:ss");    //super 상속 받았을 때 사용 
		System.out.println(day);
	}
}