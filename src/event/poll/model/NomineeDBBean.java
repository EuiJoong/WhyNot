package event.poll.model;

public class NomineeDBBean {

	private int nomiNum;
	private String nomiName;
	private int score;
	private int eventNum;
	
	public int getNomiNum() {
		return nomiNum;
	}
	public void setNomiNum(int nomiNum) {
		this.nomiNum = nomiNum;
	}
	public String getNomiName() {
		return nomiName;
	}
	public void setNomiName(String nomiName) {
		this.nomiName = nomiName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getEventNum() {
		return eventNum;
	}
	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}
}
