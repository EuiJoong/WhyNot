package offlinecontent.model;

public class ClassRoomDBBean {
	
	private Integer cr_num;	//���ǽǹ�ȣ
	private String time;	//���ǽǽð�
	private Integer max_num;//�ִ��ο�
	private String addr;	//���ǽ��ּ�
	private String reserve_date;	//���೯¥
	private String kind;	//����(�뿩,�����)
	
	public Integer getCr_num() {
		return cr_num;
	}
	public void setCr_num(Integer cr_num) {
		this.cr_num = cr_num;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getMax_num() {
		return max_num;
	}
	public void setMax_num(Integer max_num) {
		this.max_num = max_num;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
}
