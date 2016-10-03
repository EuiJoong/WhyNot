package faqboard.model;

public class FaqboardDBBean {
	private int qnum;
	private String faq_code;
	private String title;
	private String content;

	
	
	
	public int getQnum() {
		return qnum;
	}
	public void setQnum(int qnum) {
		this.qnum = qnum;
	}
	
	public String getFaq_code() {
		return faq_code;
	}
	public void setFaq_code(String faq_code) {
		this.faq_code = faq_code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
