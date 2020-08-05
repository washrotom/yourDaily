package VO;

import java.sql.Date;

//model.Board.java

public class LiveVO {
	private int num;
	private String id;
	private Date w_date;
	private String title;
	private String content;
	private String path;
	private int type;
	
	public LiveVO() {
		
	}

	public LiveVO(int num, String id, Date w_date, String title, String content, String path, int type) {
		super();
		this.num = num;
		this.id = id;
		this.w_date = w_date;
		this.title = title;
		this.content = content;
		this.path = path;
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public int getType() {
		return type;
	}

	public void setPath(int type) {
		this.type = type;
	}
	

	@Override
	public String toString() {
		return "LiveVO [num=" + num + ", id=" + id + ", w_date=" + w_date + ", title=" + title + ", content=" + content
				+ ", path=" + path + ", type=" + type + "]";
	}
	

}