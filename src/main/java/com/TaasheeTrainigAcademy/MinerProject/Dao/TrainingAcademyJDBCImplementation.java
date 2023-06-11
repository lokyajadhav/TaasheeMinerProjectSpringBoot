package com.TaasheeTrainigAcademy.MinerProject.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.TaasheeTrainigAcademy.MinerProject.Entity.Course;
import com.TaasheeTrainigAcademy.MinerProject.Entity.Users;
@Repository
public class TrainingAcademyJDBCImplementation implements TrainingAcademyJDBC {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public UserDetails getUserByUserName(String username) {
		
		return jdbcTemplate.queryForObject("Select * from Users where username=?", new BeanPropertyRowMapper<Users>(Users.class), new Object[] {username});
	}
	@Override
	public List<Users> getAllInstructors() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from Users where role=?",new BeanPropertyRowMapper<Users>(Users.class), new Object[] {"INSTRUCTOR"});
	}
	@Override
	public List<String> getCoursesByInstructorId(int id) {
		// TODO Auto-generated method stub
		String getQuery="SELECT  Courses.name\r\n"
				+ "FROM Courses\r\n"
				+ "INNER JOIN  InstructorsCourseAssigned ON Courses.id = InstructorsCourseAssigned.Course_id\r\n"
				+ "WHERE InstructorsCourseAssigned.instructor_id  = ?";
		return jdbcTemplate.queryForList(getQuery, String.class, id);
	}
	@Override
	public int addUser(int age, String name, String city, String encryptedPassword, String username,String role) {
		// TODO Auto-generated method stub
		String addQuery="INSERT INTO Users(name,city,age,username,password,role) VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(addQuery,new Object[] {name,city,age,username,encryptedPassword,role});
		
	}
	@Override
	public void addCourse(String name, String description) {
		// TODO Auto-generated method stub
		String addQuery="INSERT INTO Courses(name,description) VALUES(?,?)";
		jdbcTemplate.update(addQuery,new Object[] {name,description});

	}
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		String getQuery="Select * from Courses";
		return jdbcTemplate.query(getQuery, new BeanPropertyRowMapper<Course>(Course.class));
	}
	@Override
	public void assignCourseToInstructor(int id, int cid) {
		// TODO Auto-generated method stub
		String addQuery="INSERT INTO InstructorsCourseAssigned(instructor_id,course_id) VALUES(?,?)";
		jdbcTemplate.update(addQuery,new Object[] {id,cid});
	}
	@Override
	public void assignCourseToStudent(int id, int cid) {
		// TODO Auto-generated method stub
		String addQuery="INSERT INTO enrollments(student_id,course_id) VALUES(?,?)";
		jdbcTemplate.update(addQuery,new Object[] {id,cid});
	}
	@Override
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub
		String getQuery="Select * from Users where id=?";
		return 	jdbcTemplate.queryForObject(getQuery, new BeanPropertyRowMapper<Users>(Users.class), new Object[] {userId});

	}
	@Override
	public void updateUser(int age, String name, String city,int id) {
		// TODO Auto-generated method stub
		String updateQuery="update Users set name=? ,city=?,age=?, where id=?";
		jdbcTemplate.update(updateQuery,new Object[] {name,city,age,id});
	}
	@Override
	public void removeInstructorById(int instructorId) {
		// TODO Auto-generated method stub
		String deleteQuery="DELETE from Users where id=?";
		jdbcTemplate.update(deleteQuery,new Object[] {instructorId});
		
	}
	@Override
	public Course getCourseById(int courseId) {
		String getQuery="Select * from Courses where id=?";
		return 	jdbcTemplate.queryForObject(getQuery, new BeanPropertyRowMapper<Course>(Course.class), new Object[] {courseId});
	}
	@Override
	public void updateCourse(String name, String description, int id) {
		String updateQuery="update Courses set name=? ,description=? where id=?";
		jdbcTemplate.update(updateQuery,new Object[] {name,description,id});
	}
	@Override
	public void removeCourseById(int courseId) {
		String deleteQuery="DELETE from Courses where id=?";
		jdbcTemplate.update(deleteQuery,new Object[] {courseId});
		
	}
	@Override
	public List<Course> getCoursesListByInstructorId(int INSTRUCTOR_ID) {
		String getQuery="SELECT  Courses.id,Courses.name,Courses.description\r\n"
				+ "FROM Courses\r\n"
				+ "INNER JOIN  InstructorsCourseAssigned ON Courses.id = InstructorsCourseAssigned.Course_id\r\n"
				+ "WHERE InstructorsCourseAssigned.instructor_id  = ?";
		return jdbcTemplate.query(getQuery, new BeanPropertyRowMapper<Course>(Course.class), new Object[] {INSTRUCTOR_ID});
	}
	@Override
	public List<Users> getAllStudents() {
		
		String getQuery="Select * from Users where role=?";
		return jdbcTemplate.query(getQuery, new BeanPropertyRowMapper<Users>(Users.class),new Object[] {"STUDENT"});
	}
	@Override
	public Users getUserObjectByUserName(String name) {
		String getQuery="Select * from Users where username=?";
		return jdbcTemplate.queryForObject(getQuery, new BeanPropertyRowMapper<Users>(Users.class),new Object[] {name});
	}
	@Override
	public List<Course> studentRegisteredCourses(int id) {
		String getQuery="SELECT  Courses.id,Courses.name,Courses.description\r\n"
				+ "FROM Courses\r\n"
				+ "INNER JOIN enrollments ON Courses.id = enrollments.Course_id\r\n"
				+ "WHERE enrollments.student_id  = ?";
		return jdbcTemplate.query(getQuery, new BeanPropertyRowMapper<Course>(Course.class), new Object[] {id});	}
	@Override
	public Users getInstructorByCourseId(int courseId) {
		String getQuery="SELECT  Users.name,Users.id,Users.city,Users.age\r\n"
				+ "FROM Users\r\n"
				+ "INNER JOIN InstructorsCourseAssigned ON Users.id = InstructorsCourseAssigned.instructor_id\r\n"
				+ "WHERE InstructorsCourseAssigned.course_id  = ?";
		return jdbcTemplate.queryForObject(getQuery, new BeanPropertyRowMapper<Users>(Users.class), new Object[] {courseId});	}
	}


