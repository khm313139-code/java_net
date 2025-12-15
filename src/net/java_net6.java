package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



//buffered는 사용하지 않고 stream만 이용하여 적용
//7과 연결
//문자 통신 서버 - tcp 환경에서 진행 + port +socket 
//server

public class java_net6 {

	public static void main(String[] args) {
		System.out.println("서버 연결 확인!!");
		int port = 10000;
		Scanner sc = new Scanner(System.in);
		try {
			ServerSocket ss = new ServerSocket(port);
			
			
			
			
			while(true) {
			Socket sk = ss.accept();
			
			//클라 => 서버로 메세지 전송
			InputStream is = sk.getInputStream();
			byte m[] = new byte[2048];
			is.read(m);
			String result = new String(m);
			System.out.println("클라이언트 메세지 :" +result);
			
			
			
			
			//서버 => 클라로 메세지 전송
			System.out.println("메세지를 입력하세요: ");
			String message = sc.nextLine();
			OutputStream os = sk.getOutputStream();
			byte msg[] = message.getBytes();
			os.write(msg);
			os.flush();
			os.close();
			is.close();
		
			
			
			}
			
		}catch (Exception e) {
			System.out.println("서버 포트 중복발생 오류!!");
		}
	}
}