package net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

//외부 서버에 있는 이미지를 다운로드 받는 통신
//https는 정상적인 작동이 불가능
public class java_net4 {

	public static void main(String[] args) {
		try {
			String url = "d:\\java_net\\download\\"; //여기에 저장하겠음.(저장 위치)
			Scanner sc = new Scanner(System.in);
			System.out.println("웹에서 가져올 이미지 주소를 입력하세요 : ");
			String web = sc.nextLine();
			
			
			//netsork IO => File
			URL u = new URL(web); //사용자가 입력한 url 정보를 가져옴
			URLConnection con = u.openConnection(); //해당 서버로 접근함
			//브라우저로 오픈
			
			int imgsize = con.getContentLength(); //파일 사이즈
			
			System.out.println(imgsize); //접속한 이미지의 파일 사이즈
			long data = con.getDate(); //해당 되는 시간을 표시함 / 접속해서 해당 파일을 가져온 날짜
			System.out.println(data);
			
			InputStream is = u.openStream(); //openStream: 해당 외부 경로에 파일을 바이트로 읽어들임.
			BufferedInputStream bs = new BufferedInputStream(is); //메모리로 빠르게 읽겠다.
			byte b[] = new byte[bs.available() / 2048]; //바이트로 변환 전부 
			//해당 파일을 읽어들이는 사이즈 크기
			//스트림으로 다운 받으니 한번에 다 못 읽어서 이미지 다 못 불러온다.
			//나눠서 때려야함. => / 1024
			
			
			//자신의 pc 경로에 해당 파일을 다운로드 받는 형태
			OutputStream os = new FileOutputStream(url + "223.jpg"); //파일 저장을 위함.
			BufferedOutputStream bos = new BufferedOutputStream(os); //메모리로 빠르게 저장
			int size = 0;
			while((size = bs.read(b))!= -1) { //-1이 되기 전까지 읽어라 저장된 바이트를
				bos.write(b,0,size);
				bos.flush();
			}
			
			
			
			
			bos.close();
			bs.close();
			sc.close();
			System.out.println("해당 서버에 파일을 정상적으로 다운로드 완료 하였습니다.");
			
		} catch (Exception e) {
			System.out.println("해당 서버의 정보가 올바르지 않습니다.");
		}

	}

}
