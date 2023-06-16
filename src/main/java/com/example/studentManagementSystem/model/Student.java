package com.example.studentManagementSystem.model;
import jakarta.persistence.*;


@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stuId;
	
	@Column(name = "fName")
	private String fName;
	
	@Column(name = "lName")
	private String lName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "className")
	private String className;
	
	@Column(name = "contact")
	private long contact;
	
	public Student(){}

	//Generated Constructor
	public Student(long stuId, String fName, String lName, String email, String className, long contact) {
		super();
		this.stuId = stuId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.className = className;
		this.contact = contact;
	}
	
	//getter and setter methods for all fields
	public long getStuId() {
		return stuId;
	}

	public void setStuId(long stuId) {
		this.stuId = stuId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	
}
