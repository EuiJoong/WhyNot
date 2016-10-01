package requestboard.model;

import java.util.List;


public interface RequestBoardDAO {
	
	public int getCount();//전채 수 구하기
	public List listBoard(int startRow, int endRow);
	public void count(int bnum);
	public RequestBoardDBBean getBoard(String mode, int bnum);
	public void insertBoard(RequestBoardDBBean dto);
	public void deleteBoard(int bnum);
	public void updateBoard(RequestBoardDBBean dto);
	public int chk(int bnum);
	public void push(int bnum);

}
