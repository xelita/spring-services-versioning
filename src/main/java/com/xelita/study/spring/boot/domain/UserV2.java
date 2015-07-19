package com.xelita.study.spring.boot.domain;

import javax.persistence.*;

@Table(name = "USER")
@Entity
public class UserV2 {

	@Id
	private String email;

	// *************************************************************************
	//
	// Constructors
	//
	// *************************************************************************

	public UserV2() {
	}

	public UserV2(String email) {
		this.email = email;
	}

	// *************************************************************************
	//
	// Getters and Setters
	//
	// *************************************************************************

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
