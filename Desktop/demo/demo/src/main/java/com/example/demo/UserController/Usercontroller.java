package com.example.demo.UserController;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
@RestController
public class Usercontroller {
	@RequestMapping("/user")
	public User getUserByName(User user) { 
		user =new User("Krishna","male");
		return user;
	}
	LinkedList<User> list1 = new LinkedList<User>();
	@PostMapping("/user")
	public User CreateUser(@RequestBody User user) { 
		list1.add(user);
		return user;
	}
	@GetMapping("/user/{name}/{gender}")
	public String GetUser(@PathVariable String name,@PathVariable String gender) { 
		if(name.equals("Krishna") && gender.equals("male")) {
			return name+" "+gender;
		}
		else {
			return "Not Found";
		}
	}
	@RequestMapping("/user/list")
	public LinkedList<User> getList(User user) { 
		return list1;
	}
	@DeleteMapping("/user/list")
	public LinkedList<User> DeleteList(@RequestBody User user) { 
		System.out.println("Deleting");
		list1.remove(user);
		System.out.println(list1);
		return list1;
	}
	@PutMapping("/user/list")
	public LinkedList<User> Modifyuser(@RequestBody User user) {
		list1.set(list1.size()-1,user);
		return list1;
	}
}
