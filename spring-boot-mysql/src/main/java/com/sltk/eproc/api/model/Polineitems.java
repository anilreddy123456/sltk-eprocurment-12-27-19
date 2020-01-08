package com.sltk.eproc.api.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "polineitems", catalog = "sltkeproc", schema = "")
//@Table(name = "polineitems", catalog = "sltk_eprocurment", schema = "")

@NamedQueries({
    @NamedQuery(name = "Polineitems.findAll", query = "SELECT p FROM Polineitems p"),
    @NamedQuery(name = "Polineitems.findByLineid", query = "SELECT p FROM Polineitems p WHERE p.lineid = :lineid"),
    @NamedQuery(name = "Polineitems.findByAsnstatus", query = "SELECT p FROM Polineitems p WHERE p.asnstatus = :asnstatus"),
    @NamedQuery(name = "Polineitems.findByPolineid", query = "SELECT p FROM Polineitems p WHERE p.polineid = :polineid"),
    @NamedQuery(name = "Polineitems.findByItemtype", query = "SELECT p FROM Polineitems p WHERE p.itemtype = :itemtype"),
    @NamedQuery(name = "Polineitems.findByMaterialnumber", query = "SELECT p FROM Polineitems p WHERE p.materialnumber = :materialnumber"),
    @NamedQuery(name = "Polineitems.findByDescription", query = "SELECT p FROM Polineitems p WHERE p.description = :description"),
    @NamedQuery(name = "Polineitems.findByPlant", query = "SELECT p FROM Polineitems p WHERE p.plant = :plant"),
    @NamedQuery(name = "Polineitems.findByMaterialcatagory", query = "SELECT p FROM Polineitems p WHERE p.materialcatagory = :materialcatagory"),
    @NamedQuery(name = "Polineitems.findByOrderquantity", query = "SELECT p FROM Polineitems p WHERE p.orderquantity = :orderquantity"),
    @NamedQuery(name = "Polineitems.findByUom", query = "SELECT p FROM Polineitems p WHERE p.uom = :uom"),
    @NamedQuery(name = "Polineitems.findByGrossvalue", query = "SELECT p FROM Polineitems p WHERE p.grossvalue = :grossvalue"),
    @NamedQuery(name = "Polineitems.findByNetvalue", query = "SELECT p FROM Polineitems p WHERE p.netvalue = :netvalue"),
    @NamedQuery(name = "Polineitems.findByBalanceasnqty", query = "SELECT p FROM Polineitems p WHERE p.balanceasnqty = :balanceasnqty"),
    @NamedQuery(name = "Polineitems.findByPreviousasnqty", query = "SELECT p FROM Polineitems p WHERE p.previousasnqty = :previousasnqty")})
public class Polineitems implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "line_id")
    private Long lineid;
    
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
    private Integer orderquantity;
    
    @Size(max = 100)
    @Column(name = "uom")
    private String uom;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gross_value")
    private BigDecimal grossvalue;
    
    @Column(name = "net_value")
    private BigDecimal netvalue;
    
    @Column(name = "balance_asn_qty")
    private BigDecimal balanceasnqty;
    
    @Column(name = "previous_asn_qty")
    private BigDecimal previousasnqty;
    
   
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineid")
    private List<Grndetails> grndetailslist;
    

    public Polineitems() {
    }
    
    public Polineitems(String lineid) {
        this.lineid = Long.parseLong(lineid);
    }

    public Polineitems(Long lineid) {
        this.lineid = lineid;
    }

    public Polineitems(Long lineid, int polineid) {
        this.lineid = lineid;
        this.polineid = polineid;
    }

    public Long getLineid() {
        return lineid;
    }

    public void setLineid(Long lineid) {
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

    public Integer getOrderquantity() {
        return orderquantity;
    }

    public void setOrderquantity(Integer orderquantity) {
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
		/*
		 * if(balanceasnqty==null) { balanceasnqty=new BigDecimal(orderquantity); }
		 */
        this.balanceasnqty = balanceasnqty;
    }

    public BigDecimal getPreviousasnqty() {
        return previousasnqty;
    }

    public void setPreviousasnqty(BigDecimal previousasnqty) {
        this.previousasnqty = previousasnqty;
    }

    public Poheader getPonumber() {
        return ponumber;
    }

    public void setPonumber(Poheader ponumber) {
        this.ponumber = ponumber;
    }
    
    

    public List<Grndetails> getGrndetailslist() {
		return grndetailslist;
	}

	public void setGrndetailslist(List<Grndetails> grndetailslist) {
		this.grndetailslist = grndetailslist;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (lineid != null ? lineid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polineitems)) {
            return false;
        }
        Polineitems other = (Polineitems) object;
        if ((this.lineid == null && other.lineid != null) || (this.lineid != null && !this.lineid.equals(other.lineid))) {
            return false;
        }
        return true;
    }

	
	  @Override public String toString() { return
	  "com.javatechie.spring.mysql.api.model.Polineitems[ lineid=" + lineid + " ]"; }
	 
    
}
