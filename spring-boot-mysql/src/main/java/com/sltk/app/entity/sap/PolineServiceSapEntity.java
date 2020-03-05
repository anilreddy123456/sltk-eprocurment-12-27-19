package com.sltk.app.entity.sap;

import java.io.Serializable;

public class PolineServiceSapEntity implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String service_no;
	private String po_line_id;
	private String description;
	private String quantity;
	private String uom;
	private String gross_price;
	private String net_value;
	
	public PolineServiceSapEntity() {
		
	}

	public String getService_no() {
		return service_no;
	}

	public void setService_no(String service_no) {
		this.service_no = service_no;
	}

	public String getPo_line_id() {
		return po_line_id;
	}

	public void setPo_line_id(String po_line_id) {
		this.po_line_id = po_line_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getGross_price() {
		return gross_price;
	}

	public void setGross_price(String gross_price) {
		this.gross_price = gross_price;
	}

	public String getNet_value() {
		return net_value;
	}

	public void setNet_value(String net_value) {
		this.net_value = net_value;
	}
	
}
