package assessment.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import assessment.mybatis.AssessmentMybatis;
public class AssessmentDAOImpl implements AssessmentDAO {


	
//	@Override
//	public AssessmentDBBean getCategory(int ctnum) {
//		// TODO Auto-generated method stub
//		System.out.println("CategoryDAOImpl_insertCategory() 角青");
//		System.out.println("己傍!");
//		return AssessmentMybatis.getCategory(ctnum); 
//	}

	@Override
	public List listAssessment(int ocnum) {
		System.out.println("AssessmentDAOImpl_ListAssessment() 角青");
		return AssessmentMybatis.listAssessment(ocnum); 
	} 

	@Override
	public void insertAssessment(AssessmentDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("Assessment_insertAssessment() 角青");
		AssessmentMybatis.insertAssessment(dto); 
		System.out.println("己傍!");
	}


}
