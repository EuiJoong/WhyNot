package mypage.model;

public class ProfimageDBBean {
	
	private int pinum;
	private int mnum;
	private String imgname;
	private String imgdir;
	
	public ProfimageDBBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfimageDBBean(int pinum, int mnum, String imgname, String imgext, String imgdir) {
		super();
		this.pinum = pinum;
		this.mnum = mnum;
		this.imgname = imgname;
		this.imgdir = imgdir;
	}

	public int getPinum() {
		return pinum;
	}

	public void setPinum(int pinum) {
		this.pinum = pinum;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getImgdir() {
		return imgdir;
	}

	public void setImgdir(String imgdir) {
		this.imgdir = imgdir;
	}
	 
	
	
}
