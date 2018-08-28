package com.company.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.User;
import com.company.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public Page<User> getAll(Pageable pageable) {
		Page<User> result = userService.getPageable(pageable);
		return result;
	}

	@PostMapping
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		return ResponseEntity.ok().body(userService.save(user));
	}
}
