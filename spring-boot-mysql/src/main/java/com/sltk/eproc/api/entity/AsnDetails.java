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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="asndetails")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AsnDetails implements Serializable{


    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asn_detail_id")
    private Integer asndetailid;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "po_line_id")
    private int polineid;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "asn_quantity")
    private BigDecimal asnquantity;
    
    //@JsonBackReference(value="asn")
	@ManyToOne(cascade = CascadeType.ALL ,optional = false)
	@JoinColumn(name = "asn_id")
	private ASN asn_id;
	
	//@JsonBackReference(value="poheader")
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "ponumber")
	private Poheader po_id;

	public Integer getAsndetailid() {
		return asndetailid;
	}

	public void setAsndetailid(Integer asndetailid) {
		this.asndetailid = asndetailid;
	}

	public int getPolineid() {
		return polineid;
	}

	public void setPolineid(int polineid) {
		this.polineid = polineid;
	}

	public BigDecimal getAsnquantity() {
		return asnquantity;
	}

	public void setAsnquantity(BigDecimal asnquantity) {
		this.asnquantity = asnquantity;
	}

	public ASN getAsn_id() {
		return asn_id;
	}

	public void setAsn_id(ASN asn_id) {
		this.asn_id = asn_id;
	}

	public Poheader getPo_id() {
		return po_id;
	}

	public void setPo_id(Poheader po_id) {
		this.po_id = po_id;
	}
	
	
	
}
