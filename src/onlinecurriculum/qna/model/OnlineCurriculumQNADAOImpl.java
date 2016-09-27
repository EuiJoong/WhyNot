package onlinecurriculum.qna.model;

import java.util.List;

import onlinecurriculum.mybatis.OnlineCurriculumMybatis;
import onlinecurriculum.qna.mybatis.OnlineCurriculumQNAMybatis;

public class OnlineCurriculumQNADAOImpl implements OnlineCurriculumQNADAO{

	@Override
	public List listOnlineContentQa(OnlineCurriculumQNADBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumQNADAOImpl_listOnlineContentQa() ����");
		return OnlineCurriculumQNAMybatis.listCurriQNA(dto);
	}

	@Override
	public void insertOnlineContentQa(OnlineCurriculumQNADBBean ocqna) { 
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumQNADAOImpl_insertOnlineContentQa() ����");
		OnlineCurriculumQNAMybatis.insertCurriQNA(ocqna);
	}
	
	@Override
	public void answerOnlineContentQa(OnlineCurriculumQNADBBean ocqna) {
		// TODO Auto-generated method stub
		System.out.println("OnlineCurriculumQNADAOImpl_answerOnlineContentQa() ����");
		OnlineCurriculumQNAMybatis.answerCurriQNA(ocqna);
	}
	
	@Override
	public void deleteOnlineContentQa(int qanum, int mnum, int clnum) {
		// TODO Auto-generated method stub
		System.out.println("deleteOnlineContentQa_deleteOnlineContentQa() ����");
		OnlineCurriculumQNAMybatis.deleteCurriQNA(qanum, mnum , clnum);
	}

}
