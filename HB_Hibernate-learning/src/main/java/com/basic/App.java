package com.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		System.out.println("Project Started...");

		try {
			// Just for Checking:Testing
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL Connection Driver is fine...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Configuration cfg = new Configuration();
		cfg.configure("com/basic/hibernate.cfg.xml");
		// Sometime this path is automatically searched in current directory but
		// sometimes not.Hence better to give path manually.

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println(factory);
		System.out.println(factory.isClosed()); // If SessionFactory is closed: we will get false;

//		==================================CREATE STUDENT TABLE========================
//		
//		0: First Map the Class in the Hibernate Configuration File
//		1. First Get OpenSession if creating new:, the onward currentSession
//		2. Begin Transaction => Commit It
//		3. close session

//		Student st1 = new Student(101, "Mohan", "Ranchi");

		Session session = factory.openSession();

//		session.save(st1); //save = deprecated, instead use "persist"

		for (int i = 1; i <= 3; i++) {

			Student st1 = new Student(i + 100, "Mohan" + i, "Ranchi" + i);

			// Tracsaction (Tx) is necessary to use only when we save|update any data, not
			// during FETCHING:get,load
			Transaction tx = session.beginTransaction();
			session.persist(st1);
			// as many saving|transaction queries we can write here
			tx.commit();

			// Transaction always must be committed.
		}

		// Address Object Save
		Student st2 = new Student(104, "Rohan", "Delhi");

		Address ad1 = new Address();
		ad1.setStreet("street1");
		ad1.setCity("DELHI");
		ad1.setOpen(true);
		ad1.setAddedDate(new Date());
		ad1.setX(78.9);
		// For Those Who Are Not Set: NULL will be saved.

		Address ad2 = new Address();
		ad2.setStreet("street2");
		ad2.setCity("JAPAN");
		ad2.setOpen(false);
		ad2.setAddedDate(new Date());

		try {
			FileInputStream fis = new FileInputStream("src/main/java/com/basic/krishna.jpg");
			try {
				byte[] data = new byte[fis.available()];
				fis.read(data);

				ad2.setImage(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ad2.setX(98.9);

		Transaction tx = session.beginTransaction();
		session.persist(st2);
		session.persist(ad1);
		session.persist(ad2);
		tx.commit();

//		==============================CLOSING RESOURCE=========================================
		session.close();
		System.out.println("...END...");

	}
}
