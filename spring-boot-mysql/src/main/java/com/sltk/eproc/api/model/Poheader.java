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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "poheader", catalog = "sltkeproc", schema = "") 
//@Table(name = "poheader", catalog = "sltk_eprocurment", schema = "")
//@JsonIgnoreProperties("inspection")
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
    //@Temporal(TemporalType.TIMESTAMP)
    private String duedate;
    
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
   // @Temporal(TemporalType.TIMESTAMP)
    private String createddate;
    
    @Size(max = 150)
    @Column(name = "last_modified_by")
    private String lastmodifiedby;
    
    @Column(name = "last_modified_date")
   // @Temporal(TemporalType.TIMESTAMP)
    private String lastmodifieddate;
    
    @JsonBackReference
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Company compid;
    
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ponumber", cascade = CascadeType.ALL)
    private List<Polineitems> polineitemslist;

	
	  @JsonManagedReference
	  
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumberinvoice",fetch =
	  FetchType.LAZY) private List<Invoicedetails> invoicedetailslist;
	  
	  @JsonManagedReference
	  
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "poheaderasn",fetch =
	  FetchType.LAZY) private List<Asndetails> asndetailslist;
	  
	  @JsonManagedReference
	  
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "poheader",fetch =
	  FetchType.LAZY) private List<Asnheader> asnheaderlist;
	 
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

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
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

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public String getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setLastmodifieddate(String lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    public Company getCompid() {
        return compid;
    }

    public void setCompid(Company compid) {
        this.compid = compid;
    }
    

    public List<Polineitems> getPolineitemslist() {
        return polineitemslist;
    }

    public void setPolineitemslist(List<Polineitems> polineitemslist) {
        this.polineitemslist = polineitemslist;
    }

	/*
	 * public List<Invoicedetails> getInvoicedetaislist() { return
	 * invoicedetailslist; }
	 * 
	 * public void setInvoicedetailslist(List<Invoicedetails> invoicedetailslist) {
	 * this.invoicedetailslist = invoicedetailslist; }
	 * 
	 * 
	 * public List<Asndetails> getAsndetailslist() { return asndetailslist; }
	 * 
	 * public void setAsndetailslist(List<Asndetails> asndetailslist) {
	 * this.asndetailslist = asndetailslist; }
	 * 
	 * public List<Asnheader> getAsnheaderlist() { return asnheaderlist; }
	 * 
	 * public void setAsnheaderlist(List<Asnheader> asnheaderlist) {
	 * this.asnheaderlist = asnheaderlist; }
	 */
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
		return "Poheader [ponumber=" + ponumber + ", vendorsapcode=" + vendorsapcode + ", description=" + description
				+ ", potype=" + potype + ", purchaser=" + purchaser + ", duedate=" + duedate + ", netvalue=" + netvalue
				+ ", taxvalue=" + taxvalue + ", grossvalue=" + grossvalue + ", currency=" + currency + ", createdby="
				+ createdby + ", createddate=" + createddate + ", lastmodifiedby=" + lastmodifiedby
				+ ", lastmodifieddate=" + lastmodifieddate + ", compid=" + compid + " polineitemslist=" + polineitemslist + "]";
	}
    
    

	/*
	 * @Override public String toString() { return
	 * "com.javatechie.spring.mysql.api.model.Poheader[ ponumber=" + ponumber +
	 * " ]"; }
	 */
    
}
