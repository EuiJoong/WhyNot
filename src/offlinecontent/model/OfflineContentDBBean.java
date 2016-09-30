package offlinecontent.model;

import java.util.List;

import attachfile.model.PhotoDBBean;

public class OfflineContentDBBean{

	private Integer offnum;			//�������� ������ ��ȣ
	private Integer ctnum;			//ī�װ� ��ȣ
	private Integer mnum;			//�ۼ��� ��ȣ
	private String title;			//����
	private String content;			//����
	private String period;			//�Ⱓ
	private Integer particnum;		//���� �ο�
	private Integer goal_amount;	//��ǥ �ݾ�
	private Integer min_amount;		//�ּ� �ݾ�
	private Integer sponsor;		//�Ŀ���
	private Integer cr_num;			//���ǽ�
	private Integer ptnum;			//����
	private String reserve_date;	//���೯¥
	
	public Integer getOffnum() {
		return offnum;
	}
	public void setOffnum(Integer offnum) {
		this.offnum = offnum;
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
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Integer getParticnum() {
		return particnum;
	}
	public void setParticnum(Integer particnum) {
		this.particnum = particnum;
	}
	public Integer getGoal_amount() {
		return goal_amount;
	}
	public void setGoal_amount(Integer goal_amount) {
		this.goal_amount = goal_amount;
	}
	public Integer getMin_amount() {
		return min_amount;
	}
	public void setMin_amount(Integer min_amount) {
		this.min_amount = min_amount;
	}
	public Integer getSponsor() {
		return sponsor;
	}
	public void setSponsor(Integer sponsor) {
		this.sponsor = sponsor;
	}
	public Integer getCr_num() {
		return cr_num;
	}
	public void setCr_num(Integer cr_num) {
		this.cr_num = cr_num;
	}
	public Integer getPtnum() {
		return ptnum;
	}
	public void setPtnum(Integer ptnum) {
		this.ptnum = ptnum;
	}
	public String getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}
	
	
}
