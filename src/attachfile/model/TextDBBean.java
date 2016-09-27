package attachfile.model;

public class TextDBBean {
	Integer ttnum;	//텍스트파일 번호
	Integer lsnum;	//강의실 번호
	String filename;//파일명
	String fileext;	//확장자
	String filedir;	//경로
	
	public Integer getTtnum() {
		return ttnum;
	}
	public void setTtnum(Integer ttnum) {
		this.ttnum = ttnum;
	}
	public Integer getLsnum() {
		return lsnum;
	}
	public void setLsnum(Integer lsnum) {
		this.lsnum = lsnum;
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
	@Override
	public String toString() {
		return "TextDBBean [ttnum=" + ttnum + ", lsnum=" + lsnum + ", filename=" + filename + ", fileext=" + fileext
				+ ", filedir=" + filedir + "]";
	}
	
}
