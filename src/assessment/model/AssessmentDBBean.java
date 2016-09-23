package assessment.model;

//CategoryDTO
public class AssessmentDBBean { 
	private int asnum;
	private int ocnum;
	private String person;
	private String content;
	private int grademark;
	private String reg_date;
	
	public int getAsnum() {
		return asnum;
	}
	public void setAsnum(int asnum) {
		this.asnum = asnum;
	}
	public int getOcnum() {
		return ocnum;
	}
	public void setOcnum(int ocnum) {
		this.ocnum = ocnum;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGrademark() {
		return grademark;
	}
	public void setGrademark(int grademark) {
		this.grademark = grademark;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
}
