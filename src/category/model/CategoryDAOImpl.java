package category.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import category.mybatis.CategoryMybatis;
import member.mybatis.MemberMybatis;

public class CategoryDAOImpl implements CategoryDAO {


	
	@Override
	public CategoryDBBean getCategory(int ctnum) {
		// TODO Auto-generated method stub
		System.out.println("CategoryDAOImpl_getCategory() 角青");
		System.out.println("己傍!");
		return CategoryMybatis.getCategory(ctnum); 
	}

	@Override
	public List<CategoryDBBean> listCategory() {
		System.out.println("CategoryDAOImpl_listCategory() 角青");
		List<CategoryDBBean> list = CategoryMybatis.listCategory(); 
		return list;
	}

	@Override
	public void insertCategory(CategoryDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("CategoryDAOImpl_insertCategory() 角青");
		CategoryMybatis.insertCate(dto); 
		System.out.println("己傍!");
	} 

	@Override
	public void deleteCategory(int ctnum) {
		// TODO Auto-generated method stub
		System.out.println("CategoryDAOImpl_deleteCategory() 角青");
		CategoryMybatis.deleteCate(ctnum);
		System.out.println("己傍!");
	}

	@Override
	public void updateCategory(CategoryDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("CategoryDAOImpl_updateCategory() 角青");
		CategoryMybatis.updateCate(dto);
		System.out.println("己傍!");
	}
	public boolean chkCategory(String name) {
		System.out.println("CategoryDAOImpl_chkCategory() 角青");
		boolean chk = CategoryMybatis.chkCate(name);
		return chk;
	}
}
