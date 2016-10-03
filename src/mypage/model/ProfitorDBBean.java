package mypage.model;

public class ProfitorDBBean {

		private Integer penum;
		private Integer mnum;
		private String content;
		public ProfitorDBBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ProfitorDBBean(int penum, int mnum, String content) {
			super();
			this.penum = penum;
			this.mnum = mnum;
			this.content = content;
		}
		public int getPenum() {
			return penum;
		}
		public void setPenum(int penum) {
			this.penum = penum;
		}
		public int getMnum() {
			return mnum;
		}
		public void setMnum(int mnum) {
			this.mnum = mnum;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}		
}
