package com.prowings.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory sessionFactory=buildSessionFactory();
private static final SessionFactory buildSessionFactory() {
	try {
	return new Configuration().configure().buildSessionFactory();
	}
	catch(Throwable ex) {
		System.err.println("buildSessionFactory failed:"+ex);
		throw new ExceptionInInitializerError(ex);
	}
}
public static SessionFactory getSessionFactory() {
	return sessionFactory;
	
}
public static void close() {
	getSessionFactory().close();
}
}
