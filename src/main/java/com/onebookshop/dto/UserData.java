package com.onebookshop.dto;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public class UserData implements UserDetails {
	private String userId;
	private String username;
	private String password;
	private String mailId;
	private long phoneNo;
	private String address1;
	private String address2;
	
	 private List<Role> authorities;
	 public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	private boolean enabled;
	    
	@Override
	public List<Role> getAuthorities() {
		return this.authorities;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
