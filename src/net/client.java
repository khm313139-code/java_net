package net;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
server & client를 각각 개발하여 다음과 같이 실행 되도록 코드를 작성하시오.

[server 실행]
서버 실행 중...

[채팅일 경우]
client message : 안녕하세요

[파일 전송일 경우]
client file: 해당 파일을 d:\\java_net\\upload\\222.jpg로 저장 되었습니다.

-------------------------------------------------------

[client 실행]
다음 메뉴를 선택하여 통신을 사용합니다. [1. 채팅, 2. 파일전송]:

[채팅일 경우]
전송할 메세지를 입력하세요: 안녕하세요 치고 엔터

[파일 전송일 경우]
전송할 파일 경로 및 파일 명을 입력하세요:
d:\\java_net\\download\\123.jpg


*/
public class client {
	static Socket sk = null;
	
	public static void main(String[] args) {
		String ip = "172.30.1.72";
		int port = 10005;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
				System.out.println("클라이언트 서버 접속 시도!!");
				sk= new Socket(ip,port);
				
				OutputStream os = sk.getOutputStream();
				
				System.out.println("다음 메뉴를 선택하여 통신을 사용한다. [1. 채팅, 2. 파일전송]: ");
				String choice = sc.nextLine();
				
				os.write(choice.getBytes());
				os.flush();
				
				
				switch (choice) {
				case "1":
					System.out.println("전송할 메세지를 입력하세요: ");
					String message = sc.nextLine();
					os.write(message.getBytes());
					os.flush();
					break;

				
					
				case "2":
					System.out.println("전송할 파일 경로를 입력하시오: ");
					String path = sc.nextLine();
					File file = new File(path);
					InputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis);
					
					
					byte[] buffer = new byte[1024];
					int size = 0;
					
					while((size =bis.read(buffer)) != -1) {
						os.write(buffer,0,size);
					}
					os.flush();
					bis.close();
					break;		
					
				default:
					System.out.println("잘못된 선택");
					break;
				}
			
					
					
				
				os.close();
				sk.close();
				sc.close();
			

		} catch (Exception e) {
			System.out.println("서버 접속 지연 오류 발생!!");
		}
		
	}

}

