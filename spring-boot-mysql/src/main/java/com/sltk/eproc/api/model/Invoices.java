package com.sltk.eproc.api.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author DheerajSingh
 */
@Entity
//@Table(name = "invoices", catalog = "sltkeproc", schema = "")
@Table(name = "invoices", catalog = "sltk_eprocurment", schema = "")


@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findByInvoiceid", query = "SELECT i FROM Invoices i WHERE i.invoiceid = :invoiceid"),
    @NamedQuery(name = "Invoices.findByInvoicenumber", query = "SELECT i FROM Invoices i WHERE i.invoicenumber = :invoicenumber"),
    @NamedQuery(name = "Invoices.findByInvdate", query = "SELECT i FROM Invoices i WHERE i.invdate = :invdate"),
    @NamedQuery(name = "Invoices.findByInvamount", query = "SELECT i FROM Invoices i WHERE i.invamount = :invamount"),
    @NamedQuery(name = "Invoices.findByCgstpercentage", query = "SELECT i FROM Invoices i WHERE i.cgstpercentage = :cgstpercentage"),
    @NamedQuery(name = "Invoices.findByCgstvalue", query = "SELECT i FROM Invoices i WHERE i.cgstvalue = :cgstvalue"),
    @NamedQuery(name = "Invoices.findByFreight", query = "SELECT i FROM Invoices i WHERE i.freight = :freight"),
    @NamedQuery(name = "Invoices.findByOther", query = "SELECT i FROM Invoices i WHERE i.other = :other"),
    @NamedQuery(name = "Invoices.findBySgstpercentage", query = "SELECT i FROM Invoices i WHERE i.sgstpercentage = :sgstpercentage"),
    @NamedQuery(name = "Invoices.findBySgstvalue", query = "SELECT i FROM Invoices i WHERE i.sgstvalue = :sgstvalue"),
    @NamedQuery(name = "Invoices.findByIgstpercentage", query = "SELECT i FROM Invoices i WHERE i.igstpercentage = :igstpercentage"),
    @NamedQuery(name = "Invoices.findByIgstvalue", query = "SELECT i FROM Invoices i WHERE i.igstvalue = :igstvalue"),
    @NamedQuery(name = "Invoices.findByTotalinvamount", query = "SELECT i FROM Invoices i WHERE i.totalinvamount = :totalinvamount"),
    @NamedQuery(name = "Invoices.findByRemarks", query = "SELECT i FROM Invoices i WHERE i.remarks = :remarks")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_id")
    private Integer invoiceid;
    
    @Size(max = 255)
    @Column(name = "invoice_number")
    private String invoicenumber;
    
    @Column(name = "inv_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invdate;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_amount")
    private BigDecimal invamount;
    
    @Column(name = "cgst_percentage")
    private BigDecimal cgstpercentage;
    
    @Column(name = "cgst_value")
    private BigDecimal cgstvalue;
    
    @Column(name = "freight")
    private BigDecimal freight;
    
    @Column(name = "other")
    private BigDecimal other;
    
    @Column(name = "sgst_percentage")
    private BigDecimal sgstpercentage;
    
    @Column(name = "sgst_value")
    private BigDecimal sgstvalue;
    
    @Column(name = "igst_percentage")
    private BigDecimal igstpercentage;
    
    @Column(name = "igst_value")
    private BigDecimal igstvalue;
    
    @Column(name = "total_inv_amount")
    private BigDecimal totalinvamount;
    
    @Size(max = 2000)
    @Column(name = "remarks")
    private String remarks;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceid", fetch = FetchType.LAZY)
    private List<Invoicedetails> invoicedetailslist;
    
  
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
    @ManyToOne
    private Company compid;

	@Transient
	private List<Integer> selectedlineitem; 
	
	@Transient
	private List<BigDecimal> selectedinvoiceprice;
	
	@Transient
	private List<Integer> selectedpoid;
	
	@Transient
	private List<Integer> selectedorderqty;
    
    public Invoices() {
    }

    public Invoices(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(String invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public Date getInvdate() {
        return invdate;
    }

    public void setInvdate(Date invdate) {
        this.invdate = invdate;
    }

    public BigDecimal getInvamount() {
        return invamount;
    }

    public void setInvamount(BigDecimal invamount) {
        this.invamount = invamount;
    }

    public BigDecimal getCgstpercentage() {
        return cgstpercentage;
    }

    public void setCgstpercentage(BigDecimal cgstpercentage) {
        this.cgstpercentage = cgstpercentage;
    }

    public BigDecimal getCgstvalue() {
        return cgstvalue;
    }

    public void setCgstvalue(BigDecimal cgstvalue) {
        this.cgstvalue = cgstvalue;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getSgstpercentage() {
        return sgstpercentage;
    }

    public void setSgstpercentage(BigDecimal sgstpercentage) {
        this.sgstpercentage = sgstpercentage;
    }

    public BigDecimal getSgstvalue() {
        return sgstvalue;
    }

    public void setSgstvalue(BigDecimal sgstvalue) {
        this.sgstvalue = sgstvalue;
    }

    public BigDecimal getIgstpercentage() {
        return igstpercentage;
    }

    public void setIgstpercentage(BigDecimal igstpercentage) {
        this.igstpercentage = igstpercentage;
    }

    public BigDecimal getIgstvalue() {
        return igstvalue;
    }

    public void setIgstvalue(BigDecimal igstvalue) {
        this.igstvalue = igstvalue;
    }

    public BigDecimal getTotalinvamount() {
        return totalinvamount;
    }

    public void setTotalinvamount(BigDecimal totalinvamount) {
        this.totalinvamount = totalinvamount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Invoicedetails> getInvoicedetailslist() {
        return invoicedetailslist;
    }

    public void setInvoicedetailslist(List<Invoicedetails> invoicedetailslist) {
        this.invoicedetailslist = invoicedetailslist;
    }

    public Company getCompid() {
        return compid;
    }

    public void setCompid(Company compid) {
        this.compid = compid;
    }

    public List<Integer> getSelectedlineitem()
	{
		return selectedlineitem;
	}

	public void setSelectedlineitem(List<Integer> selectedlineitem)
	{
		this.selectedlineitem = selectedlineitem;
	}

	public List<BigDecimal> getSelectedinvoiceprice()
	{
		return selectedinvoiceprice;
	}

	public void setSelectedinvoiceprice(List<BigDecimal> selectedinvoiceprice)
	{
		this.selectedinvoiceprice = selectedinvoiceprice;
	}

	public List<Integer> getSelectedpoid()
	{
		return selectedpoid;
	}

	public void setSelectedpoid(List<Integer> selectedpoid)
	{
		this.selectedpoid = selectedpoid;
	}

	public List<Integer> getSelectedorderqty()
	{
		return selectedorderqty;
	}

	public void setSelectedorderqty(List<Integer> selectedorderqty)
	{
		this.selectedorderqty = selectedorderqty;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceid != null ? invoiceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.invoiceid == null && other.invoiceid != null) || (this.invoiceid != null && !this.invoiceid.equals(other.invoiceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javatechie.spring.mysql.api.model.Invoices[ invoiceid=" + invoiceid + " ]";
    }
    
}
