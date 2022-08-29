package com.salonbooking.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salonbooking.Model.User;
import com.salonbooking.Repository.userRepository;
import com.salonbooking.ServiceImp.userservicesImp;
import com.salonbooking.Services.SequenceGeneratorService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private userservicesImp userService;
	@Autowired
	private userRepository userRepo;
	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		//generate sequence
				user.setId(service.getSequenceNumber(User.SEQUENCE_NAME));
				user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
				return this.userService.createUser(user);
	}
	
	@PutMapping("/put")
	public User updateUser(@RequestBody User user) {
		return this.userRepo.save(user);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.userService.deleteUser(id);

	}
}
