package com.sltk.eproc.api.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.eproc.api.dao.PoheaderDao;
import com.sltk.eproc.api.helperformodel.PoheaderHelper;
import com.sltk.eproc.api.helperformodel.PolineitemsHelper;
import com.sltk.eproc.api.model.Poheader;
import com.sltk.eproc.api.model.Polineitems;

import javassist.NotFoundException;

@RestController
@RequestMapping("/header")
public class PoheaderController {
	
	//private static final Logger logger=LoggerFactory.getLogger(HeaderController.class);
	@Autowired
	private PoheaderDao poheaderDao;

	
	

	//@GetMapping("/getall")
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	@Transactional
	public List<Poheader> getAllHeader() {
		
		//logger.debug("debugging mode getall() method");
		List<Poheader> h = (List<Poheader>) poheaderDao.findAll();
		return h;
	}

	
	
	//@GetMapping("/get/{id}")
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Poheader getHeaderByID(@PathVariable Long id) throws NotFoundException {
		Optional<Poheader> optHeader = poheaderDao.findById(id);
		if (optHeader.isPresent()) {
			return optHeader.get();
		} else {
			throw new NotFoundException("Header not found with id " + id);
		}
	}

	//@PostMapping("/save")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String createHeader(@Valid @RequestBody List<PoheaderHelper> header, List<PolineitemsHelper> lineitems) throws ParseException  {
				
		System.out.println(header.toString());
		
		List<Poheader> poheadersList = new ArrayList<Poheader>();
		
		List<Polineitems> polineitemsList = new ArrayList<Polineitems>();
		
		for (PoheaderHelper poheaderhelper : header) {
			Poheader poheader = new Poheader();
			poheader.setPonumber(Long.parseLong(poheaderhelper.getPonumber()));
			poheader.setVendorsapcode(poheaderhelper.getVendorsapcode());
			poheader.setDescription(poheaderhelper.getDescription());
			poheader.setPotype(poheaderhelper.getPotype());
			poheader.setPurchaser(poheaderhelper.getPurchaser());
			poheader.setDuedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(poheaderhelper.getDuedate()));
			poheader.setNetvalue(new BigDecimal(poheaderhelper.getNetvalue()));
			poheader.setTaxvalue(new BigDecimal(poheaderhelper.getTaxvalue()));
			poheader.setGrossvalue(new BigDecimal(poheaderhelper.getGrossvalue()));
			poheader.setCurrency(poheaderhelper.getCurrency());
			poheader.setCreatedby(poheaderhelper.getCreatedby());
			poheader.setCreateddate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(poheaderhelper.getCreateddate()));
			poheader.setLastmodifiedby(poheaderhelper.getLastmodifiedby());
			poheader.setLastmodifieddate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(poheaderhelper.getLastmodifieddate()));
			
			for (PolineitemsHelper polineitemshelper : lineitems) {
				Polineitems polineitems = new Polineitems();
				
				polineitems.setAsnstatus(polineitemshelper.getAsnstatus());
			}
		
			
			poheadersList.add(poheader);
			polineitemsList.add(polineitems);
		}
		
		
		poheaderDao.saveAll(poheadersList);
		//poheaderDao.saveAll(polineitemsList);
		
		   		  	 			
			System.out.println(header.toString());
			
		return "sucessfull";
	}


	
	/*
	 * @PutMapping("/update/{id}") public Header updateheader(@PathVariable Long id,
	 * 
	 * @Valid @RequestBody Header headerDetails) throws NotFoundException { return
	 * dao.findById(id).map(header -> {
	 * header.setpONumber(headerDetails.getpONumber());
	 * header.setpOType(headerDetails.getpOType());
	 * header.setDescription(headerDetails.getDescription());
	 * header.setCreationDate(headerDetails.getCreationDate());
	 * header.setDueDate(headerDetails.getDueDate());
	 * header.setSlNo(headerDetails.getSlNo());
	 * header.setPurchaser(headerDetails.getPurchaser());
	 * header.setNetValue(headerDetails.getNetValue());
	 * header.setTax(headerDetails.getTax());
	 * 
	 * return dao.save(header); }).orElseThrow(() -> new
	 * NotFoundException("Header not found with id " + id)); }
	 */

	//@DeleteMapping("/delete/{id}")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String deleteHeader(@PathVariable Long id) throws NotFoundException {
		return poheaderDao.findById(id).map(header -> {
			poheaderDao.delete(header);
			return "Delete Successfully!";
		}).orElseThrow(() -> new NotFoundException("Header not found with id " + id));
	}

}

/*
 * @Autowired private POItemDao pOItemDao;
 * 
 * @PostMapping("/save") public String create(@RequestBody List<Header> header)
 * { dao.saveAll(header); System.out.println(header.toString()); return
 * "ticket booked : " + header.size(); }
 * 
 * @GetMapping("/getall") public List<Header> getTickets() { return
 * (List<Header>) dao.findAll(); }
 * 
 * @PutMapping("/header/{id}") public ResponseEntity<Header>
 * updateEmployee(@PathVariable(value = "id") Long headerId,
 * 
 * @Valid @RequestBody Header headerDetails) throws ResourceNotFoundException {
 * Header header = dao.findById(headerId) .orElseThrow(() -> new
 * ResourceNotFoundException("Employee not found for this id :: " + headerId));
 * 
 * header.setpONumber(headerDetails.getpONumber());
 * header.setLogicalSystem(headerDetails.getLogicalSystem());
 * header.setCurrency(headerDetails.getCurrency());
 * header.setIncoTerms(headerDetails.getIncoTerms());
 * header.setPaymentTerms(headerDetails.getPaymentTerms());
 * header.setpOCreatedBy(headerDetails.getpOCreatedBy());
 * header.setPoDate(headerDetails.getPoDate());
 * header.setVendorID(headerDetails.getVendorID());
 * header.setpOType(headerDetails.getpOType());
 * 
 * final Header updatedHeader = dao.save(header); return
 * ResponseEntity.ok(updatedHeader); }
 */


/*
 * //@GetMapping("/geth2")
 * 
 * @RequestMapping(value="/geth2",method=RequestMethod.GET)
 * 
 * @Transactional public List<Header2> getAllHeader2() { List<Header2> h2 =
 * (List<Header2>) h_dao.findAll(); return h2; }
 * 
 * 
 * @PostMapping("/header2") public String createHeader2(@Valid @RequestBody
 * List<Header2> header2) { // ((Header) header).setGrossValue(((Header)
 * header).getNetValue()+((Header) header).getTax());
 * System.out.println(header2.toString()); h_dao.saveAll(header2);
 * System.out.println(header2.toString());
 * 
 * return "sucessfull";
 * 
 * }
 */