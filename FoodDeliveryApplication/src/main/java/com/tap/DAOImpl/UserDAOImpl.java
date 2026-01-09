package com.tap.DAOImpl;

import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.model.User;
import com.tap.utility.DBconnection;

import jakarta.servlet.annotation.WebServlet;


public class UserDAOImpl implements UserDAO {

	
	String INSERT_USER = "INSERT into user (userId,userName,password,email,address,PhoneNumber,role,lastLoginDate,createdDate)"
			+"values(?,?,?,?,?,?,?,?,?)";
	
	String GET_USER_BY_ID = "SELECT * FROM user where userid=?";
	
	String UPDATE_USER = "Update User Set username=?, password=?, email=?, address=?, phonenumber=? where userid=?";
	
	String DELETE_USER = "Delete from User where userid=?;";
	
	String GET_ALL_USER = "Select * from user";
	@Override
	public int addUser(User user)
	{
		
		int res=0;
		
		try (Connection connection = DBconnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_USER);){
			
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPhoneNumber());
			pstmt.setString(7, user.getRole());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			
			
		    res = pstmt.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public User getUser(int id) {
		
	User user=null;
	try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(GET_USER_BY_ID);)
	{
		
		pstmt.setInt(1, id);
		ResultSet res = pstmt.executeQuery();
		
		while(res.next()) 
		{
			int userid = res.getInt("userid");
			String username = res.getString("username");
			String password = res.getString("password");
			String email = res.getString("email");
			String address = res.getString("address");
			String phonenumber = res.getString("phonenumber");
			String role = res.getString("role");
			Timestamp lastlogindate = res.getTimestamp("lastlogindate");
			Timestamp createddate = res.getTimestamp("createddate");
			
			user = new  User(userid, username, password, email, address, phonenumber, role, lastlogindate, createddate);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return user;
	}

	@Override
	public void updateUser(User user) {
		
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(UPDATE_USER);)
		{
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getPhoneNumber());
			pstmt.setInt(6, user.getUserId());
			
			int res = pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int id) 
	{
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(DELETE_USER);)
		{
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<User> getAllUser() {
		
		 List<User> listOfUser = new ArrayList<User>();
		
		try (Connection connection = DBconnection.getConnection();PreparedStatement pstmt = connection.prepareStatement(GET_ALL_USER);)
		{
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) 
			{
				int userid = res.getInt("userid");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String phonenumber = res.getString("phonenumber");
				String role = res.getString("role");
				Timestamp lastlogindate = res.getTimestamp("lastlogindate");
				Timestamp createddate = res.getTimestamp("createddate");
				
				User user  = new  User(userid, username, password, email, address, phonenumber, role, lastlogindate, createddate);
				
				listOfUser.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOfUser;
	}
	
	
	@Override
	public User getUserByEmail(String email) {

	    User user = null;

	    String sql = "SELECT * FROM users WHERE email = ?";

	    try (
	        Connection con = DBconnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql)
	    ) {
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            user = new User();
	            user.setUserId(rs.getInt("userid"));
	            user.setUserName(rs.getString("username"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setAddress(rs.getString("address"));
	            user.setPhoneNumber(rs.getString("phonenumber"));
	            user.setRole(rs.getString("role"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}

	
	
	

}
