package assessment.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import assessment.mybatis.AssessmentMybatis;
public class AssessmentDAOImpl implements AssessmentDAO {


	
//	@Override
//	public AssessmentDBBean getCategory(int ctnum) {
//		// TODO Auto-generated method stub
//		System.out.println("CategoryDAOImpl_insertCategory() ����");
//		System.out.println("����!");
//		return AssessmentMybatis.getCategory(ctnum); 
//	}

	@Override
	public List listAssessment(int ocnum) {
		System.out.println("AssessmentDAOImpl_ListAssessment() ����");
		return AssessmentMybatis.listAssessment(ocnum); 
	} 

	@Override
	public void insertAssessment(AssessmentDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("Assessment_insertAssessment() ����");
		AssessmentMybatis.insertAssessment(dto); 
		System.out.println("����!");
	}


}
