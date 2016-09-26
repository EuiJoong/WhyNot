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

	public static void insertCate(CategoryDBBean dto) {
		System.out.println("CateMybatis_insertCate() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertCategory", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
	}

	public static CategoryDBBean getCategory(int ctnum){
		System.out.println("CateMybatis_getCategory() ����");
		SqlSession session = sqlMapper.openSession();
		CategoryDBBean dto = session.selectOne("getCategory", ctnum);
		session.close();
		return dto;
	}

	public static void deleteCate(int ctnum) {
		System.out.println("CateMybatis_deleteCate() ����");
		SqlSession session = sqlMapper.openSession();
		session.delete("deleteCategory", ctnum);
		session.commit();
		session.close();
	}

	public static List<CategoryDBBean> listCategory(){
		System.out.println("CateMybatis_ListCategory() ����");
		SqlSession session = sqlMapper.openSession();
		List<CategoryDBBean> list = session.selectList("listCategory");
		session.close();
		return list;
	}
	
	public static void updateCate(CategoryDBBean dto) {
		System.out.println("CateMybatis_updateCate() ����");
		SqlSession session = sqlMapper.openSession();
		session.update("updateCategory", dto);
		session.commit();
		session.close();
	}
	

	public static boolean chkCate(String name) {
		System.out.println("CateMybatis_chkCate() ����");
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
