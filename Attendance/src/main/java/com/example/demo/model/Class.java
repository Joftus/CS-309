package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Class {
	
// ---------- Variables ----------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String id;
	public String name;
	public String description;
	public float lon;
	public float lat;
	public Boolean active;
	public String Info;
	
	
	@OneToMany
	@JsonBackReference
	public List<Attendance> attendance;
	@ManyToOne
	public School school;
	@ManyToMany
	@JsonBackReference
	public List<User> users;
	@OneToMany
	@JsonBackReference
	public List<Message> messages;
	

// ---------- Constructors ----------
	public Class() {
		this.active = false;
		this.attendance = new ArrayList<Attendance>();
		this.users = new ArrayList<User>();
		this.messages = new ArrayList<Message>();
	}
	
	public Class(String name) {
		this.name = name;
		this.active = false;
		this.attendance = new ArrayList<Attendance>();
		this.users = new ArrayList<>();
		this.messages = new ArrayList<Message>();
	}
	
	public Class(String name, User user) {
		this.name = name;
		this.users.add(user);
		this.active = false;
		this.attendance = new ArrayList<Attendance>();
		this.users = new ArrayList<User>();
		this.messages = new ArrayList<Message>();
	}
	
	
	
// ---------- To String ----------
    @Override
    public String toString() {
    		return new ToStringCreator(this)
    				.append("ID", this.id)
    				.append("Name", this.name)
    				.append("Description", this.description)
    				.append("Longitude", this.lon)
    				.append("Latitude", this.lat)
    				.append("Active", this.active)
    				.append("School", this.school)
    				.append("Users", this.users)
    				.append("Attendance", this.attendance)
    				.append("Messages", this.messages)
    				.toString();
    }
}
