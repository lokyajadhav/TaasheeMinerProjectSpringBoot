package com.TaasheeTrainigAcademy.MinerProject.Services;

import java.util.List;

import com.TaasheeTrainigAcademy.MinerProject.Entity.Course;
import com.TaasheeTrainigAcademy.MinerProject.Entity.Users;

public interface TrainingAcademyServices {

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

	void updateCourse(int id, String name, String description);

	void removeCourseById(int courseId);

	List<Course> getCoursesListByInstructorId(int INSTRUCTOR_ID);

	List<Users> getAllStudents();

	Users getUserByUserName(String name);

	List<Course> studentRegisteredCourses(int id);

	Users getInstructorByCourseId(int courseId);

	

}
