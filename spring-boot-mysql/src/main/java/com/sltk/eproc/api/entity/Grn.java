package com.sltk.eproc.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sltk.eproc.api.model.Grndetails;

@Entity
@Table(name = "grn")
public class Grn implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "grn_number")
	    private Long grnnumber;
	    
	    @Size(max = 250)
	    @Column(name = "ponumber")
	    private String ponumber;
	    
	    @Size(max = 250)
	    @Column(name = "grn_created_by")
	    private String grncreatedby;
	    
	    @Column(name = "grn_created_date")
	    //@Temporal(TemporalType.TIMESTAMP)
	    private String grncreateddate;
	    
	    @Column(name = "grn_posting_date")
	   // @Temporal(TemporalType.TIMESTAMP)
	    private String grnpostingdate;
	    

	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnnumber",fetch = FetchType.LAZY)
	    private List<Grndetails> grndetailslist;

	    public Grn() {
	    }

		public Long getGrnnumber() {
			return grnnumber;
		}

		public void setGrnnumber(Long grnnumber) {
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

		@Override
		public String toString() {
			return "Grn [grnnumber=" + grnnumber + ", ponumber=" + ponumber + ", grncreatedby=" + grncreatedby
					+ ", grncreateddate=" + grncreateddate + ", grnpostingdate=" + grnpostingdate + ", grndetailslist="
					+ grndetailslist + "]";
		}
	    
	    
}
