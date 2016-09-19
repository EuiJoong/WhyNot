package category.model;

import java.util.List;

public interface CategoryDAO {
	
	public CategoryDBBean getCategory(int ctnum);
	public List<CategoryDBBean> listCategory();
	public void insertCategory(CategoryDBBean dto);
	public void deleteCategory(int ctnum);
	public void updateCategory(CategoryDBBean dto);
	public boolean chkCategory(String name);
}