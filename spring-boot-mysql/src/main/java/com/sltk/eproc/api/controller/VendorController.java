package com.sltk.eproc.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.eproc.api.dao.VendorDao;
import com.sltk.eproc.api.model.Vendor;


@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorDao v_dao;

	@PostMapping("/rigistration")
	public String rigister(@Valid Vendor vendor) {
		
		v_dao.save(vendor);
		
		return "Rigistration sucessfully ";
		
		}
}
