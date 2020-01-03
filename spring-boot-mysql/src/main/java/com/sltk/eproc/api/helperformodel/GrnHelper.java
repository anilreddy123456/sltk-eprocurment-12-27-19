package com.sltk.eproc.api.helperformodel;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.sltk.eproc.api.model.Grndetails;

public class GrnHelper {

	private String grnnumber;
	private String ponumber;
	private String grncreatedby;
	private String grncreateddate;
	private String grnpostingdate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grnnumber")
	private List<Grndetails> grndetailslist;

	public GrnHelper() {
		super();
		}

	public String getGrnnumber() {
		return grnnumber;
	}

	public void setGrnnumber(String grnnumber) {
		this.grnnumber = grnnumber;
	}

	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}

	public String getGrncreatedby() {
		return grncreatedby;
	}

	public void setGrncreatedby(String grncreatedby) {
		this.grncreatedby = grncreatedby;
	}

	public String getGrncreateddate() {
		return grncreateddate;
	}

	public void setGrncreateddate(String grncreateddate) {
		this.grncreateddate = grncreateddate;
	}

	public String getGrnpostingdate() {
		return grnpostingdate;
	}

	public void setGrnpostingdate(String grnpostingdate) {
		this.grnpostingdate = grnpostingdate;
	}

	public List<Grndetails> getGrndetailslist() {
		return grndetailslist;
	}

	public void setGrndetailslist(List<Grndetails> grndetailslist) {
		this.grndetailslist = grndetailslist;
	}
	
	
	
}
