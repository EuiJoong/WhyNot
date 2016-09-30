package event.poll.model;

public class CurrPollDBBean {

	Integer nominum;
	String nominame;
	String membermail;
	public String getMembermail() {
		return membermail;
	}
	public void setMembermail(String membermail) {
		this.membermail = membermail;
	}
	Integer score;
	Integer eventnum;
	String eventtitle;
	
	public String getEventtitle() {
		return eventtitle;
	}
	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}
	public Integer getNominum() {
		return nominum;
	}
	public void setNominum(Integer nominum) {
		this.nominum = nominum;
	}
	public String getNominame() {
		return nominame;
	}
	public void setNominame(String nominame) {
		this.nominame = nominame;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getEventnum() {
		return eventnum;
	}
	public void setEventnum(Integer eventnum) {
		this.eventnum = eventnum;
	}
	
	
}
