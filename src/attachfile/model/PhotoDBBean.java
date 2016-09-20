package attachfile.model;

public class PhotoDBBean {
	Integer ptnum;	//사진 번호
	Integer mnum;	//회원 번호
	String filename;//파일명
	String fileext;	//확장자
	String filedir;	//경로
	
	public Integer getPtnum() {
		return ptnum;
	}
	public void setPtnum(Integer ptnum) {
		this.ptnum = ptnum;
	}
	public Integer getMnum() {
		return mnum;
	}
	public void setMnum(Integer mnum) {
		this.mnum = mnum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileext() {
		return fileext;
	}
	public void setFileext(String fileext) {
		this.fileext = fileext;
	}
	public String getFiledir() {
		return filedir;
	}
	public void setFiledir(String filedir) {
		this.filedir = filedir;
	}
	
}
