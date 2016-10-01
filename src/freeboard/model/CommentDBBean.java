package freeboard.model;
public class CommentDBBean {

	private int cbnum; //댓글번호
	private int bnum; //글번호
	private String name; //작성자
	private int mnum;	//작성자 번호
	private String reg_date; //쓴 시간
	private String content; //내용
	
	public int getCbnum() {
		return cbnum;
	}
	public void setCbnum(int cbnum) {
		this.cbnum = cbnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}


