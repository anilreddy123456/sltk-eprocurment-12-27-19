/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "invoices")
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findByInvoiceId", query = "SELECT i FROM Invoices i WHERE i.invoiceId = :invoiceId"),
    @NamedQuery(name = "Invoices.findByInvoiceNumber", query = "SELECT i FROM Invoices i WHERE i.invoiceNumber = :invoiceNumber"),
    @NamedQuery(name = "Invoices.findByInvDate", query = "SELECT i FROM Invoices i WHERE i.invDate = :invDate"),
    @NamedQuery(name = "Invoices.findByInvAmount", query = "SELECT i FROM Invoices i WHERE i.invAmount = :invAmount"),
    @NamedQuery(name = "Invoices.findByCgstPercentage", query = "SELECT i FROM Invoices i WHERE i.cgstPercentage = :cgstPercentage"),
    @NamedQuery(name = "Invoices.findByCgstValue", query = "SELECT i FROM Invoices i WHERE i.cgstValue = :cgstValue"),
    @NamedQuery(name = "Invoices.findByFreight", query = "SELECT i FROM Invoices i WHERE i.freight = :freight"),
    @NamedQuery(name = "Invoices.findByOther", query = "SELECT i FROM Invoices i WHERE i.other = :other"),
    @NamedQuery(name = "Invoices.findBySgstPercentage", query = "SELECT i FROM Invoices i WHERE i.sgstPercentage = :sgstPercentage"),
    @NamedQuery(name = "Invoices.findBySgstValue", query = "SELECT i FROM Invoices i WHERE i.sgstValue = :sgstValue"),
    @NamedQuery(name = "Invoices.findByIgstPercentage", query = "SELECT i FROM Invoices i WHERE i.igstPercentage = :igstPercentage"),
    @NamedQuery(name = "Invoices.findByIgstValue", query = "SELECT i FROM Invoices i WHERE i.igstValue = :igstValue"),
    @NamedQuery(name = "Invoices.findByTotalInvAmount", query = "SELECT i FROM Invoices i WHERE i.totalInvAmount = :totalInvAmount"),
    @NamedQuery(name = "Invoices.findByRemarks", query = "SELECT i FROM Invoices i WHERE i.remarks = :remarks")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    
    @Column(name = "invoice_number")
    private String invoiceNumber;
    
    @Column(name = "sap_invoice_number")
    private String sapInvoiceNumber;
    
    @Column(name = "inv_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invDate;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_amount")
    private BigDecimal invAmount;
    
    @Column(name = "cgst_percentage")
    private BigDecimal cgstPercentage;
    
    @Column(name = "cgst_value")
    private BigDecimal cgstValue;
    
    @Column(name = "freight")
    private BigDecimal freight;
    
    @Column(name = "other")
    private BigDecimal other;
    
    @Column(name = "sgst_percentage")
    private BigDecimal sgstPercentage;
    
    @Column(name = "sgst_value")
    private BigDecimal sgstValue;
    
    @Column(name = "igst_percentage")
    private BigDecimal igstPercentage;
    
    @Column(name = "igst_value")
    private BigDecimal igstValue;
    
    @Column(name = "total_inv_amount")
    private BigDecimal totalInvAmount;
    
    @Size(max = 2000)
    @Column(name = "remarks")
    private String remarks;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceId")
    private List<Invoicedetails> invoicedetailsList;
    
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
    @ManyToOne
    private Company compId;

	@Transient
	private List<String> selectedLineItem; 
	
	@Transient
	private List<BigDecimal> selectedInvoicePrice;
	
	@Transient
	private String selectedPoNumber;
	
	@Transient
	private List<String> selectedGrnNumber;
	
	@Transient
	private List<BigDecimal> selectedOrderQty;
	
	//@Transient
	//private List<String> selectedTaxType;
	
	@Transient
	private List<String> selectedGrnItemId;
	
	@Transient
	private List<String> selectedPoLineItem;
    
    public Invoices() {
    }

    public Invoices(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getSapInvoiceNumber()
	{
		return sapInvoiceNumber;
	}

	public void setSapInvoiceNumber(String sapInvoiceNumber)
	{
		this.sapInvoiceNumber = sapInvoiceNumber;
	}

	public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public BigDecimal getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(BigDecimal invAmount) {
        this.invAmount = invAmount;
    }

    public BigDecimal getCgstPercentage() {
        return cgstPercentage;
    }

    public void setCgstPercentage(BigDecimal cgstPercentage) {
        this.cgstPercentage = cgstPercentage;
    }

    public BigDecimal getCgstValue() {
        return cgstValue;
    }

    public void setCgstValue(BigDecimal cgstValue) {
        this.cgstValue = cgstValue;
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

    public BigDecimal getSgstPercentage() {
        return sgstPercentage;
    }

    public void setSgstPercentage(BigDecimal sgstPercentage) {
        this.sgstPercentage = sgstPercentage;
    }

    public BigDecimal getSgstValue() {
        return sgstValue;
    }

    public void setSgstValue(BigDecimal sgstValue) {
        this.sgstValue = sgstValue;
    }

    public BigDecimal getIgstPercentage() {
        return igstPercentage;
    }

    public void setIgstPercentage(BigDecimal igstPercentage) {
        this.igstPercentage = igstPercentage;
    }

    public BigDecimal getIgstValue() {
        return igstValue;
    }

    public void setIgstValue(BigDecimal igstValue) {
        this.igstValue = igstValue;
    }

    public BigDecimal getTotalInvAmount() {
        return totalInvAmount;
    }

    public void setTotalInvAmount(BigDecimal totalInvAmount) {
        this.totalInvAmount = totalInvAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Invoicedetails> getInvoicedetailsList() {
        return invoicedetailsList;
    }

    public void setInvoicedetailsList(List<Invoicedetails> invoicedetailsList) {
        this.invoicedetailsList = invoicedetailsList;
    }

    public Company getCompId() {
        return compId;
    }

    public void setCompId(Company compId) {
        this.compId = compId;
    }

    public List<String> getSelectedLineItem()
	{
		return selectedLineItem;
	}

	public void setSelectedLineItem(List<String> selectedLineItem)
	{
		this.selectedLineItem = selectedLineItem;
	}

	public List<BigDecimal> getSelectedInvoicePrice()
	{
		return selectedInvoicePrice;
	}

	public void setSelectedInvoicePrice(List<BigDecimal> selectedInvoicePrice)
	{
		this.selectedInvoicePrice = selectedInvoicePrice;
	}

	public String getSelectedPoNumber()
	{
		return selectedPoNumber;
	}

	public void setSelectedPoNumber(String selectedPoNumber)
	{
		this.selectedPoNumber = selectedPoNumber;
	}

	public List<String> getSelectedGrnNumber()
	{
		return selectedGrnNumber;
	}

	public void setSelectedGrnNumber(List<String> selectedGrnNumber)
	{
		this.selectedGrnNumber = selectedGrnNumber;
	}

	public List<BigDecimal> getSelectedOrderQty()
	{
		return selectedOrderQty;
	}

	public void setSelectedOrderQty(List<BigDecimal> selectedOrderQty)
	{
		this.selectedOrderQty = selectedOrderQty;
	}

	public List<String> getSelectedGrnItemId()
	{
		return selectedGrnItemId;
	}

	public void setSelectedGrnItemId(List<String> selectedGrnItemId)
	{
		this.selectedGrnItemId = selectedGrnItemId;
	}

	public List<String> getSelectedPoLineItem()
	{
		return selectedPoLineItem;
	}

	public void setSelectedPoLineItem(List<String> selectedPoLineItem)
	{
		this.selectedPoLineItem = selectedPoLineItem;
	}

	/**
	public List<String> getSelectedTaxType()
	{
		return selectedTaxType;
	}

	public void setSelectedTaxType(List<String> selectedTaxType)
	{
		this.selectedTaxType = selectedTaxType;
	}
	**/
	
	

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sltk.app.entity.Invoices[ invoiceId=" + invoiceId + " ]";
    }
    
}
