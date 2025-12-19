package example;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public abstract class ex4_ab {

	InputStream is = null;
	OutputStream os = null;
	String url = "";
	String filename ="";
	private byte allbyte[] = null;
	Scanner sc = null;
	
	
	
	public ex4_ab() {
		this.sc = new Scanner(System.in);
	}
	
	abstract void file_url(); //오버라이드 해야하는 필수 메소드
	
	
	protected void file_writer(String src, String file) { //경로
		this.url = src;
		this.filename = file;
		
		try {
			this.os = new FileOutputStream(this.url + this.filename,true); //여기서 true는 누적시킬 거라서 true
			while(true) {
				System.out.println("입력할 내용을 적어주세요: ");
				String msg = this.sc.nextLine() + "\n";
				if(msg.equals("종료\n")) {
					break;
				}
				this.allbyte = msg.getBytes();
				this.os.write(this.allbyte);
				
				this.os.flush();
			}
			this.os.close();
			
		} catch (Exception e) {
			System.out.println("올바른 파일을 찾을 수 없습니다.");
		}finally {
			this.sc.close();
		}
	}
	
}
