package attachfile.model;

public class TextDBBean {
	Integer ttnum;	//�ؽ�Ʈ���� ��ȣ
	Integer lsnum;	//���ǽ� ��ȣ
	String filename;//���ϸ�
	String fileext;	//Ȯ����
	String filedir;	//���
	
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
