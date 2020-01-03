package com.sltk.eproc.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "comp_id")
	private Long comp_id;

	@Column(name = "comp_code")
	private String comp_code;

	@Column(name = "comp_name")
	private String comp_name;

	@Column(name = "comp_reg_no")
	private String comp_reg_no;

	@Column(name = "comp_type")
	private String comp_type;

	@Column(name = "status")
	private int status;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zip")
	private String zip;

	@Column(name = "country")
	private String country;

	@Column(name = "gst_no")
	private String gst_no;

	@Column(name = "pan")
	private String pan;

	@Column(name = "other")
	private String other;

	@Column(name = "created_by")
	private String create_by;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;

	@Column(name = "last_modified_by")
	private String last_modified_by;

	@Column(name = "last_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_modified_date;

	//@JsonManagedReference
	@OneToMany( mappedBy = "company", cascade = CascadeType.ALL)
	private Set<Poheader> header;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Long comp_id, String comp_code, String comp_name, String comp_reg_no, String comp_type, int status,
			String address, String city, String state, String zip, String country, String gst_no, String pan,
			String other, String create_by, Date created_date, String last_modified_by, Date last_modified_date,
			Set<Poheader> header) {
		super();
		this.comp_id = comp_id;
		this.comp_code = comp_code;
		this.comp_name = comp_name;
		this.comp_reg_no = comp_reg_no;
		this.comp_type = comp_type;
		this.status = status;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.gst_no = gst_no;
		this.pan = pan;
		this.other = other;
		this.create_by = create_by;
		this.created_date = created_date;
		this.last_modified_by = last_modified_by;
		this.last_modified_date = last_modified_date;
		this.header = header;
	}

	public Long getComp_id() {
		return comp_id;
	}

	public void setComp_id(Long comp_id) {
		this.comp_id = comp_id;
	}

	public String getComp_code() {
		return comp_code;
	}

	public void setComp_code(String comp_code) {
		this.comp_code = comp_code;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getComp_reg_no() {
		return comp_reg_no;
	}

	public void setComp_reg_no(String comp_reg_no) {
		this.comp_reg_no = comp_reg_no;
	}

	public String getComp_type() {
		return comp_type;
	}

	public void setComp_type(String comp_type) {
		this.comp_type = comp_type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGst_no() {
		return gst_no;
	}

	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
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

	public Set<Poheader> getHeader() {
		return header;
	}

	public void setHeader(Set<Poheader> header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "Company [comp_id=" + comp_id + ", comp_code=" + comp_code + ", comp_name=" + comp_name
				+ ", comp_reg_no=" + comp_reg_no + ", comp_type=" + comp_type + ", status=" + status + ", address="
				+ address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country
				+ ", gst_no=" + gst_no + ", pan=" + pan + ", other=" + other + ", create_by=" + create_by
				+ ", created_date=" + created_date + ", last_modified_by=" + last_modified_by + ", last_modified_date="
				+ last_modified_date + ", header=" + header + "]";
	}

	

}
