/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

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

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "invoicedetails")
@NamedQueries({
    @NamedQuery(name = "Invoicedetails.findAll", query = "SELECT i FROM Invoicedetails i"),
    @NamedQuery(name = "Invoicedetails.findByInvDetailId", query = "SELECT i FROM Invoicedetails i WHERE i.invDetailId = :invDetailId"),
    @NamedQuery(name = "Invoicedetails.findByPoLineId", query = "SELECT i FROM Invoicedetails i WHERE i.poLineId = :poLineId"),
    @NamedQuery(name = "Invoicedetails.findByInvQty", query = "SELECT i FROM Invoicedetails i WHERE i.invQty = :invQty"),
    @NamedQuery(name = "Invoicedetails.findByInvAmount", query = "SELECT i FROM Invoicedetails i WHERE i.invAmount = :invAmount")})
public class Invoicedetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_detail_id")
    private Integer invDetailId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "po_line_id")
    private String poLineId;
    
    @Column(name = "grn_item_id")
    private String grnItemId;
    
    @Column(name = "inv_doc_item")
    private String invDocItem;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_qty")
    private BigDecimal invQty;
    
    @Column(name = "inv_amount")
    private BigDecimal invAmount;
    
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    @ManyToOne(optional = false)
    private Invoices invoiceId;
    
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumber;
    
    @JoinColumn(name = "grn_number", referencedColumnName = "grn_number")
    @ManyToOne(optional = false)
    private Grn grnNumber;

    public Invoicedetails() {
    }

    public Invoicedetails(Integer invDetailId) {
        this.invDetailId = invDetailId;
    }

    public Invoicedetails(Integer invDetailId, String poLineId) {
        this.invDetailId = invDetailId;
        this.poLineId = poLineId;
    }

    public Integer getInvDetailId() {
        return invDetailId;
    }

    public void setInvDetailId(Integer invDetailId) {
        this.invDetailId = invDetailId;
    }

    public String getPoLineId() {
        return poLineId;
    }

    public void setPoLineId(String poLineId) {
        this.poLineId = poLineId;
    }

    public String getGrnItemId()
	{
		return grnItemId;
	}

	public void setGrnItemId(String grnItemId)
	{
		this.grnItemId = grnItemId;
	}

	public String getInvDocItem()
	{
		return invDocItem;
	}

	public void setInvDocItem(String invDocItem)
	{
		this.invDocItem = invDocItem;
	}

	public BigDecimal getInvQty() {
        return invQty;
    }

    public void setInvQty(BigDecimal invQty) {
        this.invQty = invQty;
    }

    public BigDecimal getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(BigDecimal invAmount) {
        this.invAmount = invAmount;
    }

    public Invoices getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoices invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Poheader getPonumber() {
        return ponumber;
    }

    public void setPonumber(Poheader ponumber) {
        this.ponumber = ponumber;
    }

    public Grn getGrnNumber()
	{
		return grnNumber;
	}

	public void setGrnNumber(Grn grnNumber)
	{
		this.grnNumber = grnNumber;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (invDetailId != null ? invDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoicedetails)) {
            return false;
        }
        Invoicedetails other = (Invoicedetails) object;
        if ((this.invDetailId == null && other.invDetailId != null) || (this.invDetailId != null && !this.invDetailId.equals(other.invDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sltk.app.entity.Invoicedetails[ invDetailId=" + invDetailId + " ]";
    }
    
}
