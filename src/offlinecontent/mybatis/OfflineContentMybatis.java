package offlinecontent.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import attachfile.model.PhotoDBBean;
import offlinecontent.model.ClassRoomDBBean;
import offlinecontent.model.OfflineContentDBBean;
import offlinecontent.model.ReserveDateDBBean;
import offlinecontent.model.SponsorDBBean;

//------------------ ���� ������ �����ؼ� ���� ���� base���� ------------------------------

public class OfflineContentMybatis {
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
	
	public static List listClassRoom() {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentMybatis-listClassRoom ����");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listClassRoom");
		session.close();
		return list;
	}
	
	public static List listSearchClassRoom(Map paramMap) {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentMybatis-listSearchClassRoom ����");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listSearchClassRoom", paramMap);
		session.close();
		return list;
	}
	
	public static List listOfflineContent(int ctnum) {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentMybatis_listOfflineContent() ����");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listOffContent", ctnum);
		session.close();
		return list;
	}
	
	public static boolean insertContent(OfflineContentDBBean offDTO, ClassRoomDBBean crDTO, ReserveDateDBBean rdateDTO, PhotoDBBean ptDTO) {
		System.out.println("OfflineContentMybatis-insertContent ����");
		SqlSession session = sqlMapper.openSession();
		int res = session.selectOne("reserveCheck", rdateDTO);
		System.out.println("res : "+res);
		if(res>0) { session.close(); return false; }
		else {
			session.insert("insertOffContent", offDTO);
			session.commit();
			if(offDTO.getCr_num()==0) {
				session.update("reserve_insertClassRoom", crDTO);
				session.commit();
				session.update("reserve_insertDate", rdateDTO);
				session.commit();
			} else {
				session.update("reserve_updateDate", rdateDTO);
				session.commit();
			}
			session.insert("insertOffContent_Photo", ptDTO);
			session.commit();
			session.close();
			return true;
		}
	}
	
	public static List searchContent(String searchStr) {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentMybatis_searchContent()");
		SqlSession session = sqlMapper.openSession();
		List searchList = session.selectList("searchOffContent",searchStr);
		session.close();
		return searchList;
	}
	
	public static Map getContent(int offnum) {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentMybatis_getContent()");
		SqlSession session = sqlMapper.openSession();
		Map offContent_map = new HashMap(); 
		offContent_map.put("offContentDTO", session.selectOne("getOffContent",offnum));
		offContent_map.put("classRoomDTO", session.selectOne("getClassRoom",offnum));
		offContent_map.put("photoDTO", session.selectOne("getOffPhoto",offnum));
		offContent_map.put("sponsorList", session.selectList("getSponsor",offnum));
		offContent_map.put("writer", session.selectOne("getOffWriter",offnum));
		session.close();
		return offContent_map;
	}
	
	public static String updateSponsor(SponsorDBBean spDTO) {
		System.out.println("OfflineContentMybatis_updateSponsor()");
		SqlSession session = sqlMapper.openSession();
		List chkList = session.selectList("isFullPartici",spDTO.getOffnum());
		Map map = (Map)chkList.get(0);
		BigDecimal particnum = (BigDecimal)map.get("PARTICNUM");
		BigDecimal max_num = (BigDecimal)map.get("MAX_NUM");
		if(particnum.compareTo(max_num) >= 0)	//���� ��á���� Ȯ��
		{
			session.close();
			return "full";
		}
		int mileage = session.selectOne("mileageChk", spDTO.getMnum());
		if(mileage < spDTO.getSpamount()) {	//���ϸ����� ���ڸ���
			session.close();
			return "mileage";
		}
		int res = session.insert("insertSponsor", spDTO);
		if(res>0) {
			res = session.update("updateSponsor", spDTO);
			res = session.update("updateMileage", spDTO);
		}
		session.commit();
		session.close();
		if(res>0)
			return "success";
		else return "fail";
		
	}
}
