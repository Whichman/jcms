package com.joshuait.entity;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable{
	private Integer id;
	private String userLogin;
	private String userPass;
	private String userNicename;
	private String userEmail;
	private Date userRegistered;
	private String userActivationKey;
	private Integer userStatus;
	private String displayName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserNicename() {
		return userNicename;
	}

	public void setUserNicename(String userNicename) {
		this.userNicename = userNicename;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserRegistered() {
		return userRegistered;
	}

	public void setUserRegistered(Date userRegistered) {
		this.userRegistered = userRegistered;
	}

	public String getUserActivationKey() {
		return userActivationKey;
	}

	public void setUserActivationKey(String userActivationKey) {
		this.userActivationKey = userActivationKey;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return this.id + " " + this.userLogin + " " + this.userPass + " " + this.userNicename + " " + this.userEmail
				+ " " + this.userRegistered + " " + this.userActivationKey + " " + this.userStatus + " "
				+ this.displayName;
	}
}
