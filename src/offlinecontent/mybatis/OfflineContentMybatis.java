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
//		for(int i=0; i<list.size(); i++) {
//			System.out.println("OfflineContentMybatis-listSearchClassRoom : "+list.get(i).toString());
//		}
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
}
