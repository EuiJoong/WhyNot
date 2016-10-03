package faqboard.model;

import java.util.List;

import faqboard.mybatis.FaqBoardmybatis;


public class FaqBoardDAOImpl  implements FaqBoardDAO{

@Override
public List<FaqcodeDBBean> codelist() {
	// TODO Auto-generated method stub
	System.out.println("코드 리스트 출력 하는곳");
	
	
	return FaqBoardmybatis.getcodelist();
}
	
@Override
	public int getCodeCount() {
		// TODO Auto-generated method stub
	
		int count = FaqBoardmybatis.getCodeCount();
		return count;
	}

	@Override
		public List<FaqboardDBBean> boardlist(int code) {
			// TODO Auto-generated method stub
			 
			
			return FaqBoardmybatis.getboardlist(code);
		}
		
	@Override
			public List<FaqboardDBBean> getwholeboardlist() {
				// TODO Auto-generated method stub
			
				return FaqBoardmybatis.getwholeboardlist();
			}	
		
	@Override
			public boolean checkCode(String code) {
				// TODO Auto-generated method stub
				return FaqBoardmybatis.checkcode(code);
			}
	
	
	@Override
			public void faqcodeinsert(FaqcodeDBBean dto) {
				// TODO Auto-generated method stub
			
		FaqBoardmybatis.insertfaqcode(dto);
			}	
	@Override
		public void deletcode(String code) {
			// TODO Auto-generated method stub
			
			FaqBoardmybatis.deletecode(code);
		}
	@Override
		public void UpdateCode(FaqcodeDBBean codeDto) {
			// TODO Auto-generated method stub
		
			FaqBoardmybatis.updatecode(codeDto);
		}
	
	
	@Override
		public void insertfaqboard(FaqboardDBBean FaqBoardDto) {
			// TODO Auto-generated method stub
		
		FaqBoardmybatis.insertfaqboard(FaqBoardDto);
		}
	@Override
		public FaqboardDBBean getfaqboard(int qnum) {
			// TODO Auto-generated method stub
		
		
		return FaqBoardmybatis.getfaqboard(qnum);
		}
	
	@Override
		public void updatefaqboard(FaqboardDBBean boarddto) {
			// TODO Auto-generated method stub
			
		FaqBoardmybatis.updateboard(boarddto);
		}
	
	@Override
		public void deletfaqboard(int qnum) {
			// TODO Auto-generated method stub
		
		FaqBoardmybatis.deletefaqboard(qnum);
		}
}
