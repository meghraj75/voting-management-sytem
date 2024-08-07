package com.VotingSystem.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Voter {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
     @NotBlank(message="name cannot be blank")
     @Pattern(regexp="^a-zA-Z+$")
     @Size(min=4,max=8,message="only 4 to 8 character")
	private String votername;
	private Date dob;
	private String gender;
	private String username;
	private String password;
	public Voter(int id,
			@NotBlank(message = "name cannot be blank") @Pattern(regexp = "^a-zA-Z+$") @Size(min = 4, max = 8, message = "only 4 to 8 character") String votername,
			Date dob, String gender, String username, String password) {
		super();
		this.id = id;
		this.votername = votername;
		this.dob = dob;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVotername() {
		return votername;
	}
	public void setVotername(String votername) {
		this.votername = votername;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	@Override
	public String toString() {
		return "Voter [id=" + id + ", votername=" + votername + ", dob=" + dob + ", gender=" + gender + ", username="
				+ username + ", password=" + password + "]";
	}
	
}
