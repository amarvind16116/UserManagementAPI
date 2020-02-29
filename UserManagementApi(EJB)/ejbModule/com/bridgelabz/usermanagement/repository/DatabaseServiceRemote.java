package com.bridgelabz.usermanagement.repository;

import java.util.List;

import javax.ejb.Remote;

import com.bridgelabz.usermangementapi.model.UserBean;

@Remote
public interface DatabaseServiceRemote {
	public List<UserBean> getUsers();
	public String createUser(UserBean u);
	UserBean getUser(String email);
	String deleteUser(String email);
	List<UserBean> getUserByGender(String gender);
	public List<UserBean> getTopLocation();
}
