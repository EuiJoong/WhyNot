package requestboard.model;

public class RequestBoardDBBean {

	private int bnum; //글번호
	private String id; //작성자
	private int mnum;
	private String subject; //재목
	private String reg_date; //쓴 시간
	private int readcount; //읽은수
	private String content; //내용
	private int push;
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPush() {
		return push;
	}
	public void setPush(int push) {
		this.push = push;
	}
	
	
}
