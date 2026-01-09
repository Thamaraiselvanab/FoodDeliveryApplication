package com.tap.utility;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;
import com.tap.model.User;

public class Launch {

	public static void main(String[] args) {
		
		
	Scanner scan = new Scanner(System.in);
	
	
	 MenuDAOImpl mdl= new MenuDAOImpl();
	 List<Menu> res=mdl.getAllMenus();
	 System.out.println(res);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	}

