package com.orm.husband.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import one.to.one.Wife;

public class PersonPassportSave {
	

		// This Method Is Used To Create The Hibernate's SessionFactory Object
	    private static SessionFactory buildSessionFactory() {
	        // Creating Configuration Instance & Passing Hibernate Configuration File
	        Configuration configObj = new Configuration();
	        configObj.configure("hibernate.cfg.xml");
	        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
	        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
	        // Creating Hibernate SessionFactory Instance
	        SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
	        return sessionFactoryObj;
	    }

		public static void main(String[] args) {
			Session sessionObj=buildSessionFactory().getCurrentSession();
			 // Getting Transaction Object From Session Object
	        sessionObj.beginTransaction();
	        Query query=sessionObj.createQuery("from Passport");
	        List<Wife> wifes=query.list();
	        wifes.forEach(System.out::println);
	        sessionObj.getTransaction().commit();
			
		}

}
