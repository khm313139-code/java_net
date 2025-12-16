package net;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 server & client 각각 개발하여 다음과 같이 실행 되도록 코드 작성
 [server 실행]
 server 실행중...
 [1.선택 채팅일 경우]
 client message :안녕하세요 출력
 [2.파일전송일 경우]
 client file: 해당 파일을  D:\\java_net\\upload\\222.jpg 로 저장되었습니다
 
 --------------------------------------------------------------------
 
 [client 실행]
 다음메뉴를 선택하여 통신을 사용합니다 [1.체팅 2.파일전송]:
 
 [1.선택 채팅일 경우]
 전송할 메세지를 입력하세요:
 [2.파일전송일 경우]
 전송할 파일 경로 및 파일명을 입력하세요:
 D:\\java_net\\download\\222.jpg
 
 */
public class server{
	public static void main(String[] args) {
		new serverbox("172.30.1.10",10005);
	}

}

class serverbox{
	String ip=null;
	int port =0;
	
	Socket sk=null;
	ServerSocket ss=null;  
	InputStream is=null;
	OutputStream os=null;
	Scanner sc=null;
	
	public serverbox(String serverip,int serverport) {
		this.ip=serverip;
		this.port=serverport;
		
		this.ftp_server();
	}
	public void ftp_server() {
		try {
			
			this.ss=new ServerSocket(this.port);
			System.out.println("server 실행중...");
			this.sk=this.ss.accept();
			
			this.is = sk.getInputStream();
			
			
			int select= this.is.read();   //스위치케이스 읽는것!
			
			switch(select) {  //클라이언트 채팅
			case '1':
	            byte m[]= new byte[2048];
				int len = is.read(m); 
				String result=new String(m, 0, len);
				System.out.println("client message :"+result);
			break;
			
			case '2':  //클라이언트 파일
				String url="D:\\java_net\\upload\\";  //저장할곳
				//클라이언트가 전송한 파일 수신
				this.is=this.sk.getInputStream();
				byte data[]=new byte[2097152];  
				
				//클라이언트 전송한 파일 저장
				this.os=new FileOutputStream(url+"data111.jpg");
				
				int filesize=0;
				while((filesize=this.is.read(data))!=-1) {
					this.os.write(data,0,filesize);
				}
				
					this.os.flush();
					this.os.close();
					
					System.out.println("클라이언트파일 저장완료!");
			break;
			
			default:
				System.out.println("잘못 입력하셨습니다");
	
			}  
			        this.is.close();
		            this.sk.close();
		            this.ss.close();

			 } catch (Exception e) {
		            System.out.println("서버 포트 충돌!");
		        }
		    
	}
}