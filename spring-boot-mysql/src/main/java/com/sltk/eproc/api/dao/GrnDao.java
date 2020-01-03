package com.sltk.eproc.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.eproc.api.entity.Grn;



@Repository
public interface GrnDao extends JpaRepository<Grn, Long> {

}
