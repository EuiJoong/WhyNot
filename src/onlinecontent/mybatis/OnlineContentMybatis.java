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
import onlinecurriculum.mybatis.OnlineCurriculumMybatis;

public class OnlineContentMybatis {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = ��ġ ����
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			// 1.SqlMapConfig.xml
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
			reader.close();
		} catch (Exception e) {
			// Fail fast.
			e.printStackTrace();
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static VideoDBBean getContent(int num) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentMybatis_getContent() ����");
		VideoDBBean dto = new VideoDBBean();
		//
		System.out.println("num : " + num);
		SqlSession session = sqlMapper.openSession();
		dto = (VideoDBBean) session.selectOne("getContent", num);
		session.commit();
		System.out.println("session get");
		session.close();
		return dto;
	}

	public static List getDetailWho(int ocnum) {
		System.out.println("OnlineContentMybatis_getDetailWho() ����");
		SqlSession session = sqlMapper.openSession();
		System.out.println("ocnum : " + ocnum);
		List list = session.selectList("getDetailWho", ocnum);
		session.commit();
		System.out.println("list.size() : " + list.size());
		session.close();

		return list;
	}

	public static List listOnlineContent(int ctnum) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentMybatis_listOnlineContent() ����");
		SqlSession session = sqlMapper.openSession();
		List list = session.selectList("listContent", ctnum);
		session.close();
		return list;
	}

	public static void insertContent(OnlineContentDBBean oc_dto, PhotoDBBean p_dto, VideoDBBean v_dto) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentMybatis_insertContent() ����");
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
		if (v_dto.getFilename() == null || v_dto.getFilename().equals(""))
			session.insert("insertContent_videoNo", contentMap);
		else
			session.insert("insertContent_videoOk", contentMap);
		session.commit();
		
		int ocnum = session.selectOne("getOcnum",oc_dto.getTitle());
		session.close();
		System.out.println("getOcnum: " + ocnum);
		OnlineCurriculumMybatis.createLesson(ocnum);
		System.out.println("session insert");

	}

	public static void updateContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentMybatis_updateContent() ����");

	}

	public static void sanctionsContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentMybatis_sanctionsContent() ����");

	}

	public static void deleteContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentMybatis_deleteContent() ����");
	}

	public static List recommendContent(int mnum) {
		System.out.println("OnlineContentMybatis_recommendContent() ����");
		SqlSession session = sqlMapper.openSession();
		List recommendList = session.selectList("recommendContent", mnum);
		session.close();
		return recommendList;
	}
	
	
	public static List getBestContent() {
		System.out.println("OnlineContentMybatis_getBestContent() ����");
		SqlSession session = sqlMapper.openSession();
		List bestList = session.selectList("getBestContent");
		session.close();
		return bestList;
	}
	
	public static List searchContent(String searchStr) {
		// TODO Auto-generated method stub
		System.out.println("OnlineContentDAOImpl_searchContent()");
		SqlSession session = sqlMapper.openSession();
		List searchList = session.selectList("searchOnContent",searchStr);
		session.close();
		return searchList;
	}
}
