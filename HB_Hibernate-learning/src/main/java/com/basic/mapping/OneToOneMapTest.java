package com.basic.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapTest {
	public static void main(String[] args) {
		System.out.println("Project Started...");

		Configuration cfg = new Configuration();
		cfg.configure("com/basic/mapping/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Answer a1 = new Answer();
		a1.setAnswerId(11);
		a1.setAnswer("Java is a programming suite");

		Question q1 = new Question();
		q1.setQuestionId(111);
		q1.setQuestion("What is Java?");
		q1.setAnswer(a1);
		
//		a1.setQuestion(q1);// Useful for BiDirectional

		Question q2 = new Question();
		q2.setQuestionId(112);
		q2.setQuestion("What is Python?");

		Transaction tx = session.beginTransaction();
		session.save(q1);
		session.save(a1);

		session.save(q2);
		tx.commit();

//		----Fetch----
		Question rq1 = session.get(Question.class, 111);
		System.out.println(rq1);
		/**
		 * Question [questionId=111, question=What is Java?, answer=Answer [answerId=11,
		 * answer=Java is a programming suite, question=null]]
		 */

		Answer ra1 = session.get(Answer.class, 11);
		System.out.println(ra1);
		/** Answer [answerId=11, answer=Java is a programming suite, question=null] */

//		==============================CLOSING RESOURCE=========================================
		session.close();
		System.out.println("...END...");

	}
}
