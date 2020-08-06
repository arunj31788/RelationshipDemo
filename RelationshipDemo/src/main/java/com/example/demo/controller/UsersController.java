package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersJpaRepository;

@RestController
@RequestMapping("/empDetails")
public class UsersController {
//comments
	@Autowired
	private UsersJpaRepository usersJpaRepository;

	@GetMapping(value = "/getAll")
	public List<Users> getAll() {
		return usersJpaRepository.findAll();
	}

	@GetMapping(value = "/getById/{id}")
	public Optional<Users> getById(@PathVariable("id") Long id) {
		Optional<Users> user = usersJpaRepository.findById(id);
		return user;
	}

	@PostMapping(value = "/save")
	public Users save(@RequestBody Users users) {
		return usersJpaRepository.save(users);
	}

	@PutMapping(value = "/update")
	public Users update(@RequestBody Users users) {
		return usersJpaRepository.save(users);
	}

	@DeleteMapping(value = "/delete")
	public Users delete(@RequestBody Users users) {
		usersJpaRepository.delete(users);
		return users;
	}

}
