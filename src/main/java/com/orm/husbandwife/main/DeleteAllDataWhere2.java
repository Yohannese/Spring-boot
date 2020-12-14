package com.orm.husbandwife.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



import one.to.one.Husband;

public class DeleteAllDataWhere2 {
	
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
        
        //load and get methods are used to load entity as per it;s primary key
        Husband husband=(Husband) sessionObj.load(Husband.class, 2);
        //deleting below entity
        sessionObj.delete(husband);
        
        sessionObj.getTransaction().commit();
		
	}
}
