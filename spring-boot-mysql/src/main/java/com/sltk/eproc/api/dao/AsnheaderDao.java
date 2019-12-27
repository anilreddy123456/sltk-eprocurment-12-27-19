package com.sltk.eproc.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.eproc.api.model.Asnheader;
@Repository
public interface AsnheaderDao extends  JpaRepository<Asnheader, Long>{

}
