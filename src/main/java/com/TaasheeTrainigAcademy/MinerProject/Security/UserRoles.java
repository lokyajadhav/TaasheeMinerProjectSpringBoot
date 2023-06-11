package com.TaasheeTrainigAcademy.MinerProject.Security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

public enum UserRoles {
	ADMIN(new HashSet<>(Arrays.asList(UserPermissions.READ,UserPermissions.WRITE,UserPermissions.DELETE))),
	INSTRUCTOR(new HashSet<>(Arrays.asList(UserPermissions.READ,UserPermissions.WRITE))),
	STUDENT(new HashSet<>(Arrays.asList(UserPermissions.READ)));
	
	 private Set<UserPermissions> permission;

	private UserRoles(Set<UserPermissions> permission) {
		this.permission = permission;
	}

	public Set<UserPermissions> getPermission() {
		return permission;
	}

	public void setPermission(Set<UserPermissions> permission) {
		this.permission = permission;
	}
	public Set<SimpleGrantedAuthority> getGrantedPermission(){
		Set<SimpleGrantedAuthority> perminssion=getPermission().stream().map(permission->new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
		return perminssion;
}
}
