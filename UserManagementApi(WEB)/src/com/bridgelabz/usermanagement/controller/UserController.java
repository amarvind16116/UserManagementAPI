package com.bridgelabz.usermanagement.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.bridgelabz.usermanagement.iservices.UserRemote;
import com.bridgelabz.usermangementapi.model.UserBean;

/**
 * Session Bean implementation class DemoController
 */
@Path("users")
@Stateless
public class UserController {

    /**
     * Default constructor. 
     */
	@EJB
	UserRemote user;

	
    public UserController() {
    	
    }
  
    @GET
    @Path("allUsers")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<UserBean> getAllUsers() {
		return user.getAllUsers();
    	
    }
    
    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public UserBean createUser(UserBean u)
    {
    	return user.registerUser(u);
    }
    
    @GET
    @Path("uname/{email}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public UserBean getUser(@PathParam("email") String email)
    {
    	return user.getUser(email);
    }
    
    @DELETE
    @Path("delete/{email}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public String deleteUser(@PathParam("email") String email)
    {
    	return user.deleteUser(email);
    }
    
    @GET
    @Path("getGender/{gender}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<UserBean> getGenderWise(@PathParam("gender") String gender)
    {
    	return user.getGenderWise(gender);
    }
    
    @GET
    @Path("location")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<UserBean> getLocationOnTop()
    {
    	return user.getTopLocations();
    }
    
    @GET
    @Path("latestRegistration")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<UserBean> getLatestRegistration()
    {
    	return user.getLatestRegistration();
    }
}
