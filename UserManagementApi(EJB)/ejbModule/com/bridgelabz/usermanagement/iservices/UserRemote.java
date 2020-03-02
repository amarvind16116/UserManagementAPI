package com.bridgelabz.usermanagement.iservices;

import java.util.List;

import javax.ejb.Remote;

import org.json.simple.JSONObject;

import com.bridgelabz.usermangementapi.model.UserBean;

@Remote
public interface UserRemote {

	public List<UserBean> getAllUsers();
	
	public UserBean registerUser(UserBean u);

	UserBean getUser(String email);

	String deleteUser(String email);

	List<UserBean> getGenderWise(String gender);

	List<UserBean> getTopLocations();

	List<UserBean> getLatestRegistration();
}
