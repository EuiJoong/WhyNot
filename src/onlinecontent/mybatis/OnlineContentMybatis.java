package onlinecontent.mybatis;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import attachfile.model.PhotoDBBean;
import attachfile.model.VideoDBBean;
import onlinecontent.model.OnlineContentDBBean;

public class OnlineContentMybatis {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = 위치 지정
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			// 1.SqlMapConfig.xml
			// 들어오는 값을 지정 시켜줌
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// 마이바티스로 바뀌면서 세션타입으로 처리를 해주게 됌
			reader.close();
		} catch (Exception e) {
			// Fail fast.
			e.printStackTrace();
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static OnlineContentDBBean getContent(int num) {
		// TODO Auto-generated method stub
//		int mnum = num;
//		OnlineContentDBBean dto = new OnlineContentDBBean();
//
//		SqlSession session = sqlMapper.openSession();
//		dto = (OnlineContentDBBean) session.selectOne("getContent", mnum);
//		session.commit();
//		System.out.println("session get");
//		session.close();
		return null;
	}

	public static List<OnlineContentDBBean> listOnlineContent() {
		// TODO Auto-generated method stub
		return null;

		/*
		 * List list=null; SqlSession session=sqlMapper.openSession();
		 * list=session.selectList("listBoard"); session.close(); return list;
		 * List list=null; try{ list=sqlMapper.queryForList("listBoard");
		 * }catch(SQLException e){ System.out.println("listBoard 실행 에러"); }
		 * return list;
		 */

		// 이런식으로.
	}

	public static void insertContent(OnlineContentDBBean oc_dto, PhotoDBBean p_dto, VideoDBBean v_dto) {
		// TODO Auto-generated method stub
		SqlSession session = sqlMapper.openSession();
		/*
		 * Map map=new HashMap(); map.put("mnum", dto.getMnum());
		 * map.put("vdnum",dto.getVdnum()); map.put("filedir",
		 * dto.getFiledir()); map.put("filename", dto.getFilename());
		 * map.put("num", num);
		 */
		Map contentMap = new HashMap<>();
		contentMap.put("oc_dto", oc_dto);
		contentMap.put("p_dto", p_dto);
		contentMap.put("v_dto", v_dto);
		if(v_dto.getFilename()==null || v_dto.getFilename().equals("")) 
			session.insert("insertContent_videoNo", contentMap);
		else
			session.insert("insertContent_videoOk", contentMap);
			
		session.commit();
		System.out.println("session insert");
		session.close();

	}

	public static void updateContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub

	}

	public static void sanctionsContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub

	}

	public static void deleteContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub

	}
}
