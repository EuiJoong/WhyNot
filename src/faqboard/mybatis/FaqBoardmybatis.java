package faqboard.mybatis;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import faqboard.model.FaqboardDBBean;
import faqboard.model.FaqcodeDBBean;



public class FaqBoardmybatis {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = ��ġ ���� 
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			//1.SqlMapConfig.xml 
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	
	public static int getCodeCount(){
		System.out.println("getCodeCount ����");
		SqlSession session = sqlMapper.openSession();
		int count = session.selectOne("getCodeCount");
		return count;
	}

	
	public static boolean checkcode(String code){
		System.out.println("checkcode ����");
		SqlSession session = sqlMapper.openSession();
		int checkcode = session.selectOne("checkcode", code);
		session.close();
		return checkcode>0 ? true:false;
	}


	public static List<FaqcodeDBBean> getcodelist(){
		System.out.println("getcodelist() ����");
		SqlSession session = sqlMapper.openSession();
		List<FaqcodeDBBean> list = session.selectList("getcodelist");
		session.close();
		return list;
	}
	
	
	
	public static List<FaqboardDBBean> getboardlist(int code){
		System.out.println("boardlist ����");
		SqlSession session = sqlMapper.openSession();
		List<FaqboardDBBean> list = session.selectList("getboardlist",code);
		session.close();
		return list;
	}
	
	public static List<FaqboardDBBean> getwholeboardlist(){
		System.out.println("getwholeboardlist");
		SqlSession session = sqlMapper.openSession();
		List<FaqboardDBBean> boardlist = session.selectList("getwholeboardlist");
		session.close();
		return boardlist;
	}
	
	
	public static FaqcodeDBBean getcode(){
		
		SqlSession session = sqlMapper.openSession();
		
		FaqcodeDBBean getcode =  session.selectOne("getcode");
		return getcode;
	}
	
	
	public static void insertfaqcode(FaqcodeDBBean dto){
		System.out.println("insertfaqcode ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertfaqcode",dto);
		session.commit();
		session.close();
		
	}

	
	public static void deletecode(String code){
		System.out.println("deletecode ����");
		SqlSession session = sqlMapper.openSession();
		session.delete("deletecode",code);
		session.commit();
		session.close();
		
	}
	
	public static void updatecode(FaqcodeDBBean codeDto){
		System.out.println("updatecode ����");
		SqlSession session = sqlMapper.openSession();
		session.update("updatecode",codeDto);
		session.commit();
		session.close();
	}
	
	
	public static void insertfaqboard(FaqboardDBBean FaqBoardDto){
		System.out.println("insertfaqboard ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertfaqboard",FaqBoardDto);
		session.commit();
		session.close();
	}
	
	public static  FaqboardDBBean  getfaqboard(int qnum){
			System.out.println("getfaqboard ����");
		SqlSession session = sqlMapper.openSession();
		FaqboardDBBean boardDto = session.selectOne("getfaqboard",qnum);
		session.close();
		return boardDto;
	}
	
	public static void updateboard(FaqboardDBBean  boarddto){
			System.out.println("updateboard ����");
			SqlSession session = sqlMapper.openSession();
			session.update("updateboard",boarddto);
			session.commit();
			session.close();
	}
	
	public static void deletefaqboard(int qnum){
			System.out.println("deletefaqboard ����");
			SqlSession session = sqlMapper.openSession();
			session.delete("deletefaqboard",qnum);	
			session.commit();
			session.close();
	}
	
	
	
}
