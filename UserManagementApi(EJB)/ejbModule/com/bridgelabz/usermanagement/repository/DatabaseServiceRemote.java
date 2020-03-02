package com.bridgelabz.usermanagement.repository;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import com.bridgelabz.usermanagement.model.UserBean;

@Remote
public interface DatabaseServiceRemote {
	
	public List<UserBean> getUsers();
	
	public String createUser(UserBean u);
	
	public UserBean getUser(String email);
	
	public String deleteUser(String email);
	
	public List<UserBean> getUserByGender(String gender);
	
	public List<UserBean> getTopLocation();
	
	public List<UserBean> getLatestRegistration();
	
	public List<Integer> getUsersAge();

	public int ageCalculator(LocalDate dob);
}
