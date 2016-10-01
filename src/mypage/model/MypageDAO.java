package mypage.model;

public interface MypageDAO {
	
	public boolean validPasswd(int mnum, String pswd);
	public int updatePasswd(int mnum, String updatePw);
	public int profimageMerge(ProfimageDBBean pi);

}
