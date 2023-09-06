package com.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableTest {

	public static void main(String[] args) {

		System.out.println("Project Started...");

		Configuration cfg = new Configuration();
		cfg.configure("com/basic/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Certificate c1 = new Certificate();
		c1.setCourse("Coding");
		c1.setDuration("1.5");

		Student s1 = new Student();
		s1.setId(190);
		s1.setName("Manoj");
		s1.setCerti(c1);

		Student s2 = new Student();
		s2.setId(191);
		s2.setName("Kiran");
		/** We don't need to have value for Embeddable Field: It can be NULL"*/

		Transaction tx = session.beginTransaction();
		session.persist(s1);
		session.persist(s2);
		tx.commit();
		
		
//		----------Fetch----------
		Student s190 = session.get(Student.class, 190);
		System.out.println(s190);
		
		

//		==============================CLOSING RESOURCE=========================================
		session.close();
		System.out.println("...END...");

	}
}
