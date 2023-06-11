package com.TaasheeTrainigAcademy.MinerProject.Entity;

public class Course {
					String name;
					int id;
					String description;
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public int getId() {
						return id;
					}
					public void setId(int id) {
						this.id = id;
					}
					public String getDescription() {
						return description;
					}
					public void setDescription(String description) {
						this.description = description;
					}
					public Course() {
						super();
						// TODO Auto-generated constructor stub
					}
					public Course(String name, int id, String description) {
						super();
						this.name = name;
						this.id = id;
						this.description = description;
					}
}
