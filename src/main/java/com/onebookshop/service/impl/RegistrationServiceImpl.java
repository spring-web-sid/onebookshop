package com.onebookshop.service.impl;

import com.onebookshop.dao.UserDao;
import com.onebookshop.model.UserModel;
import com.onebookshop.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private UserDao userDao;
	@Override
	public String saveUser(UserModel user) {		
		return userDao.saveUser(user);
	}


}
