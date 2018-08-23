package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.model.User;
import com.company.repo.UserRepository;
import com.company.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(Integer.valueOf(user.getId().toString()), user.getEmail(), user.getPassword(),
				user.getProfiles());
	}

}
