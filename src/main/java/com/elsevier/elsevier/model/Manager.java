package com.elsevier.elsevier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Manager")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "manager_id")
	private Integer id;

	@Column(name = "manager_name")
	private String name;

	@Column(name = "manager_username")
	private String username;

	@Column(name = "manager_password")
	private String password;

	@Column(name = "employee_mail_id")
	private String mailId;

	public Manager() {
	}

	public Manager(Integer id, String name, String username, String password, String mailId) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.mailId = mailId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

}
