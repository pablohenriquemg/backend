package com.company.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.company.model.User;

public interface UserService {

	User save(User user);

	List<User> getAll();

	Page<User> getPageable(Pageable pageable);
}
