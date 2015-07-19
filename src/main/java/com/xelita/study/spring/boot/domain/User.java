package com.xelita.study.spring.boot.domain;

import javax.persistence.*;

@Table(name = "USER")
@Entity
public class User {

	@Id
	private String email;

	@Column
	private String password;

	// *************************************************************************
	//
	// Constructors
	//
	// *************************************************************************

	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
