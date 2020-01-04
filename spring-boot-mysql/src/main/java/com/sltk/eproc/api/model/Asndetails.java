package com.sltk.eproc.api.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "asndetails", catalog = "sltkeproc", schema = "")
//@Table(name = "asndetails", catalog = "sltk_eprocurment", schema = "")

@NamedQueries({
    @NamedQuery(name = "Asndetails.findAll", query = "SELECT a FROM Asndetails a"),
    @NamedQuery(name = "Asndetails.findByAsndetailid", query = "SELECT a FROM Asndetails a WHERE a.asndetailid = :asndetailid"),
    @NamedQuery(name = "Asndetails.findByPolineid", query = "SELECT a FROM Asndetails a WHERE a.polineid = :polineid"),
    @NamedQuery(name = "Asndetails.findByAsnquantity", query = "SELECT a FROM Asndetails a WHERE a.asnquantity = :asnquantity")})
public class Asndetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asn_detail_id")
    private Integer asndetailid;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "po_line_id")
    private int polineid;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "asn_quantity")
    private BigDecimal asnquantity;
    
 
    @JoinColumn(name = "asn_id", referencedColumnName = "asn_id")
    @ManyToOne
    private Asnheader asnid;
    
    
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader poheaderasn;

    public Asndetails() {
    }
    public Asndetails(Integer asndetailid) {
		//super();
		this.asndetailid = asndetailid;
	}

	
    public Asndetails(Integer asndetailid, int polineid) {
		//super();
		this.asndetailid = asndetailid;
		this.polineid = polineid;
	}
    
    
    public Integer getAsndetailid() {
		return asndetailid;
	}
	public void setAsndetailid(Integer asndetailid) {
		this.asndetailid = asndetailid;
	}
	public int getPolineid() {
		return polineid;
	}
	public void setPolineid(int polineid) {
		this.polineid = polineid;
	}
	public BigDecimal getAsnquantity() {
		return asnquantity;
	}
	public void setAsnquantity(BigDecimal asnquantity) {
		this.asnquantity = asnquantity;
	}
	public Asnheader getAsnid() {
		return asnid;
	}
	public void setAsnid(Asnheader asnid) {
		this.asnid = asnid;
	}
	public Poheader getPoheaderasn() {
		return poheaderasn;
	}
	public void setPoheaderasn(Poheader poheaderasn) {
		this.poheaderasn = poheaderasn;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (asndetailid != null ? asndetailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asndetails)) {
            return false;
        }
        Asndetails other = (Asndetails) object;
        if ((this.asndetailid == null && other.asndetailid != null) || (this.asndetailid != null && !this.asndetailid.equals(other.asndetailid))) {
            return false;
        }
        return true;
    }

	
	  @Override public String toString() { return
	  "com.javatechie.spring.mysql.api.model.Asndetails[ asndetailid=" + asndetailid + " ]"; }
	 
    
}

