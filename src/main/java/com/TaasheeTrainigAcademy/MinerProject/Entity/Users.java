package com.TaasheeTrainigAcademy.MinerProject.Entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;


import com.TaasheeTrainigAcademy.MinerProject.Security.UserPermissions;
import com.TaasheeTrainigAcademy.MinerProject.Security.UserRoles;

public class Users implements UserDetails{
	
	int id;
	String city;
	String name;
	String username;
	String password;
	String role;
	int age;
	List<String> courses;
	public static int INSTRUCTOR_ID;
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public Users(int id, String city, String name, String username, String password, String role, int age) {
		super();
		this.id = id;
		this.city = city;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		INSTRUCTOR_ID=id;
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public Set<SimpleGrantedAuthority> getAuthorities() {
		UserRoles userRoles = UserRoles.STUDENT;
		if (role.equals(UserRoles.ADMIN.name())) {
			userRoles = UserRoles.ADMIN;
		}
		else if(role.equals(UserRoles.INSTRUCTOR.name())) {
			userRoles = UserRoles.INSTRUCTOR;
		}
		
		Set<SimpleGrantedAuthority> perminssion = userRoles.getPermission().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
		perminssion.add(new SimpleGrantedAuthority("ROLE_" + role));  
		return perminssion;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
