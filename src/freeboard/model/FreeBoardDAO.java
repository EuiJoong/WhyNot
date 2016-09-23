package freeboard.model;

import java.util.List;


public interface FreeBoardDAO {
	
	public int getCount();
	public List list(int startRow, int endRow);
	public void count(int num);
	public FreeBoardDBBean getBoard(String mode, int num);
	public void insertBoard(FreeBoardDBBean dto, int num);
	public void deleteBoard(FreeBoardDBBean dto, int num, String passwd);
	public void updateBoard(FreeBoardDBBean dto, int num, String be_passwd);
}
