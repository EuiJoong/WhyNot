package category.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import category.model.CategoryDBBean;

public class CategoryMybatis {
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

	public static void insertCate(CategoryDBBean dto) {
		System.out.println("CateMybatis_insertCate() 실행");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertCategory", dto);
		session.commit(); // insert는 반드시 commit()를 해줘야 데이터가 쓰여짐
		session.close();
	}

	public static CategoryDBBean getCategory(int ctnum){
		System.out.println("CateMybatis_getCategory() 실행");
		SqlSession session = sqlMapper.openSession();
		CategoryDBBean dto = session.selectOne("getCategory", ctnum);
		session.close();
		return dto;
	}

	public static void deleteCate(int ctnum) {
		System.out.println("CateMybatis_deleteCate() 실행");
		SqlSession session = sqlMapper.openSession();
		session.delete("deleteCategory", ctnum);
		session.commit();
		session.close();
	}

	public static List<CategoryDBBean> listCategory(){
		System.out.println("CateMybatis_ListCategory() 실행");
		SqlSession session = sqlMapper.openSession();
		List<CategoryDBBean> list = session.selectList("listCategory");
		session.close();
		return list;
	}
	
	public static void updateCate(CategoryDBBean dto) {
		System.out.println("CateMybatis_updateCate() 실행");
		SqlSession session = sqlMapper.openSession();
		session.update("updateCategory", dto);
		session.commit();
		session.close();
	}
	

	public static boolean chkCate(String name) {
		System.out.println("CateMybatis_chkCate() 실행");
		SqlSession session = sqlMapper.openSession();
		System.out.println(name);
		String res = session.selectOne("chkCategory", name);
		boolean chk = true; 
		if(res == null || res.equals("")){
			chk = false;
		}
		session.close();
		return chk;
	}

}
