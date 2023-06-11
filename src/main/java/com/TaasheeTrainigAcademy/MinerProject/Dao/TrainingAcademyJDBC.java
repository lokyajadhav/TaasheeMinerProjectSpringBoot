package com.TaasheeTrainigAcademy.MinerProject.Dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.TaasheeTrainigAcademy.MinerProject.Entity.Course;
import com.TaasheeTrainigAcademy.MinerProject.Entity.Users;

public interface TrainingAcademyJDBC {

	UserDetails getUserByUserName(String username);

	List<Users> getAllInstructors();

	List<String> getCoursesByInstructorId(int id);

	int addUser(int age, String name, String city, String encryptedPassword, String username,String role);

	void addCourse(String name, String description);

	List<Course> getAllCourses();

	void assignCourseToInstructor(int id, int cid);

	void assignCourseToStudent(int id, int cid);

	Users getUserById(int userId);

	 void updateUser(int age, String name, String city, int id);

	void removeInstructorById(int instructorId);

	Course getCourseById(int courseId);

	void updateCourse(String name, String description, int id);

	void removeCourseById(int courseId);

	List<Course> getCoursesListByInstructorId(int INSTRUCTOR_ID);

	List<Users> getAllStudents();

	Users getUserObjectByUserName(String name);

	List<Course> studentRegisteredCourses(int id);

	Users getInstructorByCourseId(int courseId);

}
