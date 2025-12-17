package net;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//udp 통신으로 파일 송수신 - server
public class udp_file_server {

	public static void main(String[] args) throws Exception {
		new file_server(23000);

	}
}



class file_server{
	DatagramPacket dp = null;
	DatagramSocket ds = null;
	//fileoutputstream => dataoutputstream(발전된 상황) - buffered가 붙어있다. dataoutputstream은 단독으로 쓰는 경우 없음.
	FileOutputStream fos = null; 

	String result; //경로 쓸 것임.
	File f = null;
	int port = 0;
	
	public file_server(int port) throws Exception {
		this.port = port;
		this.save_files();
	}
	
	public void save_files() throws Exception{
		try {
			this.result = "d:\\java_net\\download\\file.jpg";
			this.f = new File(this.result);
			System.out.println("FTP 서비스가 오픈 되었습니다.");
			this.ds = new DatagramSocket(this.port);
			
			/*
			1024를 고정으로 잡는 경우 : txt, hwp
			일반문서 및 이미지 5kb (5120) : jpg, png (10mb)
			동영상 : 1mb(1048576) ~ 3mb => byte
			*/
			
			byte by[] = new byte[2048];
			this.fos = new FileOutputStream(this.f); //파일을 가져왔음. 이 상태에서 저장
			
			for(;;) {

				this.dp = new DatagramPacket(by, by.length);
				this.ds.receive(this.dp); //client 수신
				
				
				int bylen = this.dp.getLength();
				if(bylen < by.length) {
					System.out.println("파일 업로드 완료됨");
					break;
				}
				this.fos.write(by,0,bylen);
			}
			this.fos.close();
			
			


			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UDP 서버 포트 충돌 발생");
		}
			}
	
		}
	
