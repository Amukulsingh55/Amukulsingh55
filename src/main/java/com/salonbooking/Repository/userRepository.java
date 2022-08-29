package com.salonbooking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.salonbooking.Model.User;



public interface userRepository  extends MongoRepository<User,Integer>{
	
	public User findByUsername(String username);

	public void deleteById(Long id);

}
