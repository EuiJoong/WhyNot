package payment.model;

public class OnlinePaymentDBBean {
	private int pmnum;
	private int mnum;
	private int ocnum;
	private int amount;
	private String pdate;
	
	public int getPmnum() {
		return pmnum;
	}
	public void setPmnum(int pmnum) {
		this.pmnum = pmnum;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getOcnum() {
		return ocnum;
	}
	public void setOcnum(int ocnum) {
		this.ocnum = ocnum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
}
