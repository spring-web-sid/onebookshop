package com.onebookshop.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("session")
public class SessionUtil {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		try{
			return sessionFactory.getCurrentSession();
		}
		catch(HibernateException he) {
			return sessionFactory.openSession();
		}
	}
	
}
