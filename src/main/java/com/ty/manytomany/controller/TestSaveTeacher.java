package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Subject;
import com.ty.manytomany.dto.Teacher;

public class TestSaveTeacher {

	public static void main(String[] args) {

		List<Subject> ls = new ArrayList<Subject>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Subject subject1 = new Subject();
		subject1.setName("physics");
		subject1.setDays(60);
		ls.add(subject1);

		Subject subject2 = new Subject();
		subject2.setName("maths");
		subject2.setDays(90);
		ls.add(subject2);

		Subject subject3 = new Subject();
		subject3.setName("chemistry");
		subject3.setDays(45);
		ls.add(subject3);

		Teacher teacher = new Teacher();
		teacher.setName("rajesh");
		teacher.setAge(25);
		teacher.setSubject(ls);

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityManager.persist(subject1);
		entityManager.persist(subject2);
		entityManager.persist(subject3);
		entityTransaction.commit();
		System.out.println("data is stored");

	}
}
