/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.eproc.api.model;

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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "grndetails", catalog = "sltkeproc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Grndetails.findAll", query = "SELECT g FROM Grndetails g"),
    @NamedQuery(name = "Grndetails.findBygrndetailid", query = "SELECT g FROM Grndetails g WHERE g.grndetailid = :grndetailid"),
    //@NamedQuery(name = "Grndetails.findBypolineid", query = "SELECT g FROM Grndetails g WHERE g.polineid = :polineid"),
    //@NamedQuery(name = "Grndetails.findByplant", query = "SELECT g FROM Grndetails g WHERE g.plant = :plant"),
    @NamedQuery(name = "Grndetails.findByquantity", query = "SELECT g FROM Grndetails g WHERE g.quantity = :quantity"),
    @NamedQuery(name = "Grndetails.findBygrnmovementtype", query = "SELECT g FROM Grndetails g WHERE g.grnmovementtype = :grnmovementtype"),
    //@NamedQuery(name = "Grndetails.findBymatshortdesc", query = "SELECT g FROM Grndetails g WHERE g.matshortdesc = :matshortdesc"),
    @NamedQuery(name = "Grndetails.findBybilloflading", query = "SELECT g FROM Grndetails g WHERE g.billoflading = :billoflading")})
public class Grndetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grn_detail_id")
    private Integer grndetailid;
    
    /**
    @Basic(optional = false)
    @NotNull
    @Column(name = "line_id")
    private String polineid;
    
    @Size(max = 10)
    @Column(name = "plant")
    private String plant;
    **/
    
    @Size(max = 10)
    @Column(name = "plant")
    private String plant;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private BigDecimal quantity;
    
    @Size(max = 255)
    @Column(name = "grn_movement_type")
    private String grnmovementtype;
    
    /**
    @Size(max = 255)
    @Column(name = "mat_short_desc")
    private String matshortdesc;
    **/
    
    @Size(max = 255)
    @Column(name = "bill_of_lading")
    private String billoflading;
    
    @Transient
    private BigDecimal grossValue;
    
    @JoinColumn(name = "grn_number", referencedColumnName = "grn_number")
    @ManyToOne(optional = false)
    private Grn grnnumber;
    
    /**
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumber;
	**/
    
    @JoinColumn(name = "line_id", referencedColumnName = "line_id")
    @ManyToOne(optional = false)
    private Polineitems lineid;

    public Grndetails() {
    }

    public Grndetails(Integer grndetailid) {
        this.grndetailid = grndetailid;
    }

    public Integer getGrndetailid() {
        return grndetailid;
    }

    public void setGrndetailid(Integer grndetailid) {
        this.grndetailid = grndetailid;
    }

    /**
    public String getPolineid() {
        return polineid;
    }

    public void setPolineid(String polineid) {
        this.polineid = polineid;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }
    **/

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getGrnmovementtype() {
        return grnmovementtype;
    }

    public void setGrnmovementtype(String grnmovementtype) {
        this.grnmovementtype = grnmovementtype;
    }

    /**
    public String getMatshortdesc() {
        return matshortdesc;
    }

    public void setMatshortdesc(String matshortdesc) {
        this.matshortdesc = matshortdesc;
    }
    **/

    public String getBilloflading() {
        return billoflading;
    }

    public void setBilloflading(String billoflading) {
        this.billoflading = billoflading;
    }

    public BigDecimal getGrossValue()
	{
		return grossValue;
	}

	public void setGrossValue(BigDecimal grossValue)
	{
		this.grossValue = grossValue;
	}

	public Grn getGrnnumber() {
        return grnnumber;
    }

    public void setGrnnumber(Grn grnnumber) {
        this.grnnumber = grnnumber;
    }


	public Polineitems getLineid()
	{
		return lineid;
	}

	public void setLineid(Polineitems lineid)
	{
		this.lineid = lineid;
	}
	
	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	/**
    public Poheader getPonumber()
	{
		return ponumber;
	}

	public void setPonumber(Poheader ponumber)
	{
		this.ponumber = ponumber;
	}
	**/

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (grndetailid != null ? grndetailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grndetails)) {
            return false;
        }
        Grndetails other = (Grndetails) object;
        if ((this.grndetailid == null && other.grndetailid != null) || (this.grndetailid != null && !this.grndetailid.equals(other.grndetailid))) {
            return false;
        }
        return true;
    }

	/*
	 * @Override public String toString() { return
	 * "com.sltk.app.entity.Grndetails[ grndetailid=" + grndetailid + " ]"; }
	 */
}
