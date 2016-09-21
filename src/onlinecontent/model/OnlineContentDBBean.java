package onlinecontent.model;

import attachfile.model.PhotoDBBean;

public class OnlineContentDBBean {
	Integer ocnum; 	//온라인컨텐츠번호
	Integer ctnum; 	//카테고리번호
	Integer mnum;	//작성자
	String title;	//제목
	String content;	//내용
	Integer price;	//가격
	Integer ptnum;	//사진번호
	Integer vdnum;	//동영상번호
	PhotoDBBean p_dto;
	
	public PhotoDBBean getP_dto() {
		return p_dto;
	}
	public void setP_dto(PhotoDBBean p_dto) {
		this.p_dto = p_dto;
	}
	public Integer getOcnum() {
		return ocnum;
	}
	public void setOcnum(Integer ocnum) {
		this.ocnum = ocnum;
	}
	public Integer getCtnum() {
		return ctnum;
	}
	public void setCtnum(Integer ctnum) {
		this.ctnum = ctnum;
	}
	public Integer getMnum() {
		return mnum;
	}
	public void setMnum(Integer mnum) {
		this.mnum = mnum;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPtnum() {
		return ptnum;
	}
	public void setPtnum(Integer ptnum) {
		this.ptnum = ptnum;
	}
	public Integer getVdnum() {
		return vdnum;
	}
	public void setVdnum(Integer vdnum) {
		this.vdnum = vdnum;
	}
	
	
	
}
