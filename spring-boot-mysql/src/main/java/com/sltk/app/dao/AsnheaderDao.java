package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Asnheader;
@Repository
public interface AsnheaderDao extends  JpaRepository<Asnheader, Long>{

}
