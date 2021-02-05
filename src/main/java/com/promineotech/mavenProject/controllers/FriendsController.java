package com.promineotech.mavenProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.promineotech.mavenProject.entity.Friend;
import com.promineotech.mavenProject.service.FriendsService;

@RestController
public class FriendsController {
	
	private static final Logger logger = LogManager.getLogger(FriendsController.class);
	
	@Autowired
	FriendsService service;
	
	@RequestMapping(value = "/friends", method=RequestMethod.POST)
	public Friend addFriend(@RequestBody Friend friend) {
		return service.createFriend(friend);
	}
	
	@RequestMapping("/friends")
	public Iterable<Friend> getFriends() {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("WARNING");
		logger.error("This is an error");
		logger.fatal("Your program is broken");
		
		try {
			throw new Exception("This is an exception!");
		} catch (Exception e) {
			logger.fatal("An exception occurred. " + e.getMessage() );
		}
		
		return service.getFriends();
	}
	
	@RequestMapping(value = "/friends/{id}", method=RequestMethod.PUT)
	public Friend updateFriend(@PathVariable Long id, @RequestBody Friend friend) {
		return service.updateFriend(id, friend);
	}
	
	@RequestMapping(value = "/friends/{id}", method=RequestMethod.DELETE)
	public void deleteFriend(@PathVariable Long id) {
		service.deleteFriend(id);
	}
	
	@RequestMapping("/friends/{id}")
	public Friend getFriend(@PathVariable Long id) {
		return service.getFriend(id);
	}

}
