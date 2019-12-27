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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author DheerajSingh
 */
@Entity
//@Table(name = "asnheader", catalog = "sltkeproc", schema = "")
@Table(name = "asnheader", catalog = "sltk_eprocurment", schema = "")

@NamedQueries({
    @NamedQuery(name = "Asnheader.findAll", query = "SELECT a FROM Asnheader a"),
    @NamedQuery(name = "Asnheader.findByAsnid", query = "SELECT a FROM Asnheader a WHERE a.asnid = :asnid"),
    @NamedQuery(name = "Asnheader.findByAsnno", query = "SELECT a FROM Asnheader a WHERE a.asnno = :asnno"),
    @NamedQuery(name = "Asnheader.findByAsncreatedate", query = "SELECT a FROM Asnheader a WHERE a.asncreatedate = :asncreatedate"),
    @NamedQuery(name = "Asnheader.findByCustomername", query = "SELECT a FROM Asnheader a WHERE a.customername = :customername"),
    @NamedQuery(name = "Asnheader.findByDeliverydate", query = "SELECT a FROM Asnheader a WHERE a.deliverydate = :deliverydate"),
    @NamedQuery(name = "Asnheader.findByModeOftransport", query = "SELECT a FROM Asnheader a WHERE a.modeoftransport = :modeoftransport"),
    @NamedQuery(name = "Asnheader.findByShippingdate", query = "SELECT a FROM Asnheader a WHERE a.shippingdate = :shippingdate"),
    @NamedQuery(name = "Asnheader.findByAsnstatus", query = "SELECT a FROM Asnheader a WHERE a.asnstatus = :asnstatus"),
    @NamedQuery(name = "Asnheader.findByTransportcode", query = "SELECT a FROM Asnheader a WHERE a.transportcode = :transportcode"),
    @NamedQuery(name = "Asnheader.findByShippingsddress", query = "SELECT a FROM Asnheader a WHERE a.shippingaddress = :shippingaddress")})
public class Asnheader implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asn_id")
    private Integer asnid;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "asn_no")
    private String asnno;
    
    @Column(name = "asn_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asncreatedate;
    
    @Size(max = 255)
    @Column(name = "customer_name")
    private String customername;
    
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliverydate;
    
    @Size(max = 255)
    @Column(name = "mode_of_transport")
    private String modeoftransport;
    
    @Column(name = "shipping_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingdate;
    
    @Size(max = 255)
    @Column(name = "asn_status")
    private String asnstatus;
    
    @Column(name = "transport_code")
    private Integer transportcode;
    
    @Size(max = 255)
    @Column(name = "shipping_address")
    private String shippingaddress;
    
    @OneToMany(mappedBy = "asnid")
    private List<Asndetails> asndetailslist;
    
    @JsonBackReference
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumber;

	@Transient
	private List<Integer> selectedlineitem; 
	
	@Transient
	private List<BigDecimal> selectedasnqty;
	
	@Transient
	private String asncreatedatestring;
	
	@Transient
	private String deliverydatestring;
	
	@Transient
	private String shippingdatestring;
    
    public Asnheader() {
    }

    public Asnheader(Integer asnid) {
        this.asnid = asnid;
    }

    public Asnheader(Integer asnid, String asnno) {
        this.asnid = asnid;
        this.asnno = asnno;
    }

    
	public Integer getAsnid() {
		return asnid;
	}

	public void setAsnid(Integer asnid) {
		this.asnid = asnid;
	}

	public String getAsnno() {
		return asnno;
	}

	public void setAsnno(String asnno) {
		this.asnno = asnno;
	}

	public Date getAsncreatedate() {
		return asncreatedate;
	}

	public void setAsncreatedate(Date asncreatedate) {
		this.asncreatedate = asncreatedate;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Date getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getModeoftransport() {
		return modeoftransport;
	}

	public void setModeoftransport(String modeoftransport) {
		this.modeoftransport = modeoftransport;
	}

	public Date getShippingdate() {
		return shippingdate;
	}

	public void setShippingdate(Date shippingdate) {
		this.shippingdate = shippingdate;
	}

	public String getAsnstatus() {
		return asnstatus;
	}

	public void setAsnstatus(String asnstatus) {
		this.asnstatus = asnstatus;
	}

	public Integer getTransportcode() {
		return transportcode;
	}

	public void setTransportcode(Integer transportcode) {
		this.transportcode = transportcode;
	}

	public String getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	public List<Asndetails> getAsndetailslist() {
		return asndetailslist;
	}

	public void setAsndetailslist(List<Asndetails> asndetailslist) {
		this.asndetailslist = asndetailslist;
	}

	public Poheader getPonumber() {
		return ponumber;
	}

	public void setPonumber(Poheader ponumber) {
		this.ponumber = ponumber;
	}

	public List<Integer> getSelectedlineitem() {
		return selectedlineitem;
	}

	public void setSelectedlineitem(List<Integer> selectedlineitem) {
		this.selectedlineitem = selectedlineitem;
	}

	public List<BigDecimal> getSelectedasnqty() {
		return selectedasnqty;
	}

	public void setSelectedasnqty(List<BigDecimal> selectedasnqty) {
		this.selectedasnqty = selectedasnqty;
	}

	public String getAsncreatedatestring() {
		return asncreatedatestring;
	}

	public void setAsncreatedatestring(String asncreatedatestring) {
		this.asncreatedatestring = asncreatedatestring;
	}

	public String getDeliverydatestring() {
		return deliverydatestring;
	}

	public void setDeliverydatestring(String deliverydatestring) {
		this.deliverydatestring = deliverydatestring;
	}

	public String getShippingdatestring() {
		return shippingdatestring;
	}

	public void setShippingdatestring(String shippingdatestring) {
		this.shippingdatestring = shippingdatestring;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (asnid != null ? asnid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asnheader)) {
            return false;
        }
        Asnheader other = (Asnheader) object;
        if ((this.asnid == null && other.asnid != null) || (this.asnid != null && !this.asnid.equals(other.asnid))) {
            return false;
        }
        return true;
    }

	
	  @Override public String toString() { return
	  "com.javatechie.spring.mysql.api.model.Asnheader[ asnid=" + asnid + " ]"; }
	 
    
}
