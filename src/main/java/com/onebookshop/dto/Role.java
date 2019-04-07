package com.onebookshop.dto;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4127477054527691506L;
	
	private String role;

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return this.role;
	}

}
