package com.bridgelabz.usermanagement.iservices;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.json.simple.JSONObject;

import com.bridgelabz.usermanagement.repository.DatabaseServiceRemote;
import com.bridgelabz.usermangementapi.model.UserBean;

/**
 * Session Bean implementation class User
 */
@Stateless
public class User implements UserRemote {
	
	@EJB
	DatabaseServiceRemote dbservice;

    /**
     * Default constructor. 
     */
    public User() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public List<UserBean> getAllUsers()
    {
    	return dbservice.getUsers();
    }
    
    @Override
    public UserBean registerUser(UserBean u)
    {
    	dbservice.createUser(u);
    	return u;
    }
    
    @Override
    public UserBean getUser(String email)
    {
    	return dbservice.getUser(email);
    }
    
    @Override
    public String deleteUser(String email)
    {
    	return dbservice.deleteUser(email);
    }
    
    @Override
    public List<UserBean> getGenderWise(String gender)
    {
    	return dbservice.getUserByGender(gender);
    }
    
    @Override
    public List<UserBean> getTopLocations()
    {
    	return dbservice.getTopLocation();
    }
    
    @Override
    public List<UserBean> getLatestRegistration()
    {
    	return dbservice.getLatestRegistration();
    }
}
