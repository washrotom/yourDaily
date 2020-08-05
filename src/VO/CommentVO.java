package VO;



public class CommentVO {
 private int comment_Num;
 private String comment_ID;
 private String comment_Content;
 private int comment_Bnum;
 
 public CommentVO() {}
 public CommentVO(int comment_Num, String comment_ID , String comment_Content , int comment_Bnum) {
		this.comment_Num = comment_Num;
		this.comment_ID = comment_ID;
		this.comment_Content = comment_Content;
		this. comment_Bnum =  comment_Bnum;
		
	}

 



public int getComment_Num() {
	return comment_Num;
}
public void setComment_Num(int comment_Num) {
	this.comment_Num = comment_Num;
}
public String getComment_ID() {
	return comment_ID;
}
public void setComment_ID(String comment_ID) {
	this.comment_ID = comment_ID;
}
public String getComment_Content() {
	return comment_Content;
}
public void setComment_Content(String comment_Content) {
	this.comment_Content = comment_Content;
}
public int getComment_Bnum() {
	return comment_Bnum;
}
public void setComment_Bnum(int comment_Bnum) {
	this.comment_Bnum = comment_Bnum;
}
@Override
public String toString() {
	return "Comment [comment_Num=" + comment_Num + ", comment_ID=" + comment_ID + ", comment_Content=" + comment_Content
			+ ", comment_Bnum=" + comment_Bnum + "]";
}
 


}
