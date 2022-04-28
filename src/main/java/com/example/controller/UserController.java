package com.example.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entity.Todo;
import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.repository.UserDaoRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDaoRepository userDaoRepository;
	
	@PostMapping("/save")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		
		/*
		 * if(userDaoRepository.saveUser(user)) return "Success"; else return "Failed";
		 */
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(user.getUserId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/{userId}")
	public Resource<User> getUser(@PathVariable("userId") int userId) throws UserNotFoundException {
		User user = userDaoRepository.getUser(userId);
		
		if(null == user) {
			throw new UserNotFoundException("User not found");
		}
		
		Resource<User> entityModel = new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUser());
		
		entityModel.add(linkTo.withRel("all-users"));
		
		return entityModel;
		
	}
	
	@GetMapping("/allusers")
	public List<User> getUser() {
		return userDaoRepository.getAllUsers();
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) throws UserNotFoundException {
		User user = userDaoRepository.getUser(userId);
		
		if(null == user) {
			throw new UserNotFoundException("User not found");
		}
		
		userDaoRepository.deleteUser(userId);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/todos/users", produces = "application/json")
	public List<Todo> getTodos() {
		
		List<Todo> listOfTodos = new ArrayList<>();
		listOfTodos.add(new Todo(1, 1, "todo 1", true));
		listOfTodos.add(new Todo(1, 2, "todo 2", false));
		listOfTodos.add(new Todo(1, 3, "todo 3", true));
		
		return listOfTodos;
	}
}
