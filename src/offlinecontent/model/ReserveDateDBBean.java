package offlinecontent.model;

public class ReserveDateDBBean {
	
	private String reserve_date;	//날짜
	private Integer cr_num;			//강의실번호
	private String cl_reserve_stats;//강의실예약상태
	public String getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}
	public Integer getCr_num() {
		return cr_num;
	}
	public void setCr_num(Integer cr_num) {
		this.cr_num = cr_num;
	}
	public String getCl_reserve_stats() {
		return cl_reserve_stats;
	}
	public void setCl_reserve_stats(String cl_reserve_stats) {
		this.cl_reserve_stats = cl_reserve_stats;
	}
	
	
}
