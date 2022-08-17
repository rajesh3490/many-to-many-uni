package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Subject;
import com.ty.manytomany.dto.Teacher;

public class TestGetTeacherById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Teacher teacher = entityManager.find(Teacher.class, 1);

		List<Subject> ls = teacher.getSubject();

		System.out.println("teacher's id is " + teacher.getId());
		System.out.println("teacher's name is " + teacher.getName());
		System.out.println("teacher's age is " + teacher.getAge());

		if (ls != null) {
			for (Subject subject : ls) {
				System.out.println("teacher can teach  " + subject.getName());
				System.out.println("teacher's subject id is   " + subject.getId());
				System.out.println("teacher takes " + subject.getDays() + " to teach " + subject.getName());

			}
		}

	}

}
