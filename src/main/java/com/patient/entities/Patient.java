package com.patient.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patients")
public class Patient {

	// All given validations

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private int id;

	@NotBlank(message = "Name field cann't be blank")
	@Size(min = 3, message = "Name field at least 3 character")
	private String name;

	@NotBlank(message = "Address field cann't be blank")
	@Size(min = 10, message = "Address field at least 10 character")
	private String address;

	@NotBlank(message = "Email field cann't be blank")
	@Email(message = "Please enter valid email")
	private String email;

	private long phoneNumber;

	@NotBlank(message = "Password field cann't be blank")
	@Size(min = 8, max = 15, message = "Password field length between 8 and 15 character")
	private String password;

	@Override
	public String toString() {
		return "Patient [id=" + id + ", fullName=" + name + ", address=" + address + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(int id, String name, String address, String email, long phoneNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
