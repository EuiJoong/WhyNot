package freeboard.model;
import java.util.List;


public interface FreeBoardDAO {
	
	public int freegetCount();//전채 수 구하기
	public List listfreeBoard(int startRow, int endRow);
	public void freecount(int bnum);
	public FreeBoardDBBean getfreeBoard(String mode, int bnum);
	public void insertfreeBoard(FreeBoardDBBean dto);
	public void deletefreeBoard(int bnum);
	public void updatefreeBoard(FreeBoardDBBean dto);
	public int freechk(int bnum);

}
