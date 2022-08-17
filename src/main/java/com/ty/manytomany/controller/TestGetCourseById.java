package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestGetCourseById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Course course = entityManager.find(Course.class, 1);

		List<Student> ls = course.getStudent();

		System.out.println("course id is " + course.getId());
		System.out.println("course name is " + course.getName());
		System.out.println("course cost is " + course.getCost());

		if (ls != null) {
			for (Student student : ls) {
				System.out.println("student id is " + student.getId());
				System.out.println("student name is " + student.getName());
				System.out.println("student age is " + student.getAge());
			}
		}
	}

}
