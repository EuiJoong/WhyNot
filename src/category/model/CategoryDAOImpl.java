package category.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import category.mybatis.CategoryMybatis;
import member.mybatis.MemberMybatis;

public class CategoryDAOImpl implements CategoryDAO {


	
	@Override
	public CategoryDBBean getCategory(int ctnum) {
		// TODO Auto-generated method stub
		System.out.println("CategoryDAOImpl_getCategory() ����");
		System.out.println("����!");
		return CategoryMybatis.getCategory(ctnum); 
	}

	@Override
	public List<CategoryDBBean> listCategory() {
		System.out.println("CategoryDAOImpl_listCategory() ����");
		List<CategoryDBBean> list = CategoryMybatis.listCategory(); 
		return list;
	}

	@Override
	public void insertCategory(CategoryDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("CategoryDAOImpl_insertCategory() ����");
		CategoryMybatis.insertCate(dto); 
		System.out.println("����!");
	} 

	@Override
	public void deleteCategory(int ctnum) {
		// TODO Auto-generated method stub
		System.out.println("CategoryDAOImpl_deleteCategory() ����");
		CategoryMybatis.deleteCate(ctnum);
		System.out.println("����!");
	}

	@Override
	public void updateCategory(CategoryDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("CategoryDAOImpl_updateCategory() ����");
		CategoryMybatis.updateCate(dto);
		System.out.println("����!");
	}
	public boolean chkCategory(String name) {
		System.out.println("CategoryDAOImpl_chkCategory() ����");
		boolean chk = CategoryMybatis.chkCate(name);
		return chk;
	}
}
