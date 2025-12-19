package example;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

//http://mekeyace.kbsn.or.kr/example.txt

public class ex5 {

	public static void main(String[] args) {
		String web = "http://mekeyace.kbsn.or.kr/example.txt";
		try {
			URL url = new  URL(web); //경로
			/*
			URLConnection con = url.openConnection(); //실제 연결하는 상황
			
			int filesize = con.getContentLength();
			System.out.println(filesize);
			String filetype = con.getContentType();
			System.out.println(filetype);
			*/
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET"); //HTML - FORM - METHOD(HTML)
			String copys ="d:\\123.txt";
			
			int result = con.getResponseCode();
			//System.out.println(result); //200 뜸 이거 네트워크 코드로 정상이라는 거임
			
			if(result ==200) {
				System.out.println("정상적인 파일 입니다.");
				InputStream is = con.getInputStream();
				
				
				FileOutputStream fos = new FileOutputStream(copys);
				
				byte by[] = new byte[1024];
				int w;
				while((w= is.read(by))!=-1) {
					fos.write(by,0,w);
					fos.flush();
				}
				con.disconnect();
			}
			else if(result == 404) {
				System.out.println("올바른 파일 및 경로가 아닙니다.");
			}
			
			
		} catch (Exception e) {
			System.out.println("해당 웹 경로 및 파일이 올바르지 않습니다.");
		}
		
		

	}

}
