package com.salonbooking.Services;

import com.salonbooking.Model.User;

public interface userServices {
  
	public User createUser(User user); 
	
	public User updateUser(User user);
	
	public User getUser(String username);
	
	public void deleteUser(Long id);
	
}
