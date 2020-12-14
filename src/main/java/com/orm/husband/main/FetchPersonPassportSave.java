package com.orm.husband.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import one.to.one.Husband;
import one.to.one.Wife;

public class FetchPersonPassportSave {

	// This Method Is Used To Create The Hibernate's SessionFactory Object
	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration
		// File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");
		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		// Creating Hibernate SessionFactory Instance
		SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void main(String[] args) {
		Session sessionObj = buildSessionFactory().getCurrentSession();
		// Getting Transaction Object From Session Object

		//try {
			sessionObj.beginTransaction();

		
			Husband husband = new Husband();
			husband.setName("Firew");
			husband.setEmail("johnwalk@gmail.com");
			
			
			Wife wife = new Wife();
			wife.setName("Tsge");
			wife.setEyecolor("Brown");
			
			// This is important
			wife.setHusband(husband);
			
			// Save always child record!
			sessionObj.save(wife);

			sessionObj.getTransaction().commit();
			
		//} catch (Exception ex) {
			//buildSessionFactory().close();
		}

	}


