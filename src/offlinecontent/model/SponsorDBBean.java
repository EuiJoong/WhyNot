package offlinecontent.model;

public class SponsorDBBean {

	private Integer spnum;		// 후원 번호
	private Integer mnum;       // 사용자번호
	private Integer offnum;     // off컨텐츠번호
	private Integer spamount;   // 후원금액
	private String spdate ;     // 후원날짜
	private String particichk;  // 참여여부
	
	public Integer getSpnum() {
		return spnum;
	}
	public void setSpnum(Integer spnum) {
		this.spnum = spnum;
	}
	public Integer getMnum() {
		return mnum;
	}
	public void setMnum(Integer mnum) {
		this.mnum = mnum;
	}
	public Integer getOffnum() {
		return offnum;
	}
	public void setOffnum(Integer offnum) {
		this.offnum = offnum;
	}
	public Integer getSpamount() {
		return spamount;
	}
	public void setSpamount(Integer spamount) {
		this.spamount = spamount;
	}
	public String getSpdate() {
		return spdate;
	}
	public void setSpdate(String spdate) {
		this.spdate = spdate;
	}
	public String getParticichk() {
		return particichk;
	}
	public void setParticichk(String particichk) {
		this.particichk = particichk;
	}
	
	
}
