package com.sltk.eproc.api.helperformodel;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sltk.eproc.api.model.Grn;

public class GrndetailsHelper {

	private int polineid;
	private String plant;
	private BigDecimal quantity;
	private String grnmovementtype;
	private String matshortdesc;
	private String billoflading;

	@JoinColumn(name = "grn_number", referencedColumnName = "grn_number")
	@ManyToOne(optional = false)
	private Grn grnnumber;

	public GrndetailsHelper() {
		super();
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
