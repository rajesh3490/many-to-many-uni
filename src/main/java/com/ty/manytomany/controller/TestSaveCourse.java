package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestSaveCourse {

	public static void main(String[] args) {

		List<Student> ls = new ArrayList<Student>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = new Student();
		student.setName("rajesh");
		student.setAge(25);
		ls.add(student);

		Student student1 = new Student();
		student1.setName("lokesh");
		student1.setAge(24);
		ls.add(student1);

		Course course = new Course();
		course.setName("java");
		course.setCost(36000);
		course.setStudent(ls);

		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(student1);
		entityManager.persist(course);
		entityTransaction.commit();
		System.out.println("data is stored");
	}

}
