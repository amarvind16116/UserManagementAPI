package com.bridgelabz.usermanagement.iservices;

import java.util.List;

import javax.ejb.Remote;

import com.bridgelabz.usermanagement.model.UserBean;

@Remote
public interface UserRemote {

	public List<UserBean> getAllUsers();
	
	public UserBean registerUser(UserBean u);

	public UserBean getUser(String email);

	public String deleteUser(String email);

	public List<UserBean> getGenderWise(String gender);

	public List<UserBean> getTopLocations();

	public List<UserBean> getLatestRegistration();

	public List<Integer> getAge();
}
