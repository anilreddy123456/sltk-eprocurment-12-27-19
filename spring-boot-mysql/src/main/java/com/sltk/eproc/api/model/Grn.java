/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.eproc.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * @author DheerajSingh
 */

@Entity
@Table(name = "grn", catalog = "sltkeproc", schema = "")
@NamedQueries({ @NamedQuery(name = "Grn.findAll", query = "SELECT g FROM Grn g"),
		@NamedQuery(name = "Grn.findByGrnnumber", query = "SELECT g FROM Grn g WHERE g.grnnumber = :grnnumber"),
		@NamedQuery(name = "Grn.findByPonumber", query = "SELECT g FROM Grn g WHERE g.ponumber = :ponumber"),
		@NamedQuery(name = "Grn.findByGrncreatedby", query = "SELECT g FROM Grn g WHERE g.grncreatedby = :grnCreatedBy"),
		@NamedQuery(name = "Grn.findByGrncreateddate", query = "SELECT g FROM Grn g WHERE g.grncreateddate = :grncreateddate"),
		@NamedQuery(name = "Grn.findByGrnpostingdate", query = "SELECT g FROM Grn g WHERE g.grnpostingdate = :grnpostingdate") })
public class Grn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "grn_number")
	private String grnnumber;

	@Size(max = 250)
	@Column(name = "grn_created_by")
	private String grncreatedby;

	@Column(name = "grn_created_date")
	// @Temporal(TemporalType.TIMESTAMP)
	private String grncreateddate;

	@Column(name = "grn_posting_date")
	// @Temporal(TemporalType.TIMESTAMP)
	private String grnpostingdate;

	@Column(name = "ponumber")
	private String ponumber;

	/*
	 * @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
	 * 
	 * @ManyToOne(cascade = CascadeType.ALL,optional = false) private Poheader
	 * ponumber;
	 */

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grnnumber")
	private List<Grndetails> grndetailslist;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grnnumber")
	private List<Invoicedetails> invoicedetailslist;

	public Grn() {
	}

	public Grn(String grnnumber) {
		this.grnnumber = grnnumber;
	}

	public String getGrnnumber() {
		return grnnumber;
	}

	public void setGrnnumber(String grnnumber) {
		this.grnnumber = grnnumber;
	}

	public String getGrncreatedby() {
		return grncreatedby;
	}

	public void setGrncreatedby(String grncreatedby) {
		this.grncreatedby = grncreatedby;
	}

	public String getGrncreateddate() {
		return grncreateddate;
	}

	public void setGrncreateddate(String grncreateddate) {
		this.grncreateddate = grncreateddate;
	}

	public String getGrnpostingdate() {
		return grnpostingdate;
	}

	public void setGrnpostingdate(String grnpostingdate) {
		this.grnpostingdate = grnpostingdate;
	}

	/*
	 * public Poheader getPonumber() { return ponumber; }
	 * 
	 * public void setPonumber(Poheader ponumber) { this.ponumber = ponumber; }
	 */

	public List<Grndetails> getGrndetailslist() {
		return grndetailslist;
	}

	public void setGrndetailslist(List<Grndetails> grndetailslist) {
		this.grndetailslist = grndetailslist;
	}

	public List<Invoicedetails> getInvoicedetailslist() {
		return invoicedetailslist;
	}

	public void setInvoicedetailslist(List<Invoicedetails> invoicedetailslist) {
		this.invoicedetailslist = invoicedetailslist;
	}

	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (grnnumber != null ? grnnumber.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Grn)) {
			return false;
		}
		Grn other = (Grn) object;
		if ((this.grnnumber == null && other.grnnumber != null)
				|| (this.grnnumber != null && !this.grnnumber.equals(other.grnnumber))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Grn [grnnumber=" + grnnumber + ", grncreatedby=" + grncreatedby + ", grncreateddate=" + grncreateddate
				+ ", grnpostingdate=" + grnpostingdate + ", ponumber=" + ponumber + ", grndetailslist=" + grndetailslist
				+ ", invoicedetailslist=" + invoicedetailslist + "]";
	}

	/*
	 * @Override public String toString() { return
	 * "com.sltk.app.entity.Grn[ grnnumber=" + grnnumber + " ]"; }
	 */

}
