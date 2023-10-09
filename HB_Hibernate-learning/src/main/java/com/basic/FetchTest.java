package com.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchTest {

	/**
	 * --get() returns the object by fetching it from database or from hibernate
	 * cache whereas load() just returns the reference of an object that might not
	 * actually exists, it loads the data from database or cache only when you
	 * access other properties of the object.
	 * 
	 * --get() loads the data as soon as it’s called whereas load() returns a proxy
	 * object and loads data only when it’s actually required.
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("Project Started...");

		Configuration cfg = new Configuration();
		cfg.configure("com/basic/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

//		=================================FETCH: GET vs LOAD=======================================
		/**
		 * ~NOTE: For Fetching: No Need to Transaction begin and commit: It Requires
		 * only for DML Statement ~You can put also: but there will be no much use
		 */

		/**
		 * Student s1 = session.get(Student.class, 101); // Early Fetching: Always Hit
		 * Session Cache or DB => No Need to wait for Print or Call Getter Methods other
		 * than getId() 
		 * >> WHY Other than GetId: because: you have already mentioned in
		 * Java Statement ID: then no need to fetch from DB
		 */

//		  Student s3 = session.get(Student.class, 102); // Data From DB
//		  System.out.println("Student 102: " + s3); 
		
//		  Student s3t = session.get(Student.class, 102); 
//		  System.out.println("Student 102: " + s3t);		  // Here Data Coming From Cache
	  
//		  Student s2 = session.get(Student.class, 186);
//		  System.out.println("Student 186: " + s2); // GET Returns NULL if not found

//		-----Load-----
		System.out.println("--------Load Start-------");
		Student sl1 = session.load(Student.class, 103);
		Student sl2 = session.load(Student.class, 103);
		Student sl3 = session.load(Student.class, 167);
		System.out.println("printing now---");
		System.out.println(sl1); // DB Fetch: Query Called Hibernate
		System.out.println(sl2.getName()); // Session Cache

		System.out.println(sl3.getId()); /* 167 Id Does not exist in database: CAREFULL */
		System.out.println(sl3.getName()); // ERROR: Runtime : Object Not Found Exception

//		==============================CLOSING RESOURCE=========================================
		session.close();
		System.out.println("...END...");

	}
}
