package mypage.model;

import java.util.HashMap;
import java.util.List;

public interface MypageDAO {
	
	public boolean validPasswd(int mnum, String pswd);
	public int updatePasswd(int mnum, String updatePw);
	public int profimageMerge(ProfimageDBBean pi);
	public int profitor(int mnum, String content);
	public HashMap<String, Object> loadProfile(int mnum);
	public ProfimageDBBean getPhoto(int mnum);
	public List getPurchaseOncont(int mnum);
	public List getSaleOncont(int mnum);
	public ProfitorDBBean getProfile(int mnum);
}
