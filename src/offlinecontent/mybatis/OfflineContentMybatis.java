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

//------------------ 파일 생성시 복사해서 쓰기 위한 base파일 ------------------------------

public class OfflineContentMybatis {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = 위치 지정 
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			//1.SqlMapConfig.xml 
			// 들어오는 값을 지정 시켜줌
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// 마이바티스로 바뀌면서 세션타입으로 처리를 해주게 됌
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	public static List listClassRoom() {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentMybatis-listClassRoom 실행");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listClassRoom");
		session.close();
		return list;
	}
	
	public static List listSearchClassRoom(Map paramMap) {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentMybatis-listSearchClassRoom 실행");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listSearchClassRoom", paramMap);
		session.close();
		return list;
	}
	
	public static List listOfflineContent(int ctnum) {
		// TODO Auto-generated method stub
		System.out.println("OfflineContentMybatis_listOfflineContent() 실행");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listOffContent", ctnum);
		session.close();
		return list;
	}
	
	public static boolean insertContent(OfflineContentDBBean offDTO, ClassRoomDBBean crDTO, ReserveDateDBBean rdateDTO, PhotoDBBean ptDTO) {
		System.out.println("OfflineContentMybatis-insertContent 실행");
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
		if(particnum.compareTo(max_num) >= 0)	//정원 꽉찼는지 확인
		{
			session.close();
			return "full";
		}
		int mileage = session.selectOne("mileageChk", spDTO.getMnum());
		if(mileage < spDTO.getSpamount()) {	//마일리지가 모자를때
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
