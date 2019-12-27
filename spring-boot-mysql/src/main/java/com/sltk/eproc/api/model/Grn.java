package com.sltk.eproc.api.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DheerajSingh
 */
@Entity
//@Table(name = "grn", catalog = "sltkeproc", schema = "")
@Table(name = "grn", catalog = "sltk_eprocurment", schema = "")

@NamedQueries({
    @NamedQuery(name = "Grn.findAll", query = "SELECT g FROM Grn g"),
    @NamedQuery(name = "Grn.findByGrnnumber", query = "SELECT g FROM Grn g WHERE g.grnnumber = :grnnumber"),
    @NamedQuery(name = "Grn.findByPonumber", query = "SELECT g FROM Grn g WHERE g.ponumber = :ponumber"),
    @NamedQuery(name = "Grn.findByGrncreatedby", query = "SELECT g FROM Grn g WHERE g.grncreatedby = :grncreatedby"),
    @NamedQuery(name = "Grn.findByGrncreateddate", query = "SELECT g FROM Grn g WHERE g.grncreateddate = :grncreateddate"),
    @NamedQuery(name = "Grn.findByGrnpostingdate", query = "SELECT g FROM Grn g WHERE g.grnpostingdate = :grnpostingdate")})
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date grncreateddate;
    @Column(name = "grn_posting_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date grnpostingdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnnumber")
    private List<Grndetails> grndetailslist;

    public Grn() {
    }

    public Grn(Long grnnumber) {
        this.grnnumber = grnnumber;
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

    public Date getGrncreateddate() {
        return grncreateddate;
    }

    public void setGrncreateddate(Date grncreateddate) {
        this.grncreateddate = grncreateddate;
    }

    public Date getGrnpostingdate() {
        return grnpostingdate;
    }

    public void setGrnpostingdate(Date grnpostingdate) {
        this.grnpostingdate = grnpostingdate;
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
        hash += (grnnumber != null ? grnnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grn)) {
            return false;
        }
        Grn other = (Grn) object;
        if ((this.grnnumber == null && other.grnnumber != null) || (this.grnnumber != null && !this.grnnumber.equals(other.grnnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javatechie.spring.mysql.api.model.Grn[ grnnumber=" + grnnumber + " ]";
    }
    
}
