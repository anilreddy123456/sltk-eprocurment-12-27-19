package com.sltk.eproc.api.controller;

import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.eproc.api.dao.GrnDao;
import com.sltk.eproc.api.model.Grn;


@RestController
@RequestMapping("/grn")
public class GrnController {

	@Autowired
	private GrnDao grnDao;
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	@Transactional
	public List<Grn> getAllGrns() {
		
		//logger.debug("debugging mode getall() method");
		List<Grn> grn = (List<Grn>) grnDao.findAll();
		return grn;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String createHeader(@Valid @RequestBody List<Grn> grn) throws ParseException  {
				
		System.out.println(grn.toString());
		
		grnDao.saveAll(grn);
		
		System.out.println(grn.toString());
		return "grn created";
	
	}
}
