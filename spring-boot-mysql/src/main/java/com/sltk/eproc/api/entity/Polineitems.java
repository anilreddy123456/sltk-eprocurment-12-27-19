package com.sltk.eproc.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
//@Table(name = "itemtable")
@Table(name = "polineitems", catalog = "sltkeproc", schema = "")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Polineitems implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "line_id")
	private Integer lineid;

	@Size(max = 2)
	@Column(name = "asn_status")
	private String asnstatus;

	@Basic(optional = false)
	@NotNull
	@Column(name = "po_line_id")
	private int polineid;

	@Size(max = 200)
	@Column(name = "item_type")
	private String itemtype;

	@Size(max = 200)
	@Column(name = "material_number")
	private String materialnumber;

	@Size(max = 250)
	@Column(name = "description")
	private String description;

	@Size(max = 10)
	@Column(name = "plant")
	private String plant;

	@Size(max = 200)
	@Column(name = "material_catagory")
	private String materialcatagory;

	@Column(name = "order_quantity")
	private String orderquantity;

	@Size(max = 100)
	@Column(name = "uom")
	private String uom;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "gross_value")
	private BigDecimal grossvalue;

	@Column(name = "net_value")
	private BigDecimal netvalue;

	@Column(name = "balance_asn_qty")
	private BigDecimal balanceasnqty;

	@Column(name = "previous_asn_qty")
	private BigDecimal previousasnqty;

	//@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "ponumber")
	private Poheader header;

	public Polineitems() {
		
	}

	public Integer getLineid() {
		return lineid;
	}

	public void setLineid(Integer lineid) {
		this.lineid = lineid;
	}

	public String getAsnstatus() {
		return asnstatus;
	}

	public void setAsnstatus(String asnstatus) {
		this.asnstatus = asnstatus;
	}

	public int getPolineid() {
		return polineid;
	}

	public void setPolineid(int polineid) {
		this.polineid = polineid;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getMaterialnumber() {
		return materialnumber;
	}

	public void setMaterialnumber(String materialnumber) {
		this.materialnumber = materialnumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getMaterialcatagory() {
		return materialcatagory;
	}

	public void setMaterialcatagory(String materialcatagory) {
		this.materialcatagory = materialcatagory;
	}

	public String getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(String orderquantity) {
		this.orderquantity = orderquantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public BigDecimal getGrossvalue() {
		return grossvalue;
	}

	public void setGrossvalue(BigDecimal grossvalue) {
		this.grossvalue = grossvalue;
	}

	public BigDecimal getNetvalue() {
		return netvalue;
	}

	public void setNetvalue(BigDecimal netvalue) {
		this.netvalue = netvalue;
	}

	public BigDecimal getBalanceasnqty() {
		return balanceasnqty;
	}

	public void setBalanceasnqty(BigDecimal balanceasnqty) {
		this.balanceasnqty = balanceasnqty;
	}

	public BigDecimal getPreviousasnqty() {
		return previousasnqty;
	}

	public void setPreviousasnqty(BigDecimal previousasnqty) {
		this.previousasnqty = previousasnqty;
	}

	public Poheader getHeader() {
		return header;
	}

	public void setHeader(Poheader header) {
		this.header = header;
	}

}
