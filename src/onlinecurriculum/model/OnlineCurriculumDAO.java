package onlinecurriculum.model;

import java.util.List;

import attachfile.model.ClassVideoDBBean;
import attachfile.model.TextDBBean;

public interface OnlineCurriculumDAO {
	public OnlineCurriculumDBBean getCurriculum(int num); //���ǽ�
	public List<OnlineCurriculumDBBean> listCurriculum(int lsnum); //������ ��page���� Ŀ��ŧ�� ���
	public void insertCurriculum(OnlineCurriculumDBBean oc_dto ,TextDBBean t_dto, ClassVideoDBBean v_dto); //���
	public void updateCurriculum(OnlineCurriculumDBBean dto ,int num); //����
	public void deleteCurriculum(OnlineCurriculumDBBean dto ,int num); //����
	
	public int getLsnum(int ocnum);
}

