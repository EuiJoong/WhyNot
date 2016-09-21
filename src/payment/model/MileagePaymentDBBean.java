package payment.model;

public class MileagePaymentDBBean {
	private int mbnum;
	private int mnum;
	private String bdate;
	private int amount;
	private int bway;
	
	public int getMbnum() {
		return mbnum;
	}
	public void setMbnum(int mbnum) {
		this.mbnum = mbnum;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBway() {
		return bway;
	}
	public void setBway(int bway) {
		this.bway = bway;
	}
}
