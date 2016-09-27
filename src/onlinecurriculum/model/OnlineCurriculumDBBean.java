package onlinecurriculum.model;

public class OnlineCurriculumDBBean {
	
	int clnum,lsnum,ttnum;
	String title;
	
	public int getTtnum() {
		return ttnum;
	}
	public void setTtnum(int ttnum) {
		this.ttnum = ttnum;
	}
	public int getClnum() {
		return clnum;
	}
	public void setClnum(int clnum) {
		this.clnum = clnum;
	}
	public int getLsnum() {
		return lsnum;
	}
	public void setLsnum(int lsnum) {
		this.lsnum = lsnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "OnlineCurriculumDBBean [clnum=" + clnum + ", lsnum=" + lsnum + ", ttnum=" + ttnum + ", title=" + title
				+ "]";
	}
	
	
	
	
}
