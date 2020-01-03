package com.sltk.eproc.api.helperformodel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author DheerajSingh
 */


public class PolineitemsHelper implements Serializable {
    
    
    private String lineid;
    
   
    private String asnstatus;
    
    
    private String polineid;
    
    
    private String itemtype;
    
    
    private String materialnumber;
    
    
    private String description;
    
    
    private String plant;
    
    
    private String materialcatagory;
    
    
    private String orderquantity;
    
   
    private String uom;
    
    private String grossvalue;
    
    
    private String netvalue;
    
    
    private String balanceasnqty;
    
    
    private String previousasnqty;
    
    //@JsonBackReference
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private PoheaderHelper ponumber;

    public PolineitemsHelper() {
    }

    public PolineitemsHelper(String lineid) {
        this.lineid = lineid;
    }

    public PolineitemsHelper(String lineid, String polineid) {
        this.lineid = lineid;
        this.polineid = polineid;
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    public String getAsnstatus() {
        return asnstatus;
    }

    public void setAsnstatus(String asnstatus) {
        this.asnstatus = asnstatus;
    }

    public String getPolineid() {
        return polineid;
    }

    public void setPolineid(String polineid) {
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

    public String getGrossvalue() {
        return grossvalue;
    }

    public void setGrossvalue(String grossvalue) {
        this.grossvalue = grossvalue;
    }

    public String getNetvalue() {
        return netvalue;
    }

    public void setNetvalue(String netvalue) {
        this.netvalue = netvalue;
    }

    public String getBalanceasnqty() {
        return balanceasnqty;
    }

    public void setBalanceasnqty(String balanceasnqty) {
        this.balanceasnqty = balanceasnqty;
    }

    public String getPreviousasnqty() {
        return previousasnqty;
    }

    public void setPreviousasnqty(String previousasnqty) {
        this.previousasnqty = previousasnqty;
    }

    public PoheaderHelper getPonumber() {
        return ponumber;
    }

    public void setPonumber(PoheaderHelper ponumber) {
        this.ponumber = ponumber;
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
        if (!(object instanceof PolineitemsHelper)) {
            return false;
        }
        PolineitemsHelper other = (PolineitemsHelper) object;
        if ((this.lineid == null && other.lineid != null) || (this.lineid != null && !this.lineid.equals(other.lineid))) {
            return false;
        }
        return true;
    }

	
	  @Override public String toString() { return
	  "com.javatechie.spring.mysql.api.model.Polineitems[ lineid=" + lineid + " ]"; }
	 
    
}
