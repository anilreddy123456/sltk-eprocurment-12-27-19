package com.sltk.eproc.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Login_User implements Serializable{

	@Id
	//@GeneratedValue
	@Column(name="user_id")
	public int user_id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "comp_id")
	public Company comp_id;
	
	@Column(name="first_name")
	public String first_name;
	
	@Column(name="middle_name")
	public String middle_name;
	
	@Column(name="last_name")
	public String last_name;
	
	@Column(name="email")
	public String email;
	
	@Column(name="password")
	public String password;
	
	@Column(name="status")
	public int status;
	
	@Column(name="created_by")
	public String created_by;
	
	@Column(name="created_date")
	public Date created_date;
	
	@Column(name="last_modified_by")
	public String last_modified_by;
	
	@Column(name="last_modified_date")
	public Date last_modified_date;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Company getComp_id() {
		return comp_id;
	}

	public void setComp_id(Company comp_id) {
		this.comp_id = comp_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getLast_modified_by() {
		return last_modified_by;
	}

	public void setLast_modified_by(String last_modified_by) {
		this.last_modified_by = last_modified_by;
	}

	public Date getLast_modified_date() {
		return last_modified_date;
	}

	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}

	@Override
	public String toString() {
		return "Login_User [user_id=" + user_id + ", comp_id=" + comp_id + ", first_name=" + first_name
				+ ", middle_name=" + middle_name + ", last_name=" + last_name + ", email=" + email + ", password="
				+ password + ", status=" + status + ", created_by=" + created_by + ", created_date=" + created_date
				+ ", last_modified_by=" + last_modified_by + ", last_modified_date=" + last_modified_date + "]";
	}
	
	
}
