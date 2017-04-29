package com.uuhouse.bean;

public class User {
	private Integer id;
	private String uid;
	private String username;
	private String password;
	private Integer power;

	// Constructors

	

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String uid, String username, String password, Integer power) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.power = power;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPower() {
		return this.power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}
}
