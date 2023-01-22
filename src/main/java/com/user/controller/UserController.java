package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
@EnableDiscoveryClient
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long userId) {
		User user = userService.getUser(userId);
		//without registring the service in eureka we are using hardcoded value in the Url which is localhost
		//this localhost will change when we move to somee other eenvironment
		
		//List<Contact> contactList = restTemplate.getForObject("http://localhost:9002/contact/"+user.getUserId(), List.class);
		
		//After registring the service with eureka service registry
		List<Contact> contactList = restTemplate.getForObject("http://Contact-Service/contact/"+user.getUserId(), List.class);
		user.setContacts(contactList);
		return user;
	}

}
 
