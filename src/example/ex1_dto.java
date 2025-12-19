package example;
//ex1에 dto 파일 => dto => getter, setter

import java.util.ArrayList;

public class ex1_dto {
	String mid, mpass, mname, memail, mtel;
	ArrayList<String> al; 
	
	//getter => 무조건 return
	//setter => 일반 void

	//dto => setter 매개변수에 값을 먼저 이관을 해야함
	//1. set이 먼저 작동
	//2. get(getter) 값으로 결과를 return 
	
	
	//이걸 model이라고 한다.
	
	public ArrayList<String> getAl(){
		ArrayList<String> as = new ArrayList<String>();
		as.add(this.mid);
		as.add(this.mpass);
		as.add(this.memail);
		as.add(this.mname);
		as.add(this.mtel);
		return as; //getter만 필요하고 setter는 필요 없음.
	}
	
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	
	
	
// 내 코드
//	private String uid, upw, uname, uem, utel;
//	
//	
//	public String getUid() {
//		return uid;
//	}
//	public void setUid(String uid) {
//		this.uid = uid;
//	}
//	public String getUpw() {
//		return upw;
//	}
//	public void setUpw(String upw) {
//		this.upw = upw;
//	}
//	public String getUname() {
//		return uname;
//	}
//	public void setUname(String uname) {
//		this.uname = uname;
//	}
//	public String getUem() {
//		return uem;
//	}
//	public void setUem(String uem) {
//		this.uem = uem;
//	}
//	public String getUtel() {
//		return utel;
//	}
//	public void setUtel(String utel) {
//		this.utel = utel;
//	}
	
}

