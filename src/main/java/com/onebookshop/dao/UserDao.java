package com.onebookshop.dao;

import com.onebookshop.dto.UserData;
import com.onebookshop.model.UserModel;

public interface UserDao {
	String saveUser(UserModel user);
	UserData loadUserByEmail(String email);
	UserModel getUserByUid(String id);
}
