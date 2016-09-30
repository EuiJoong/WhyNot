package offlinecontent.mybatis;

import java.io.IOException;
import java.io.Reader;
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
//		for(int i=0; i<list.size(); i++) {
//			System.out.println("OfflineContentMybatis-listSearchClassRoom : "+list.get(i).toString());
//		}
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
}
