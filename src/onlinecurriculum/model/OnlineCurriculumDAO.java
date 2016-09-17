package onlinecurriculum.model;

import java.util.List;

public interface OnlineCurriculumDAO {
	public OnlineCurriculumDBBean getCurriculum(int num); //강의실
	public List<OnlineCurriculumDBBean> listCurriculum(); //켄텐츠 상세page에서 커리큘럼 목록
	public void insertCurriculum(OnlineCurriculumDBBean dto ,int num); //등록
	public void updateCurriculum(OnlineCurriculumDBBean dto ,int num); //수정
	public void deleteCurriculum(OnlineCurriculumDBBean dto ,int num); //삭제
}
