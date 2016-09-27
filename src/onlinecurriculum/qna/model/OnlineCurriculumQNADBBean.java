package onlinecurriculum.qna.model;

public class OnlineCurriculumQNADBBean {
	private int qanum;
	private int lsnum;
	private int mnum;
	private String content;
	private String createddate;

	public int getQanum() {
		return qanum;
	}

	public void setQanum(int qanum) {
		this.qanum = qanum;
	}

	public int getLsnum() {
		return lsnum;
	}

	public void setLsnum(int lsnum) {
		this.lsnum = lsnum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

}
