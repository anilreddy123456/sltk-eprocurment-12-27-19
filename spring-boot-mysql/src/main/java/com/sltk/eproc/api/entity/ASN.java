package com.sltk.eproc.api.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="asnheader")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ASN implements Serializable{

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
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asn_id")
    private List<AsnDetails> asndetailslist;
	
   // @JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL,  optional = false)
	@JoinColumn(name = "ponumber")
	private Poheader poheader;
	
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

	public List<AsnDetails> getAsndetailslist() {
		return asndetailslist;
	}

	public void setAsndetailslist(List<AsnDetails> asndetailslist) {
		this.asndetailslist = asndetailslist;
	}

	public Poheader getPoheader() {
		return poheader;
	}

	public void setPoheader(Poheader poheader) {
		this.poheader = poheader;
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
	public String toString() {
		return "ASN [asnid=" + asnid + ", asnno=" + asnno + ", asncreatedate=" + asncreatedate + ", customername="
				+ customername + ", deliverydate=" + deliverydate + ", modeoftransport=" + modeoftransport
				+ ", shippingdate=" + shippingdate + ", asnstatus=" + asnstatus + ", transportcode=" + transportcode
				+ ", shippingaddress=" + shippingaddress + ", asndetailslist=" + asndetailslist + ", poheader=" + poheader
				+ ", selectedlineitem=" + selectedlineitem + ", selectedasnqty=" + selectedasnqty
				+ ", asncreatedatestring=" + asncreatedatestring + ", deliverydatestring=" + deliverydatestring
				+ ", shippingdatestring=" + shippingdatestring + "]";
	}
	
	
	
	
	
}

/*
 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional =
 * false)
 * 
 * @JoinColumn(name = "line_item_id") private POItem poItem;
 * 
 * @ManyToOne(fetch = FetchType.LAZY)
 * 
 * @JoinColumn(name = "material_type", referencedColumnName = "material_type")
 * private POItem po_mat_type ;
 * 
 * @ManyToOne(fetch = FetchType.LAZY)
 * 
 * @JoinColumn(name = "asn_quantity", referencedColumnName =
 * "balance_asn_quantity") private POItem po_asn_quantity;
 */



