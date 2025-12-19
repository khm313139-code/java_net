package example;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
응용문제4
해당 웹페이지에서 이미지를 모두 다운로드 받아야 합니다.
해당 이미지가 자신의 PC에 정상적으로 다운로드 될 수 있도록 코드를 작성하시오
http://mekeyace.kbsn.or.kr/product01.webp
http://mekeyace.kbsn.or.kr/product02.webp
http://mekeyace.kbsn.or.kr/product03.webp
http://mekeyace.kbsn.or.kr/product04.webp

*/
public class ex6 {

	public static void main(String[] args) {
		
		String ab[] = {"http://mekeyace.kbsn.or.kr/product01.webp", "http://mekeyace.kbsn.or.kr/product02.webp", "http://mekeyace.kbsn.or.kr/product03.webp","http://mekeyace.kbsn.or.kr/product04.webp"};
		
		int i = 0;
		
			while(i<ab.length) {
				InputStream is = null;
				FileOutputStream fos = null;
				HttpURLConnection con = null;
				
				try {
				URL url = new URL(ab[i]);
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				int code = con.getResponseCode();
				
				if(code==200) {
					is = con.getInputStream();
					
					String filename = ab[i].substring(ab[i].lastIndexOf("/")+1);
					String copys = "d:\\"+ filename;
					
					fos = new FileOutputStream(copys);
					
					byte[] buffer = new byte[1024];
					int w;
					
					while((w=is.read(buffer))!=-1) {
						fos.write(buffer,0,w);
					}
					
					
					
					System.out.println("다운로드 완료: " + copys);
				}
				
				
				
				
			}
		catch (Exception e) {
			System.out.println("다운로드 실패임");
		}finally {
			try {
			if(is!=null) 
				is.close();
					if(fos!=null)
						fos.close();
					if(con!=null)
						con.disconnect();
		}catch (Exception e) {
			
		}
			
			i++;
		}
		
		
		
	
	}

	}
}
