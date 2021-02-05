package com.promineotech.mavenProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.mavenProject.entity.Friend;

public interface FriendRepository extends CrudRepository<Friend, Long> {

}
