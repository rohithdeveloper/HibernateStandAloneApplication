package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// Student student=new Student("Rohith","Sharma");
		Student student = new Student();
		// student.setId(2);
		student.setFirstName("Rohiht");
		student.setLastName("Sahith");

		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		System.out.println("Saved! check databse");
		session.close();

		Session session1 = sessionFactory.openSession();

		// Student student=new Student("Rohith","Sharma");
		Student student1 = new Student();
		// student.setId(2);
		student1.setFirstName("Don ");
		student1.setLastName("Rohith");

		session1.beginTransaction();
		session1.save(student1);
		session1.getTransaction().commit();
		System.out.println("Saved! check databse");
		session1.close();

	}

}
