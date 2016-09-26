package onlinecurriculum.qna.model;

import java.util.List;

public interface OnlineCurriculumQNADAO {
	public List listOnlineContentQa(int lsnum);
	public void insertOnlineContentQa(OnlineCurriculumQNADBBean ocqna);
	public void answerOnlineContentQa(OnlineCurriculumQNADBBean ocqna);
	public void deleteOnlineContentQa(int qanum, int mnum);
} 
