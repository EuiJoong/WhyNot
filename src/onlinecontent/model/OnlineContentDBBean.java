package onlinecontent.model;

import attachfile.model.PhotoDBBean;

public class OnlineContentDBBean {
	Integer ocnum; 	//�¶�����������ȣ
	Integer ctnum; 	//ī�װ���ȣ
	Integer mnum;	//�ۼ���
	String title;	//����
	String content;	//����
	Integer price;	//����
	Integer ptnum;	//������ȣ
	Integer vdnum;	//�������ȣ
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
