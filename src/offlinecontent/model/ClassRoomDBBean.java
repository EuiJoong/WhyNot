package offlinecontent.model;

public class ClassRoomDBBean {
	
	private Integer cr_num;	//강의실번호
	private String time;	//강의실시간
	private Integer max_num;//최대인원
	private String addr;	//강의실주소
	private String reserve_date;	//예약날짜
	private String kind;	//종류(대여,사용자)
	
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
