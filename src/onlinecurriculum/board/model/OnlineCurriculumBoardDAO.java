package onlinecurriculum.board.model;

import java.util.List;

public interface OnlineCurriculumBoardDAO {
	public int getCount();
	public List<OnlineCurriculumBoardDBBean> list(int startRow, int endRow);
	public void count(int num);
	public OnlineCurriculumBoardDBBean getBoard(int num);
	public void insertBoard(OnlineCurriculumBoardDBBean dto, int num);
	public void deleteBoard(OnlineCurriculumBoardDBBean dto, int num);
	public void updateBoard(OnlineCurriculumBoardDBBean dto, int num); 
} 
