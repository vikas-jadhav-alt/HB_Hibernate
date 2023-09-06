package com.basic.objectStates;

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
		cfg.configure("com/basic/objectStates/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println(factory);
		System.out.println(factory.isClosed()); // If SessionFactory is closed: we will get false;

		Session session = factory.openSession();

		// Object: Transient State
		Student st1 = new Student(188, "Rohan", "Ranchi");

		Transaction tx = session.beginTransaction();
		// Object: Persistent State: Both With SesionObject and DB
		session.persist(st1);
		// Since Object in Persistent State: Any Modification Will Reflect in DB
		st1.setName("Jonny");
		System.out.println("==>" + session.contains(st1)); // ==>true
		tx.commit();

//		==============================Clearing  RESOURCE=========================================
		session.clear();

		// Object: Detached State
		st1.setName("Detached");
		System.out.println("=>=>" + session.contains(st1));// =>=>false

		session.close();

		System.out.println("...END...");

	}
}
