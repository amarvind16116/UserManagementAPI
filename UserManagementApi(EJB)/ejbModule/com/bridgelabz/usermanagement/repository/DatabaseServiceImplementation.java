package com.bridgelabz.usermanagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bridgelabz.usermangementapi.model.UserBean;

/**
 * Session Bean implementation class Database
 */
@Stateless
public class DatabaseServiceImplementation implements DatabaseServiceRemote {

    
	Statement stmt;
	ResultSet rs;
	Connection con;
	PreparedStatement pstmt;
	UserBean user;
	
	List<UserBean> list;
	
	public Connection getConnection()
	{
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql:///USER_MANAGEMENT_API","root","root");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	
   @Override
   public List<UserBean> getUsers()
   {
	   list = new ArrayList<UserBean>();
	   
	   try {
			pstmt = getConnection().prepareStatement("SELECT * from USER");
		   rs = pstmt.executeQuery();
		   while(rs.next())
		   {
			   	 user = new UserBean();
			     user.setId(Integer.parseInt(rs.getString(1)));
			     user.setFirst_name(rs.getString(2));
			     user.setMiddle_name(rs.getString(3));
			     user.setLast_name(rs.getString(4));
			     user.setEmail_id(rs.getString(5));
			     user.setUsername(rs.getString(6));
			     user.setDate_of_birth(rs.getString(7));
			     user.setGender(rs.getString(8));
			     user.setCountry(rs.getString(9));
			     user.setMobile_num(Long.parseLong(rs.getString(10)));
			     user.setAddress(rs.getString(11));
			     user.setUser_role(rs.getString(12));
			     
			     list.add(user);
		   }
		   
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return list;
   }
   
   public String createUser(UserBean u)
   {
	   list = new ArrayList<UserBean>();
	   String query = "insert into USER(first_name,middle_name,last_name,email_id,username,date_of_birth,gender,country,mobile_num,address,user_role, password,confirm_password) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
   	try {
			pstmt = getConnection().prepareStatement(query);
			pstmt.setString(1, u.getFirst_name());
    		pstmt.setString(2, u.getMiddle_name());
    		pstmt.setString(3, u.getLast_name());
    		pstmt.setString(4, u.getEmail_id());
    		pstmt.setString(5, u.getUsername());
    		pstmt.setString(6, u.getDate_of_birth());
    		pstmt.setString(7, u.getGender());
    		pstmt.setString(8, u.getCountry());
    		pstmt.setLong(9, u.getMobile_num());
    		pstmt.setString(10, u.getAddress());
    		pstmt.setString(11, u.getUser_role());
    		pstmt.setString(12, u.getPassword());
    		pstmt.setString(13, u.getConfirm_password());
    		
    		pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
   		list.add(u);
   		return "Added";
   }
   
   @Override
   public UserBean getUser(String email)
	{
	   list = new ArrayList<UserBean>();
	   list = getUsers();
		for(UserBean user : list)
		{
			if(user.getEmail_id().equals(email))
			{
				return user;
			}
		}
		return new UserBean();
	}
   
   @Override
   public String deleteUser(String email)
	{
	   try {
		pstmt = getConnection().prepareStatement("DELETE from USER WHERE email_id=?");
		pstmt.setString(1, email);
		pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return "deleted";
	}
   
   @Override
   public List<UserBean> getUserByGender(String gender)
   {	
	   List<UserBean> genders = new ArrayList<UserBean>() ;
	   list = new ArrayList<UserBean>();
	   list = getUsers();
	   for(UserBean user : list)
	   {
		   if(user.getGender().equals(gender))
			   genders.add(user);
	   }
	   return genders;
   }
   
   @Override
   public List<UserBean> getTopLocation()
   {
	   list = new ArrayList<UserBean>();
	   try
	   {
		   pstmt = getConnection().prepareStatement("select country, count(*) from USER GROUP BY country ORDER BY COUNT(*) DESC;");
		   rs = pstmt.executeQuery();
		   while(rs.next())
		   {
			   user = new UserBean();
			   
			   user.setCountry(rs.getString(1));
			   user.setCountLocation(Integer.parseInt(rs.getString(2)));
			   
			   list.add(user);
		   }
	   }
	   catch (Exception e) {
		e.printStackTrace();
	}
	   return list;
   }
   
   @Override
   public List<UserBean> getLatestRegistration()
   {
	   list = new ArrayList<UserBean>();
	   try {
		pstmt = getConnection().prepareStatement("SELECT first_name,middle_name,last_name from USER ORDER BY user_id DESC LIMIT 10");
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			user = new UserBean();
			
			user.setFirst_name(rs.getString(1));
			user.setMiddle_name(rs.getString(2));
			user.setLast_name(rs.getString(3));
			
			list.add(user);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return list;
   }
}
