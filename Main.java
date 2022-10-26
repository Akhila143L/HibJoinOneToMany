package com.infinite.hibotm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {
public static void main(String[] args) {
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Question  question1 = new Question();
	question1.setQname("What is Java?");
	
	Answer ans1 =  new Answer();
	ans1.setAnswername("Java is a Programming Language");
	ans1.setPostedBy("Prasanna Pappu");
	
	Answer ans2 =  new Answer();
	ans2.setAnswername(" By Using Java  we can make any kind of Application");
	ans2.setPostedBy("Sunil Kumar");
	
	List<Answer> lstAnswers1 = new ArrayList<Answer>();
	lstAnswers1.add(ans1);
	lstAnswers1.add(ans2);
	question1.setAnswers(lstAnswers1);
	session.save(question1);
	transaction.commit();
	session.close();
	System.out.println("Tables Created Successfully...");


}
}
