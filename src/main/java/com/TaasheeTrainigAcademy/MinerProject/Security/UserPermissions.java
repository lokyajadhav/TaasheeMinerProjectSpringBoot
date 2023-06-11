package com.TaasheeTrainigAcademy.MinerProject.Security;

public enum UserPermissions {
			READ("Read"),
			WRITE("Write"),
			DELETE("Delete");
	       private String permission;
			private UserPermissions(String permission) {
				this.permission = permission;
			}

			

			public String getPermission() {
				return permission;
			}

			
			
}
