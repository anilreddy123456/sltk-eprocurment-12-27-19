package com.sltk.eproc.api.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author DheerajSingh
 */
@Entity
//@Table(name = "company", catalog = "sltkeproc", schema = "")
@Table(name = "company", catalog = "sltk_eprocurment", schema = "")

@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCompid", query = "SELECT c FROM Company c WHERE c.compid = :compid"),
    @NamedQuery(name = "Company.findByCompcode", query = "SELECT c FROM Company c WHERE c.compcode = :compcode"),
    @NamedQuery(name = "Company.findByCompname", query = "SELECT c FROM Company c WHERE c.compname = :compname"),
    @NamedQuery(name = "Company.findByCompregno", query = "SELECT c FROM Company c WHERE c.compregno = :compregno"),
    @NamedQuery(name = "Company.findByComptype", query = "SELECT c FROM Company c WHERE c.comptype = :comptype"),
    @NamedQuery(name = "Company.findByStatus", query = "SELECT c FROM Company c WHERE c.status = :status"),
    @NamedQuery(name = "Company.findByAddress", query = "SELECT c FROM Company c WHERE c.address = :address"),
    @NamedQuery(name = "Company.findByCity", query = "SELECT c FROM Company c WHERE c.city = :city"),
    @NamedQuery(name = "Company.findByState", query = "SELECT c FROM Company c WHERE c.state = :state"),
    @NamedQuery(name = "Company.findByZip", query = "SELECT c FROM Company c WHERE c.zip = :zip"),
    @NamedQuery(name = "Company.findByCountry", query = "SELECT c FROM Company c WHERE c.country = :country"),
    @NamedQuery(name = "Company.findByGstno", query = "SELECT c FROM Company c WHERE c.gstno = :gstno"),
    @NamedQuery(name = "Company.findBypan", query = "SELECT c FROM Company c WHERE c.pan = :pan"),
    @NamedQuery(name = "Company.findByOther", query = "SELECT c FROM Company c WHERE c.other = :other"),
    @NamedQuery(name = "Company.findByCreatedby", query = "SELECT c FROM Company c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "Company.findByCreateddate", query = "SELECT c FROM Company c WHERE c.createddate = :createddate"),
    @NamedQuery(name = "Company.findByLastmodifiedby", query = "SELECT c FROM Company c WHERE c.lastmodifiedby = :lastmodifiedby"),
    @NamedQuery(name = "Company.findByLastmodifieddate", query = "SELECT c FROM Company c WHERE c.lastmodifiedate = :lastmodifiedate")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comp_id")
    private Integer compid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "comp_code")
    private String compcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "comp_name")
    private String compname;
    @Size(max = 255)
    @Column(name = "comp_reg_no")
    private String compregno;
    @Size(max = 255)
    @Column(name = "comp_type")
    private String comptype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "state")
    private String state;
    @Size(max = 6)
    @Column(name = "zip")
    private String zip;
    @Size(max = 50)
    @Column(name = "country")
    private String country;
    @Size(max = 255)
    @Column(name = "gst_no")
    private String gstno;
    @Size(max = 255)
    @Column(name = "pan")
    private String pan;
    @Size(max = 255)
    @Column(name = "other")
    private String other;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "created_by")
    private String createdby;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "last_modified_by")
    private String lastmodifiedby;
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodifiedate;
    @OneToMany(mappedBy = "compid")
    private List<Poheader> poheaderlist;
    @OneToMany(mappedBy = "compid")
    private List<Invoices> invoiceslist;
    @OneToMany(mappedBy = "company")
    private List<Vendor> vendorlist;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compid")
    private List<User> userlist;

    public Company() {
    }

    public Company(Integer compid) {
        this.compid = compid;
    }

    public Company(Integer compid, String compcode, String compname, short status, String createdby, String lastmodifiedby) {
        this.compid = compid;
        this.compcode = compcode;
        this.compname = compname;
        this.status = status;
        this.createdby = createdby;
        this.lastmodifiedby = lastmodifiedby;
    }

    public Integer getCompid() {
        return compid;
    }

    public void setCompid(Integer compid) {
        this.compid = compid;
    }

    public String getCompcode() {
        return compcode;
    }

    public void setCompcode(String compcode) {
        this.compcode = compcode;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getCompregno() {
        return compregno;
    }

    public void setCompregno(String compregno) {
        this.compregno = compregno;
    }

    public String getComptype() {
        return comptype;
    }

    public void setComptype(String comptype) {
        this.comptype = comptype;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
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

    public String getGstno() {
        return gstno;
    }

    public void setGstno(String gstno) {
        this.gstno = gstno;
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

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public Date getLastmodifiedate() {
        return lastmodifiedate;
    }

    public void setLastmodifieddate(Date lastmodifiedate) {
        this.lastmodifiedate = lastmodifiedate;
    }

    public List<Poheader> getPoheaderlist() {
        return poheaderlist;
    }

    public void setPoheaderlist(List<Poheader> poheaderlist) {
        this.poheaderlist = poheaderlist;
    }

    public List<Invoices> getInvoiceslist() {
        return invoiceslist;
    }

    public void setInvoiceslist(List<Invoices> invoiceslist) {
        this.invoiceslist = invoiceslist;
    }

    public List<Vendor> getVendorlist() {
        return vendorlist;
    }

    public void setVendorlist(List<Vendor> vendorlist) {
        this.vendorlist = vendorlist;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compid != null ? compid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.compid == null && other.compid != null) || (this.compid != null && !this.compid.equals(other.compid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javatechie.spring.mysql.api.model.Company[ compid=" + compid + " ]";
    }
    
}

