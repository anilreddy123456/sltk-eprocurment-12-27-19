package com.sltk.eproc.api.helperformodel;
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

//@Table(name = "poheader", catalog = "sltkeproc", schema = "") 
//@Table(name = "poheader", catalog = "sltk_eprocurment", schema = "")

public class PoheaderHelper implements Serializable {

    private static final long serialVersionUID = 1L;
   
    
    private String ponumber;
    
    
    private String vendorsapcode;
    
    
    private String description;
    
    private String potype;
    
    
    private String purchaser;
    
   
    private String duedate;
    
   
    private String netvalue;
    
   
    private String taxvalue;
    
   
    private String grossvalue;
    
    
    private String currency;
    
    
    private String createdby;
    
   
    private String createddate;
    
    
    private String lastmodifiedby;
    
    private String lastmodifieddate;
    
   // @JsonManagedReference
	 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ponumber", cascade = CascadeType.ALL)
    private List<PolineitemsHelper> polineitemslist;
    
    
    public PoheaderHelper() {
    }

    public PoheaderHelper(String ponumber) {
        this.ponumber = ponumber;
    }
    
    public PoheaderHelper(Long ponumber) {
        this.ponumber = String.valueOf(ponumber);
    }

    public String getPonumber() {
        return ponumber;
    }

    public void setPonumber(String ponumber) {
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

    public String getNetvalue() {
        return netvalue;
    }

    public void setNetvalue(String netvalue) {
        this.netvalue = netvalue;
    }

    public String getTaxvalue() {
        return taxvalue;
    }

    public void setTaxvalue(String taxvalue) {
        this.taxvalue = taxvalue;
    }

    public String getGrossvalue() {
        return grossvalue;
    }

    public void setGrossvalue(String grossvalue) {
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

	public List<PolineitemsHelper> getPolineitemslist() {
		return polineitemslist;
	}

	public void setPolineitemslist(List<PolineitemsHelper> polineitemslist) {
		this.polineitemslist = polineitemslist;
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
        if (!(object instanceof PoheaderHelper)) {
            return false;
        }
        PoheaderHelper other = (PoheaderHelper) object;
        if ((this.ponumber == null && other.ponumber != null) || (this.ponumber != null && !this.ponumber.equals(other.ponumber))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "PoheaderHelper [ponumber=" + ponumber + ", vendorsapcode=" + vendorsapcode + ", description="
				+ description + ", potype=" + potype + ", purchaser=" + purchaser + ", duedate=" + duedate
				+ ", netvalue=" + netvalue + ", taxvalue=" + taxvalue + ", grossvalue=" + grossvalue + ", currency="
				+ currency + ", createdby=" + createdby + ", createddate=" + createddate + ", lastmodifiedby="
				+ lastmodifiedby + ", lastmodifieddate=" + lastmodifieddate + ", polineitemslist=" + polineitemslist
				+ "]";
	}
    
    

	/*
	 * @Override public String toString() { return
	 * "com.javatechie.spring.mysql.api.model.Poheader[ ponumber=" + ponumber +
	 * " ]"; }
	 */
    
	/*
	 * @JsonBackReference
	 * 
	 * @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
	 * 
	 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional =
	 * false) private Company compid;
	 * 
	 * @JsonManagedReference
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber") private
	 * List<Invoicedetails> invoicedetailslist;
	 * 
	 * @JsonManagedReference
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "poheader", cascade =
	 * CascadeType.ALL) private List<Polineitems> polineitemslist;
	 * 
	 * @JsonManagedReference
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber") private
	 * List<Asndetails> asndetailslist;
	 * 
	 * @JsonManagedReference
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber") private
	 * List<Asnheader> asnheaderlist;
	 */

}
