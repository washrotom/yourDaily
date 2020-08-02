package VO;

//model.Member.java
public class SignVO {
	private String id;
	private String pwd;
	private String name;
	private int type;
	
	public SignVO() {}

	public SignVO(String id, String pwd, String name, int type) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SignVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", type=" + type + "]";
	}
}
