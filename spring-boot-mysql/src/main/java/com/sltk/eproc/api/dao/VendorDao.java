package com.sltk.eproc.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sltk.eproc.api.model.Vendor;

public interface VendorDao extends JpaRepository<Vendor, Long> {

}
