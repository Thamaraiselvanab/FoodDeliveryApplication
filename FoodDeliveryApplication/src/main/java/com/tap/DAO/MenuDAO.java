package com.tap.DAO;

import java.util.List;
import com.tap.model.Menu;

public interface MenuDAO {
	
	public int addMenu(Menu menu);
	public Menu getMenu(int id);
	public void updateMenu(Menu menu);
	public void deleteMenu(int id);
	public List<Menu> getAllMenus();
	public List<Menu> getAllMenusByRestaurantId(int id);
	
}
