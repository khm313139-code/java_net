package example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
java 실기 시험 
해당 사용자의 배열을 이용하여 로그인을 하는 프로세서를 제작합니다.
각 개발자는 server 파트와 client 파트를 나누어서 협업 제작합니다.

[client 실행]
"아이디를 입력하세요: "
"패스워드를 입력하세요: "

[결과]
로그인 하셨습니다. 또는 아이디 및 패스워드가 없을 경우
"아이디 및 패스워드를 확인하세요"

[server]
client에서 받은 정보를 활용하여 제공한 사용자 정보 배열에 대입하여
맞는 결과 값을 client에게 다시 회신해 주시면 됩니다.

String[][] userArray = {
    {"user01", "pw1234", "강하늘", "sky.kang@example.com"},
    {"sunny_day", "sunny77", "조은비", "eunbi.cho@testmail.io"},
    {"coffee_lover", "latte5050", "윤도현", "dohyun.yoon@provider.net"},
    {"coding_king", "java8888", "임지민", "jimin.lim@dummymail.org"},
    {"traveler_v", "trip1004", "한소희", "sohee.han@sample.com"}
};

*/
public class test_client {

	public static void main(String[] args) {
		new make_client().aaa();

	}

}

class make_client{
	Scanner sc = new Scanner(System.in);
	
	String ip = "172.30.1.68";
	int port = 10000;
	
	public void aaa() {
		try {
			OutputStream os = null;
			InputStream is = null;
			String result = "";
			while(true) {
			Socket socket = new Socket(ip,port);
			
			os = socket.getOutputStream();
			is = socket.getInputStream();
			
			System.out.println("아이디를 입력하세요: ");
			String uid = sc.nextLine();
			
			System.out.println("패스워드를 입력하세요: ");
			String pwd = sc.nextLine();
			
			os.write((uid+"\n").getBytes()); //server가 readline으로 받기로 하여 필요해서 넣어둠.
			os.write((pwd+"\n").getBytes());
			os.flush();
			
			byte buffer[] = new byte[1024];
			int size = is.read(buffer);
			
			result = new String(buffer, 0, size);
			System.out.println(result);
			if(result.equals("로그인 하셨습니다.")) {
				break;
			}
			is.close();
			os.close();
			}
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("포트 충돌로 인하여 네트워크 접속 불가");
		}
		
	}
	
	
}
