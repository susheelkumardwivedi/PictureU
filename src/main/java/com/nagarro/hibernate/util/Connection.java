package com.nagarro.hibernate.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Connection {
	private static SessionFactory sessionFactory;
	
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	private Connection(){
		super();
	}
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
