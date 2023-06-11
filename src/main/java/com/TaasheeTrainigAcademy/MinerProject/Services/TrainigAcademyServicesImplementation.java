package com.TaasheeTrainigAcademy.MinerProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaasheeTrainigAcademy.MinerProject.Dao.TrainingAcademyJDBC;
import com.TaasheeTrainigAcademy.MinerProject.Entity.Course;
import com.TaasheeTrainigAcademy.MinerProject.Entity.Users;

@Service
public class TrainigAcademyServicesImplementation implements TrainingAcademyServices {
	@Autowired
	private TrainingAcademyJDBC trainingAcademyJDBC;
	@Override
	public List<Users> getAllInstructors() {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getAllInstructors();
	}
	@Override
	public List<String> getCoursesByInstructorId(int id) {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getCoursesByInstructorId(id);
	}
	@Override
	public int addUser(int age, String name, String city, String encryptedPassword, String username,String role) {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.addUser(age,name,city,encryptedPassword,username,role);
	}
	@Override
	public void addCourse(String name, String description) {
		// TODO Auto-generated method stub
		trainingAcademyJDBC.addCourse(name,description);
		
	}
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getAllCourses();
	}
	@Override
	public void assignCourseToInstructor(int id, int cid) {
		trainingAcademyJDBC.assignCourseToInstructor(id,cid);
		
	}
	@Override
	public void assignCourseToStudent(int id, int cid) {
		// TODO Auto-generated method stub
		trainingAcademyJDBC.assignCourseToStudent(id,cid);
	}
	@Override
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getUserById(userId);
	}
	@Override
	public void updateUser(int age, String name, String city, int id) {
		// TODO Auto-generated method stub
		trainingAcademyJDBC.updateUser(age,name,city,id);
		
	}
	@Override
	public void removeInstructorById(int instructorId) {
		// TODO Auto-generated method stub
		trainingAcademyJDBC.removeInstructorById(instructorId);
		
	}
	@Override
	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getCourseById(courseId);
	}
	@Override
	public void updateCourse(int id, String name, String description) {
		trainingAcademyJDBC.updateCourse(name,description,id);
		
	}
	@Override
	public void removeCourseById(int courseId) {
		trainingAcademyJDBC.removeCourseById(courseId);
		
	}
	@Override
	public List<Course> getCoursesListByInstructorId(int INSTRUCTOR_ID) {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getCoursesListByInstructorId(INSTRUCTOR_ID);
	}
	@Override
	public List<Users> getAllStudents() {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getAllStudents();
	}
	@Override
	public Users getUserByUserName(String name) {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getUserObjectByUserName(name);
	}
	@Override
	public List<Course> studentRegisteredCourses(int id) {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.studentRegisteredCourses(id);
	}
	@Override
	public Users getInstructorByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return trainingAcademyJDBC.getInstructorByCourseId(courseId);
	}

}
