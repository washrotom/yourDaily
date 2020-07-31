package VO;

public class LiveVO {
	private String name;
	private String title;
	private String content;
	
	public LiveVO() {
		
	}
	public LiveVO(String name, String title, String content) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "LiveVO [name=" + name + ", title=" + title + ", content=" + content + "]";
	}
	
}
