package category.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import category.model.CategoryDAO;
import category.model.CategoryDBBean;

public class CategoryMybatis{
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
	public CategoryDBBean getCategory(int ctnum) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<CategoryDBBean> ListCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	public void insertCategory(CategoryDBBean dto) {
		// TODO Auto-generated method stub
		
	}
	public void deleteCategory(int ctnum) {
		// TODO Auto-generated method stub
		
	}
	public void updateCategory(int ctnum) {
		// TODO Auto-generated method stub
		
	}
}
