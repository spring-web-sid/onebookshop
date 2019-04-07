package com.onebookshop.dao.impl;

import com.onebookshop.dao.UserDao;
import com.onebookshop.dto.Role;
import com.onebookshop.dto.UserData;
import com.onebookshop.model.RoleModel;
import com.onebookshop.model.UserModel;
import com.onebookshop.util.SessionUtil;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionUtil session;

	@Override
	public String saveUser(UserModel user) {
		//UserModel um = null;
		String uid = (String) session.getSession().save(user);
		if (!Objects.isNull(uid)) {
			UserModel um = (UserModel) session.getSession().get(UserModel.class, uid);
			RoleModel role = um.getRole();
			role.setUserId(uid);
			session.getSession().save(role);
			return uid;
		}
		return null;
	}

	@Override
	public UserData loadUserByEmail(String username) {
		UserModel user = (UserModel) session.getSession().createCriteria(UserModel.class)
				.add(Restrictions.eq("userId", username)).uniqueResult();
		UserData data = new UserData();
		if (Objects.nonNull(user)) {
			data.setUserId(user.getUserId());
			data.setUsername(user.getName());
			data.setPhoneNo(user.getPhoneNo());
			data.setAddress1(user.getAddress1());
			data.setAddress2(user.getAddress2());
			data.setMailId(user.getMailId());
			data.setPassword(user.getPassword());
			data.setEnabled(user.isEnabled());
			Role role = new Role();
			
			session.getSession().clear();
			SQLQuery query = session.getSession().createSQLQuery("select role from users_roles where userid = ?");
			String r = (String)query.setString(0, user.getUserId()).uniqueResult();
			role.setRole(r);
			List<Role> authorities = new ArrayList<>();
			authorities.add(role);
			data.setAuthorities(authorities);
		}
		return data;
	}

	@Override
	public UserModel getUserByUid(String id) {
		return (UserModel) session.getSession().get(UserModel.class, id);
	}
}
