package com.yashshreesquad.erp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name", nullable = false)
	@NotNull(message = "First Name cannot be Null")
	@NotEmpty(message = "First Name cannot be Empty")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id", nullable = false)
	@NotNull(message = "Email cannot be Null")
	@NotEmpty(message = "Email cannot be Empty")
	private String emailID;
	
		
	public Employee() {
		super();
	}
	public Employee(long id, String firstName, String lastName, String emailID) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	

}
