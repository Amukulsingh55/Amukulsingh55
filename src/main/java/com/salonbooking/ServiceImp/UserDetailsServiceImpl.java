package com.salonbooking.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salonbooking.Model.User;
import com.salonbooking.Repository.userRepository;





@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private userRepository userRepo;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepo.findByUsername(username);

		if (user == null) {
			System.out.print("User Not Found");
			throw new UsernameNotFoundException("User is not Available");
		}

		return user;

	}

}
