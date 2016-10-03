package onlinecontent.model;

import attachfile.model.PhotoDBBean;

public class OnlineContentDBBean {
	private Integer ocnum; 	//온라인컨텐츠번호
	private Integer ctnum; 	//카테고리번호
	private Integer mnum;	//작성자
	private String title;	//제목
	private String content;	//내용
	private Integer price;	//가격
	private Integer ptnum;	//사진번호
	private Integer vdnum;	//동영상번호
	private PhotoDBBean p_dto;
	private Integer ptnumO;
	private Integer vdnumO;
	private Integer percent;
	
	public Integer getPercent() {
		return percent;
	}
	public void setPercent(Integer percent) {
		this.percent = percent;
	}
	public Integer getPtnumO() {
		return ptnumO;
	}
	public void setPtnumO(Integer ptnumO) {
		this.ptnumO = ptnumO;
	}
	public Integer getVdnumO() {
		return vdnumO;
	}
	public void setVdnumO(Integer vdnumO) {
		this.vdnumO = vdnumO;
	}
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
