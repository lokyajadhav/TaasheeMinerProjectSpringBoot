package com.TaasheeTrainigAcademy.MinerProject.Controllers;

import java.security.Principal;
import java.util.List;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TaasheeTrainigAcademy.MinerProject.Entity.Course;
import com.TaasheeTrainigAcademy.MinerProject.Entity.Users;
import com.TaasheeTrainigAcademy.MinerProject.Services.TrainigAcademyServicesImplementation;
import com.TaasheeTrainigAcademy.MinerProject.Services.TrainingAcademyServices;


@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private TrainingAcademyServices trainingAcademyServices;
	@Autowired
	PasswordEncoder passwordEncoder;
	
    
	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@GetMapping()
	public String HomePage()
	{
		return "homePage";
	}
	@GetMapping("/adminHomePage")
	public String AdminHomePage(ModelMap modelMap)
	{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Users Admin=trainingAcademyServices.getUserByUserName(authentication.getName());
		modelMap.put("admin", Admin);
		List<Users> instructorList=trainingAcademyServices.getAllInstructors();
		for(Users instructor: instructorList)
		{
			
			instructor.setCourses(getCoursesByInstructorId(instructor.getId()));
		}
		List<Course> courseList=trainingAcademyServices.getAllCourses();
		modelMap.put("courseList", courseList);
		modelMap.put("instructorsList", instructorList);
		return "adminHomePage";
	}
	@GetMapping("/getInstructorCourses")
	private List<String> getCoursesByInstructorId(int id) {
		return trainingAcademyServices.getCoursesByInstructorId(id);
	}
	@GetMapping("/addUser")
	public String getAddForm()
	{
		return "addOrUpdateUser";
	}
	@GetMapping("/getaddCourseForm")
	public String getCourseForm()
	{
		return "addCourse";
	}
	
	@GetMapping("/getAssignCourseForm")
	public String getAssignForm(ModelMap modelMap)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<Users> StudentList=trainingAcademyServices.getAllStudents();
		modelMap.put("studentList", StudentList);
		List<Users> instructorList=trainingAcademyServices.getAllInstructors();
		modelMap.put("instructorsList", instructorList);
		List<Course> courseList=trainingAcademyServices.getAllCourses();
		modelMap.put("courseList", courseList);
		
		Users Instructor=trainingAcademyServices.getUserByUserName(authentication.getName());
		List<Course> instructorCourseList=trainingAcademyServices.getCoursesListByInstructorId(Instructor.getId());
		modelMap.put("instructorCourseList", instructorCourseList);
		return "assignCourse";
	}
	@GetMapping("/getUserById")
	public String getUserById(@RequestParam int userId, ModelMap modelMap)
	{
		Users user=trainingAcademyServices.getUserById(userId);
		modelMap.put("User", user);
		return "addOrUpdateUser";
	}
	@GetMapping("/getCourseById")
	public String getCourseById(@RequestParam int courseId, ModelMap modelMap)
	{
		Course user=trainingAcademyServices.getCourseById(courseId);
		modelMap.put("Course", user);
		return "addCourse";
	}
	@GetMapping("/removeInstructorById")
	public String removeInstructorById(@RequestParam int instructorId, ModelMap modelMap)
	{
		trainingAcademyServices.removeInstructorById(instructorId);
		return AdminHomePage(modelMap);
	}
	@GetMapping("/removeCourseById")
	public String removeCourseById(@RequestParam int courseId, ModelMap modelMap)
	{
		trainingAcademyServices.removeCourseById(courseId);
		return AdminHomePage(modelMap);
	}
	@PostMapping("/userUpdate")
	public String UpdateUser(@RequestParam int age,@RequestParam String name, @RequestParam String city, @RequestParam int id, ModelMap modelMap)
	{
		
		trainingAcademyServices.updateUser(age,name,city,id);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    UserDetails userDetails=(UserDetails) authentication.getPrincipal();
	    if(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
	    {
	    	return AdminHomePage(modelMap);
	    }
	    else
	    {
	    	return InstructorHomePage(modelMap);
	    }
	}
	@PostMapping("/updateCourse")
	public String UpdateCourse(@RequestParam int id,@RequestParam String name, @RequestParam String description, ModelMap modelMap)
	{
		
		trainingAcademyServices.updateCourse(id,name, description);
		return AdminHomePage(modelMap);
	}
	@PostMapping("/assignCourse")
	public String AssignCourse(@RequestParam int id,@RequestParam int cid, ModelMap modelMap)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    UserDetails userDetails=(UserDetails) authentication.getPrincipal();
	    if(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
	    {
	    	trainingAcademyServices.assignCourseToInstructor(id,cid);
	    	return AdminHomePage(modelMap);
	    }
	    else
	    {
	    	trainingAcademyServices.assignCourseToStudent(id,cid);
	    	return InstructorHomePage(modelMap);
	    }
	}
	@PostMapping("/userDataSubmit")
	public String addUser(@RequestParam int age,@RequestParam String name, @RequestParam String city,@RequestParam String username, @RequestParam String password, ModelMap modelMap)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    UserDetails userDetails=(UserDetails) authentication.getPrincipal();
	    String encryptedPassword=passwordEncoder.encode(password);
	    String role="STUDENT";
	    if(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
	    {
	    	role="INSTRUCTOR";
	    	int isAdded=trainingAcademyServices.addUser(age,name,city,encryptedPassword,username,role);
	  	  
		    return AdminHomePage(modelMap);
	    }
	    else
	    {
	    	 int isAdded=trainingAcademyServices.addUser(age,name,city,encryptedPassword,username,role);
	   	  
	 	    return InstructorHomePage(modelMap);
	    }
	   
	    
	}
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam String name,@RequestParam String description, ModelMap modelMap)
	{
		trainingAcademyServices.addCourse(name,description);
		return AdminHomePage(modelMap);
	}
	@GetMapping("/instructorHomePage")
	public String InstructorHomePage(ModelMap modelMap)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Users Instructor=trainingAcademyServices.getUserByUserName(authentication.getName());
		modelMap.put("instructor", Instructor);
		List<Course> courseList=trainingAcademyServices.getCoursesListByInstructorId(Instructor.getId());
		modelMap.put("courseList", courseList);
		List<Users> StudentList=trainingAcademyServices.getAllStudents();
		modelMap.put("studentList", StudentList);
		return "instructorHomePage";
	}
	@GetMapping("/studentHomePage")
	public String StudentHomePage(ModelMap modelMap)
	{
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Users Student=trainingAcademyServices.getUserByUserName(authentication.getName());
		modelMap.put("student", Student);
		List<Course> studentRegisteredCourses=trainingAcademyServices.studentRegisteredCourses(Student.getId());
		modelMap.put("courses", studentRegisteredCourses);
		return "studentHomePage";
	}
	@GetMapping("/getCoursePage")
	public String getCoursePage(ModelMap modelMap, @RequestParam int courseId)
	{
		Users Instructor=trainingAcademyServices.getInstructorByCourseId(courseId);
		modelMap.put("instructor", Instructor);
		Course course=trainingAcademyServices.getCourseById(courseId);
		modelMap.put("course", course);
		return "coursePage";
	}
	
	
			
}
