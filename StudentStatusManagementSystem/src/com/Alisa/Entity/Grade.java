package com.Alisa.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade")
public class Grade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="class")
	private String cla;
	@Column(name="account")
	private long account;
	@Column(name="name")
	private String name;
	@Column(name="subject")
	private String subject;
	@Column(name="grade")
	private float grade;
	@Column(name="date")
	private String date;
	

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(int id, String cla, long account, String name, String subject,
			float grade, String date) {
		super();
		this.id = id;
		this.cla = cla;
		this.account = account;
		this.name = name;
		this.subject = subject;
		this.grade = grade;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public String getCla() {
		return cla;
	}
	public void setCla(String cla) {
		this.cla = cla;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
}
