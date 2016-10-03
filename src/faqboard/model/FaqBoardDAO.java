package faqboard.model;

import java.util.List;


public interface FaqBoardDAO {

	 public List<FaqcodeDBBean> codelist();
	 public List<FaqboardDBBean> getwholeboardlist();//ÀüÃ¼
	 public List<FaqboardDBBean> boardlist(int code);
	 public void faqcodeinsert(FaqcodeDBBean dto);
	 public void insertfaqboard(FaqboardDBBean FaqBoardDto);
	 public boolean checkCode(String code);
	 public void deletcode(String code);
	 public void UpdateCode(FaqcodeDBBean codeDto);
	 public FaqboardDBBean getfaqboard(int qnum);
	 public void updatefaqboard(FaqboardDBBean boarddto);
	 public void deletfaqboard(int qnum);
	 
	 public int getCodeCount();
}
