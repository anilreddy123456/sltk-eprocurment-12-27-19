package com.sltk.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sltk.app.model.Polineitems;

@Repository
public interface PolineitemsDao extends JpaRepository<Polineitems, Long>{

}
