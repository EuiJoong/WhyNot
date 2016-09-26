package attachfile.model;

public class ClassVideoDBBean {
	Integer clnum;
	String filename,filedir;
	
	public Integer getClnum() {
		return clnum;
	}
	public void setClnum(Integer vdnum) {
		this.clnum = vdnum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiledir() {
		return filedir;
	}
	public void setFiledir(String filedir) {
		this.filedir = filedir;
	}
	@Override
	public String toString() {
		return "ClassVideoDBBean [clnum=" + clnum + ", filename=" + filename + ", filedir=" + filedir + "]";
	}
	
	
	
}
