package net;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//tcp - client (i/o) - 파일처리 

public class java_net11 {

	public static void main(String[] args) {
		java_net11_client jc = new java_net11_client("172.30.1.72", 10006);

	}

}


class java_net11_client{
	
	//tcp 방식
		String ip = null;
		int port = 0;
		Scanner sc = null; //scanner를 이용하여 경로를 입력하는 형태
		Socket sk = null;
		InputStream is = null;
		OutputStream os = null;
	
	
	public java_net11_client(String serverip, int serverport) {
		this.ip = serverip;
		this.port = serverport;
		this.sc = new Scanner(System.in);
		this.ftp_client();
	}
	
	private void ftp_client() {
		try {
			
			this.sk = new Socket(this.ip,this.port); //서버에 접속 정보를 넣는다.
			System.out.println("업로드할 이미지 경로를 입력하세요 : ");
			//자신의 pc에 있는 파일 메모리를 이용하여 읽어들임
			String url = this.sc.nextLine();
			this.is = new FileInputStream(url);
			BufferedInputStream bs = new BufferedInputStream(is);
			byte img[] = new byte[bs.available()]; //버퍼(메모리)는 한번에 읽을 수가 있다.
			bs.read(img);
			
			//서버에 송신
			this.os = this.sk.getOutputStream();
			this.os.write(img);
			this.os.flush();
			
			bs.close();
			this.os.close();
			this.sc.close();
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("서버에 접근이 원활하지 않습니다.");
		} 
			
		

		
	}
	
	
	
}