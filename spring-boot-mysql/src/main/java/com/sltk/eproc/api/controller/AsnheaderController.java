package com.sltk.eproc.api.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.eproc.api.dao.AsnheaderDao;
import com.sltk.eproc.api.model.Asnheader;


@RestController
@RequestMapping("/asn")
public class AsnheaderController {

	@Autowired
	private AsnheaderDao asnheaderDao;
	
	@PostMapping("/save")
	public void save(@Valid @RequestBody Asnheader asn) {
		asnheaderDao.save(asn);
		System.out.println("ASN created sucessfully");
	}
	
	@GetMapping("/getall")
	 @Transactional
	    public List<Asnheader> getAllAsn() {
		 List<Asnheader> asn=(List<Asnheader>) asnheaderDao.findAll();
	        return asn;
	    }
	    
}
