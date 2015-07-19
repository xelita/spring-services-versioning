package com.xelita.study.spring.boot.controller;

import com.xelita.study.spring.boot.domain.*;
import com.xelita.study.spring.boot.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Transactional(readOnly = true)
@RequestMapping(value = "/api")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserV2Repository userV2Repository;

	// *************************************************************************
	//
	// Rest methods
	//
	// *************************************************************************

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = {"application/spring-boot-study-v1+json"})
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = {"application/spring-boot-study-v2+json"})
	public List<UserV2> getUsersV2() {
		return this.userV2Repository.findAll();
	}
}
