package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

//네트워크 url 정보 현황
//외부에 있는 소스코드 가져올 수 있음
public class java_net5 {

	public static void main(String[] args) {
		String url = "http://www.dsa.or.kr/apply.html?html=apply/nongchon3-1.html";
		
		try {
			URL u = new URL(url);
			URLConnection con = u.openConnection();
			System.out.println(u.getProtocol()); //어떤 프로토콜로 접속인지 확인 => http, https, ftp
			System.out.println(u.getPort()); //도메인 이후 포트번호를 확인할때 사용 / -1이라고 뜨면 포트 지정이 안된 것.
			//도메인: 포트번호 가져옴
			System.out.println(u.getHost()); //실제 도메인명을 가져옴
			System.out.println(u.getFile()); //xcode=180&type=P 파라미터 값 => 실행파일 (경로+파라미터 값을 가져온다.)
			System.out.println(u.getQuery()); //xcode=180&type=P 파라미터 값만 가져오는 getter
			
			
			InputStream is = u.openStream(); //url을 가져와라 - 네트워크에만 씀 //url 경로에만 사용하는 stream
			InputStreamReader isr = new InputStreamReader(is); //안에 있는 내용 읽기 - 소스코드 읽어올 것이니
			//리더는 byte가 아니니 바이트로 변환할 필요가 없다.
			
			BufferedReader br = new BufferedReader(isr); //문자니까 버퍼로 가져옴
			
			
			OutputStream fs = new FileOutputStream("d:\\java_net\\download\\index.html"); //바이트로 저장하겠다.
			OutputStreamWriter osw = new OutputStreamWriter(fs,"UTF8");
			BufferedWriter fw = new BufferedWriter(osw);
			
			String code ="";
			
			while((code = br.readLine())!=null){
				fw.write(code);
			}
			
			fw.flush();
			fw.close();
			br.close();
			
			
			
		} catch (Exception e) {
			System.out.println("해당 url 정보가 올바르지 않습니다.");
		}

	}

}
