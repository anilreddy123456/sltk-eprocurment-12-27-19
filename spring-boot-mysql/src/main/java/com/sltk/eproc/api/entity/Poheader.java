package com.sltk.eproc.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sltk.eproc.api.model.Asndetails;
import com.sltk.eproc.api.model.Asnheader;

@Entity
//@Table(name = "headertable")
@Table(name = "poheader", catalog = "sltkeproc", schema = "")

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Poheader implements Serializable {
	@Id
	@Basic(optional = false)
	// @NotNull
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
	// @Temporal(TemporalType.TIMESTAMP)
	private String duedate;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
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

	
	@OneToMany( mappedBy = "header", cascade = CascadeType.ALL)
	private List<Polineitems> poitem;

	//@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL,optional = false)
	@JoinColumn(name = "comp_id")
	private Company company;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "po_id")
	private List<AsnDetails> asndetailslist;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "poheader")
	private List<ASN> asnheaderlist;

	public Poheader() {
		
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

	public List<Polineitems> getPoitem() {
		return poitem;
	}

	public void setPoitem(List<Polineitems> itemsupdate) {
		this.poitem = itemsupdate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Poheader [ponumber=" + ponumber + ", vendorsapcode=" + vendorsapcode + ", description=" + description
				+ ", potype=" + potype + ", purchaser=" + purchaser + ", duedate=" + duedate + ", netvalue=" + netvalue
				+ ", taxvalue=" + taxvalue + ", grossvalue=" + grossvalue + ", currency=" + currency + ", createdby="
				+ createdby + ", createddate=" + createddate + ", lastmodifiedby=" + lastmodifiedby
				+ ", lastmodifieddate=" + lastmodifieddate + ", poitem=" + poitem + ", company=" + company + "]";
	}

}
