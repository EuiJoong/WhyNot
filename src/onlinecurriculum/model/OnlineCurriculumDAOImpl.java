package onlinecurriculum.model;

import java.util.List;

import attachfile.model.ClassVideoDBBean;
import attachfile.model.TextDBBean;
import onlinecurriculum.mybatis.OnlineCurriculumMybatis;

public class OnlineCurriculumDAOImpl implements OnlineCurriculumDAO {

	@Override
	public List getCurriculum(OnlineCurriculumDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumDAOImpl_getCurriculum() 角青");
		return OnlineCurriculumMybatis.getCurriculum(dto);
	}

	@Override
	public List<OnlineCurriculumDBBean> listCurriculum(int lsnum) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumDAOImpl_listCurriculum() 角青");
		return OnlineCurriculumMybatis.listCurriculum(lsnum);
	}

	@Override
	public void insertCurriculum(OnlineCurriculumDBBean oc_dto ,TextDBBean t_dto, ClassVideoDBBean v_dto) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumDAOImpl_insertCurriculum() 角青");
		OnlineCurriculumMybatis.insertCurriculum(oc_dto, t_dto, v_dto);
		
	}

	@Override
	public void updateCurriculum(OnlineCurriculumDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCurriculum(OnlineCurriculumDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLsnum(int ocnum) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumDAOImpl_getLsnum() 角青");
		return OnlineCurriculumMybatis.getLsnum(ocnum);
	}

}
