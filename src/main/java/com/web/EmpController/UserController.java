package com.web.EmpController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.Exception.UserNotFoundException;
import com.web.Model.User;
import com.web.Repository.UserRepository;

@RestController
@CrossOrigin("https://empoyee-management-sys-with-react.vercel.app/")
public class UserController {

	
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/user")
	public User newUser(@RequestBody User newUser) {
		return repo.save(newUser);
	}
	
	@GetMapping("/user")
	public  List<User> getAllUsers(){
		return repo.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		return repo.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User newUser,@PathVariable Long id) {
	   return repo.findById(id)
			   .map(user ->{
				   user.setDesignation(newUser.getDesignation());
				   user.setName(newUser.getName());
				   user.setEmail(newUser.getEmail());
				   return repo.save(user);
			   }).orElseThrow(()->new UserNotFoundException(id));
	}	
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		if(!repo.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		repo.deleteById(id);
		return "User with id "+id+" has been deleted successfully";
	}
}
