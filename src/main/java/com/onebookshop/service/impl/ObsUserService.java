package com.onebookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.onebookshop.dao.UserDao;
import com.onebookshop.dto.UserData;


public class ObsUserService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	@Override
	public UserData loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.loadUserByEmail(username);
	}

}
