package com.sltk.eproc.api.entity;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sltk.eproc.api.model.Grn;

@Entity
@Table(name = "grndetails")
public class Grndetails implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grn_detail_id")
    private Integer grndetailid;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "po_line_id")
    private int polineid;
    
    @Size(max = 10)
    @Column(name = "plant")
    private String plant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private BigDecimal quantity;
    
    @Size(max = 255)
    @Column(name = "grn_movement_type")
    private String grnmovementtype;
    
    @Size(max = 255)
    @Column(name = "mat_short_desc")
    private String matshortdesc;
    
    @Size(max = 255)
    @Column(name = "bill_of_lading")
    private String billoflading;
    
    @JsonBackReference
    @JoinColumn(name = "grn_number", referencedColumnName = "grn_number")
    @ManyToOne(optional = false)
    private Grn grnnumber;

    public Grndetails() {
    }

	public Integer getGrndetailid() {
		return grndetailid;
	}

	public void setGrndetailid(Integer grndetailid) {
		this.grndetailid = grndetailid;
	}

	public int getPolineid() {
		return polineid;
	}

	public void setPolineid(int polineid) {
		this.polineid = polineid;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

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

	public String getMatshortdesc() {
		return matshortdesc;
	}

	public void setMatshortdesc(String matshortdesc) {
		this.matshortdesc = matshortdesc;
	}

	public String getBilloflading() {
		return billoflading;
	}

	public void setBilloflading(String billoflading) {
		this.billoflading = billoflading;
	}

	public Grn getGrnnumber() {
		return grnnumber;
	}

	public void setGrnnumber(Grn grnnumber) {
		this.grnnumber = grnnumber;
	}
    
    
    
}
