package category.model;

import java.util.List;

public interface CategoryDAO {
	
	public CategoryDBBean getCategory(int ctnum);
	public List<CategoryDBBean> ListCategory();
	public void insertCategory(CategoryDBBean dto);
	public void deleteCategory(int ctnum);
	public void updateCategory(int ctnum);
}
