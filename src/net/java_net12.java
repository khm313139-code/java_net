package net;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//tcp 통신 multi server + thread

public class java_net12 {

	public static void main(String[] args) {
		int op[]={11000,11001,11002}; //원시배열 - 이거 실행하는 순간 포트 3개 열림 (멀티 포트)
		//서버 포트 리스트 배열
		int w = 0;
		while(w<op.length) {
			java_net12_server js = new java_net12_server("172.30.1.10",op[w]);
			js.start(); //js객체를 만들고 각각의 js를 실행시킴 => 여러개 포트 open가능
			//thread run()메소드를 가동
			w++;
		}

	}

}

//부모 thread 클래스
class java_net12_server extends Thread{//포트가 하나 열리게 되면 소켓은 더이상 작동하지 않는다.
	//여러개 포트 한번에 열려면 쓰레드 써야함.
	String ip = null;
	int port = 0;
	Socket sk = null;
	ServerSocket ss =null;

	
	public java_net12_server(String serverip, int serverport) {
		this.ip = serverip;
		this.port = serverport;
	
	}
	//thread 별로 각 port를 오픈하여 접속을 할 수 있도록 적용을 한 상황임
	@Override
		public void run() {
		try {
			this.ss = new ServerSocket(this.port); 
			
			while(true) {
					this.sk = this.ss.accept();
					System.out.println(this.port+"서버오픈!!");
				
					//클라이언트 접속 정보를 확인하기 위한 사항
					InetAddress ia = this.sk.getInetAddress();//누가 접속했는지 알기 위해
					String client_ip = ia.getHostAddress();
					int client_port = this.sk.getPort();
					System.out.println("클라이언트 정보: " + client_ip);
					System.out.println("클라이언트 포트: " + client_port);
					
			}
		} catch (Exception e) {
			System.out.println("중복된 port로 인하여 서버가 실행되지 않습니다.");
		}
			super.run();
			
			
		}
	
	
}







