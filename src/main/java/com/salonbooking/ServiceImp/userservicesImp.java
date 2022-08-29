package com.salonbooking.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salonbooking.Model.User;
import com.salonbooking.Repository.userRepository;
import com.salonbooking.Services.userServices;


@Component
public class userservicesImp implements userServices{
	
	@Autowired
	 userRepository userRepo;

	public User createUser(User user) {
		User local = userRepo.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User is already registered");
		}else {
			return this.userRepo.save(user);
		}
		return null;
	}

	public User updateUser(User user) {
		return this.userRepo.save(user);
	}

	public User getUser(String username) {
		return this.userRepo.findByUsername(username);
	}

	public void deleteUser(Long id) {
		this.userRepo.deleteById(id);
	}

	

}
