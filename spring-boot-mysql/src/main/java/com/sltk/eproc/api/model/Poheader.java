package com.sltk.eproc.api.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author DheerajSingh
 */
@Entity
//@Table(name = "poheader", catalog = "sltkeproc", schema = "") 
@Table(name = "poheader", catalog = "sltk_eprocurment", schema = "")
@NamedQueries({
    @NamedQuery(name = "Poheader.findAll", query = "SELECT p FROM Poheader p"),
    @NamedQuery(name = "Poheader.findByPonumber", query = "SELECT p FROM Poheader p WHERE p.ponumber = :ponumber"),
    @NamedQuery(name = "Poheader.findByVendorsapcode", query = "SELECT p FROM Poheader p WHERE p.vendorsapcode = :vendorsapcode"),
    @NamedQuery(name = "Poheader.findByDescription", query = "SELECT p FROM Poheader p WHERE p.description = :description"),
    @NamedQuery(name = "Poheader.findByPotype", query = "SELECT p FROM Poheader p WHERE p.potype = :potype"),
    @NamedQuery(name = "Poheader.findByPurchaser", query = "SELECT p FROM Poheader p WHERE p.purchaser = :purchaser"),
    @NamedQuery(name = "Poheader.findByDuedate", query = "SELECT p FROM Poheader p WHERE p.duedate = :duedate"),
    @NamedQuery(name = "Poheader.findByNetvalue", query = "SELECT p FROM Poheader p WHERE p.netvalue = :netvalue"),
    @NamedQuery(name = "Poheader.findByTaxvalue", query = "SELECT p FROM Poheader p WHERE p.taxvalue = :taxvalue"),
    @NamedQuery(name = "Poheader.findByGrossvalue", query = "SELECT p FROM Poheader p WHERE p.grossvalue = :grossvalue"),
    @NamedQuery(name = "Poheader.findByCurrency", query = "SELECT p FROM Poheader p WHERE p.currency = :currency"),
    @NamedQuery(name = "Poheader.findByCreatedby", query = "SELECT p FROM Poheader p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Poheader.findByCreateddate", query = "SELECT p FROM Poheader p WHERE p.createddate = :createddate"),
    @NamedQuery(name = "Poheader.findByLastmodifiedby", query = "SELECT p FROM Poheader p WHERE p.lastmodifiedby = :lastmodifiedby"),
    @NamedQuery(name = "Poheader.findByLastmodifieddate", query = "SELECT p FROM Poheader p WHERE p.lastmodifieddate = :lastmodifieddate")})
public class Poheader implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ponumber")
    private Long ponumber;
    
    @Column(name = "vendor_sap_code")
    private String vendorsapcode;
    
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    
    @Size(max = 200)
    @Column(name = "potype")
    private String potype;
    
    @Size(max = 200)
    @Column(name = "purchaser")
    private String purchaser;
    
    @Column(name = "duedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "net_value")
    private BigDecimal netvalue;
    
    @Column(name = "tax_value")
    private BigDecimal taxvalue;
    
    @Column(name = "gross_value")
    private BigDecimal grossvalue;
    
    @Size(max = 10)
    @Column(name = "currency")
    private String currency;
    
    @Size(max = 150)
    @Column(name = "created_by")
    private String createdby;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    
    @Size(max = 150)
    @Column(name = "last_modified_by")
    private String lastmodifiedby;
    
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodifieddate;
    
    @JsonBackReference
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Company compid;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Invoicedetails> invoicedetailslist;
    
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "poheader", cascade = CascadeType.ALL)
    private List<Polineitems> polineitemslist;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Asndetails> asndetailslist;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Asnheader> asnheaderlist;

    public Poheader() {
    }

    public Poheader(Long ponumber) {
        this.ponumber = ponumber;
    }

    public Long getPonumber() {
        return ponumber;
    }

    public void setPonumber(Long ponumber) {
        this.ponumber = ponumber;
    }

    public String getVendorsapcode() {
        return vendorsapcode;
    }

    public void setVendorsapcode(String vendorsapcode) {
        this.vendorsapcode = vendorsapcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPotype() {
        return potype;
    }

    public void setPotype(String potype) {
        this.potype = potype;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public BigDecimal getNetvalue() {
        return netvalue;
    }

    public void setNetvalue(BigDecimal netvalue) {
        this.netvalue = netvalue;
    }

    public BigDecimal getTaxvalue() {
        return taxvalue;
    }

    public void setTaxvalue(BigDecimal taxvalue) {
        this.taxvalue = taxvalue;
    }

    public BigDecimal getGrossvalue() {
        return grossvalue;
    }

    public void setGrossvalue(BigDecimal grossvalue) {
        this.grossvalue = grossvalue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Date getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    public Company getCompid() {
        return compid;
    }

    public void setCompid(Company compid) {
        this.compid = compid;
    }

    public List<Invoicedetails> getInvoicedetaislist() {
        return invoicedetailslist;
    }

    public void setInvoicedetailslist(List<Invoicedetails> invoicedetailslist) {
        this.invoicedetailslist = invoicedetailslist;
    }

    public List<Polineitems> getPolineitemslist() {
        return polineitemslist;
    }

    public void setPolineitemslist(List<Polineitems> polineitemslist) {
        this.polineitemslist = polineitemslist;
    }

    public List<Asndetails> getAsndetailslist() {
        return asndetailslist;
    }

    public void setAsndetailslist(List<Asndetails> asndetailslist) {
        this.asndetailslist = asndetailslist;
    }

    public List<Asnheader> getAsnheaderlist() {
        return asnheaderlist;
    }

    public void setAsnheaderlist(List<Asnheader> asnheaderlist) {
        this.asnheaderlist = asnheaderlist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ponumber != null ? ponumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poheader)) {
            return false;
        }
        Poheader other = (Poheader) object;
        if ((this.ponumber == null && other.ponumber != null) || (this.ponumber != null && !this.ponumber.equals(other.ponumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javatechie.spring.mysql.api.model.Poheader[ ponumber=" + ponumber + " ]";
    }
    
}
