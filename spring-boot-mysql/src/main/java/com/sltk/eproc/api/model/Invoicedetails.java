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
//@Table(name = "invoicedetails", catalog = "sltkeproc", schema = "")
@Table(name = "invoicedetails", catalog = "sltk_eprocurment", schema = "")
@JsonIgnoreProperties("inspection")
@NamedQueries({
    @NamedQuery(name = "Invoicedetails.findAll", query = "SELECT i FROM Invoicedetails i"),
    @NamedQuery(name = "Invoicedetails.findByInvdetailid", query = "SELECT i FROM Invoicedetails i WHERE i.invdetailid = :invdetailid"),
    @NamedQuery(name = "Invoicedetails.findByPolineid", query = "SELECT i FROM Invoicedetails i WHERE i.polineid = :polineid"),
    @NamedQuery(name = "Invoicedetails.findByInvqty", query = "SELECT i FROM Invoicedetails i WHERE i.invqty = :invqty"),
    @NamedQuery(name = "Invoicedetails.findByInvamount", query = "SELECT i FROM Invoicedetails i WHERE i.invamount = :invamount")})
public class Invoicedetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_detail_id")
    private Integer invdetailid;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "po_line_id")
    private int polineid;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_qty")
    private BigDecimal invqty;
    
    @Column(name = "inv_amount")
    private BigDecimal invamount;
    
    @JsonBackReference
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    @ManyToOne(optional = false)
    private Invoices invoiceid;
    
    @JsonBackReference
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumberinvoice;

    public Invoicedetails() {
    }

    public Invoicedetails(Integer invdetailid) {
        this.invdetailid = invdetailid;
    }

    public Invoicedetails(Integer invdetailid, int polineid) {
        this.invdetailid = invdetailid;
        this.polineid = polineid;
    }

    public Integer getInvdetailid() {
        return invdetailid;
    }

    public void setInvdetailid(Integer invdetailid) {
        this.invdetailid = invdetailid;
    }

    public int getPolineid() {
        return polineid;
    }

    public void setPolineid(int polineid) {
        this.polineid = polineid;
    }

    public BigDecimal getInvqty() {
        return invqty;
    }

    public void setInvqty(BigDecimal invqty) {
        this.invqty = invqty;
    }

    public BigDecimal getInvamount() {
        return invamount;
    }

    public void setInvamount(BigDecimal invamount) {
        this.invamount = invamount;
    }

    public Invoices getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Invoices invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Poheader getPonumberinvoice() {
        return ponumberinvoice;
    }

    public void setPonumberinvoice(Poheader ponumberinvoice) {
        this.ponumberinvoice = ponumberinvoice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invdetailid != null ? invdetailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoicedetails)) {
            return false;
        }
        Invoicedetails other = (Invoicedetails) object;
        if ((this.invdetailid == null && other.invdetailid != null) || (this.invdetailid != null && !this.invdetailid.equals(other.invdetailid))) {
            return false;
        }
        return true;
    }

	
	  @Override public String toString() { return
	  "com.javatechie.spring.mysql.api.model.Invoicedetails[ invdetailid=" + invdetailid + " ]"; }
	 
    
}
