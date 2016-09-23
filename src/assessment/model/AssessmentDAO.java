package assessment.model;

import java.util.List;

public interface AssessmentDAO {
	
//	public AssessmentDBBean getCategory(int ctnum);
	public List listAssessment(int ocnum);
	public void insertAssessment(AssessmentDBBean dto);
}
