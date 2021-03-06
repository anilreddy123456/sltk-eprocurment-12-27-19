package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Poheader;

@Repository
public interface HeaderDao extends JpaRepository<Poheader, Long> {

}
