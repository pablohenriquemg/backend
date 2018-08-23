package com.company.service;

import java.util.List;

import com.company.model.User;

public interface UserService {

	User save(User user);

	List<User> getAll();
}
