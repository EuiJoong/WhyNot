package onlinecurriculum.model;

import java.util.List;

import attachfile.model.ClassVideoDBBean;
import attachfile.model.TextDBBean;

public interface OnlineCurriculumDAO {
	public OnlineCurriculumDBBean getCurriculum(int num); //강의실
	public List<OnlineCurriculumDBBean> listCurriculum(int lsnum); //켄텐츠 상세page에서 커리큘럼 목록
	public void insertCurriculum(OnlineCurriculumDBBean oc_dto ,TextDBBean t_dto, ClassVideoDBBean v_dto); //등록
	public void updateCurriculum(OnlineCurriculumDBBean dto ,int num); //수정
	public void deleteCurriculum(OnlineCurriculumDBBean dto ,int num); //삭제
	
	public int getLsnum(int ocnum);
}

