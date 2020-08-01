package model;

import java.util.Date;

public class Comment {
	private int idx;
	private String name;
	private String password;
	private String content;
	private Date rdate;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
	
	
	@Override
	public String toString() {
		return "Comment [idx=" + idx + ", name=" + name + ", password=" + password + ", content=" + content + ", rdate="
				+ rdate + "]";
	}
	


}
