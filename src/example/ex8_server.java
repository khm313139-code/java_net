package example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ex8_server {

	public static void main(String[] args) {
		String[][] userArray = {
			    {"user01", "pw1234", "강하늘", "sky.kang@example.com"},
			    {"sunny_day", "sunny77", "조은비", "eunbi.cho@testmail.io"},
			    {"coffee_lover", "latte5050", "윤도현", "dohyun.yoon@provider.net"},
			    {"coding_king", "java8888", "임지민", "jimin.lim@dummymail.org"},
			    {"traveler_v", "trip1004", "한소희", "sohee.han@sample.com"}
			};

		
		try {
			ServerSocket server = new ServerSocket(10000);
			System.out.println("서버 대기중...");
			
			Socket client = server.accept();
			System.out.println("클라이언트 접속됨");
		
		
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			OutputStream os = client.getOutputStream();
	
			
			String id = br.readLine();
			String pw = br.readLine();
			
			boolean login = false;
			
			for(int i=0; i< userArray.length; i++) {
				if(userArray[i][0].equals(id)&&userArray[i][1].equals(pw)) {
					login = true;
					break;
				}
				
				
			}
			
			String result;
			
			if(login==true) {
				result = "로그인 하셨습니다.";
			}
			else {
				result = "아이디 및 패스워드를 확인하세요";
			}
			
			os.write(result.getBytes());
			os.flush();
			
			br.close();
			os.close();
			
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
