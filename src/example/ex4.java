package example;

//io 파트

public class ex4 {

	public static void main(String[] args) {
		new ex4_box().file_url();

	}

}

class ex4_box extends ex4_ab{
	@Override
	void file_url() {
		super.file_writer("d:\\", "memo.txt");
		System.out.println("입력된 내용이 정상적으로 저장 되었습니다.");
		
	}
}
