package com.sltk.eproc.api.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="vendor")
public class Vendor_Registration implements Serializable{

	@Id
	//@GeneratedValue
	@Column(name="vendor_id")
	public int vendor_id;
	
	@Column(name="comp_id")
	public int comp_id;
	
	@Column(name="vendor_sap_code")
	public int vendor_sap_code;
	
	@Column(name="vendor_company_name")
	public String company_name;
	
	@Column(name="rigistration_no")
	public String rigistration_no;
	
	@Column(name="company_type")
	public String company_type;
	
	@Column(name="address_line1")
	public String address_line1;
	
	@Column(name="address_line2")
	public String address_line2;
	
	@Column(name="city")
	public String city;
	
	@Column(name="state")
	public String state;
	
	@Column(name="pincode")
	public String pincode;
	
	@Column(name="country")
	public String country;
	
	@Column(name="gst_no")
	public String gst_no;
	
	@Column(name="pan")
	public String pan_no;
	
	@Column(name="other")
	public String others;
	
	@Column(name="salutation")
	public String salutation;
	
	@Column(name="first_name")
	public String first_name;
	
	@Column(name="last_name")
	public String last_name;
	
	@Column(name="user_name")
	public String user_name;
	
	@Column(name="phone_no")
	public String ph_no;
	
	@Column(name="mobile_no")
	public String mobile_no;
	
	@Column(name="email_id")
	public String email_id;
	
	@Column(name="acc_holder_name")
	public String acc_holder_name;
	
	@Column(name="account_no")
	public int acc_no;
	
	@Column(name="bank_name")
	public String bank_name;
	
	@Column(name="branch_name")
	public String branch_name;
	
	@Column(name="ifsc_code")
	public String ifsc_code;
	
	@Column(name="bank_country")
	public String bank_country;
	
	@Column(name="bank_region")
	public String bank_region;
	
	@Column(name="bank_city")
	public String bank_city;
	
	@Column(name="production_services")
	public String prodution_services;
	
	
	public Vendor_Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}

	public int getVendor_sap_code() {
		return vendor_sap_code;
	}

	public void setVendor_sap_code(int vendor_sap_code) {
		this.vendor_sap_code = vendor_sap_code;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getRigistration_no() {
		return rigistration_no;
	}

	public void setRigistration_no(String rigistration_no) {
		this.rigistration_no = rigistration_no;
	}

	public String getCompany_type() {
		return company_type;
	}

	public void setCompany_type(String company_type) {
		this.company_type = company_type;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPh_no() {
		return ph_no;
	}

	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAcc_holder_name() {
		return acc_holder_name;
	}

	public void setAcc_holder_name(String acc_holder_name) {
		this.acc_holder_name = acc_holder_name;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getBank_country() {
		return bank_country;
	}

	public void setBank_country(String bank_country) {
		this.bank_country = bank_country;
	}

	public String getBank_region() {
		return bank_region;
	}

	public void setBank_region(String bank_region) {
		this.bank_region = bank_region;
	}

	public String getBank_city() {
		return bank_city;
	}

	public void setBank_city(String bank_city) {
		this.bank_city = bank_city;
	}

	public String getProdution_services() {
		return prodution_services;
	}

	public void setProdution_services(String prodution_services) {
		this.prodution_services = prodution_services;
	}

	
	@Override
	public String toString() {
		return "Vendor_Registration [vendor_id=" + vendor_id + ", comp_id=" + comp_id + ", vendor_sap_code="
				+ vendor_sap_code + ", company_name=" + company_name + ", rigistration_no=" + rigistration_no
				+ ", company_type=" + company_type + ", address_line1=" + address_line1 + ", address_line2="
				+ address_line2 + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", country="
				+ country + ", gst_no=" + gst_no + ", pan_no=" + pan_no + ", others=" + others + ", salutation="
				+ salutation + ", first_name=" + first_name + ", last_name=" + last_name + ", user_name=" + user_name
				+ ", ph_no=" + ph_no + ", mobile_no=" + mobile_no + ", email_id=" + email_id + ", acc_holder_name="
				+ acc_holder_name + ", acc_no=" + acc_no + ", bank_name=" + bank_name + ", branch_name=" + branch_name
				+ ", ifsc_code=" + ifsc_code + ", bank_country=" + bank_country + ", bank_region=" + bank_region
				+ ", bank_city=" + bank_city + ", prodution_services=" + prodution_services + "]";
	}


	
}
