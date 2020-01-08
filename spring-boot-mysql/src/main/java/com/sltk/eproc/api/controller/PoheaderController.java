package com.sltk.eproc.api.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.eproc.api.dao.HeaderDao;
import com.sltk.eproc.api.dao.PoheaderDao;
import com.sltk.eproc.api.dao.PolineitemsDao;


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

	@Autowired
	private PolineitemsDao polineitemsDao;
	
	@Autowired
	private HeaderDao headerdao;
	

	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	@Transactional
	public List<Poheader> getAllHeader() {
		
		//logger.debug("debugging mode getall() method");
		List<Poheader> h = (List<Poheader>) poheaderDao.findAll();
		return h;
	}

	
	
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Poheader getHeaderByID(@PathVariable Long id) throws NotFoundException {
		Optional<Poheader> optHeader = poheaderDao.findById(id);
		if (optHeader.isPresent()) {
			return optHeader.get();
		} else {
			throw new NotFoundException("Header not found with id " + id);
		}
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String createHeader(@Valid @RequestBody List<Poheader> header) throws ParseException  {
				
		System.out.println(header.toString());
		for (Poheader poheader : header) {
			List<Polineitems> items=poheader.getPolineitemslist();
			
			for (Polineitems polineitems : items) {
				Integer orderQty= polineitems.getOrderquantity();
				polineitems.setBalanceasnqty(new BigDecimal(orderQty));
				polineitems.setPreviousasnqty(new BigDecimal(0));
				polineitems.setGrossvalue(polineitems.getNetvalue().multiply(new BigDecimal(orderQty)));
						
			}
		}				
		poheaderDao.saveAll(header);	 			
			System.out.println(header.toString());
			
		return "sucessfull";
	}


	
	
	@PutMapping("/update/{id}")
	public String updateheader(@RequestBody Long id, @Valid @RequestBody Poheader headerDetails) throws NotFoundException {
		
		 List<Polineitems> itemsupdate = new ArrayList<Polineitems>();
		  
		return poheaderDao.findById(id).map(header -> {
			
			  header.setVendorsapcode(headerDetails.getVendorsapcode());
			  header.setDescription(headerDetails.getDescription());
			  header.setPotype(headerDetails.getPotype());
			  header.setPurchaser(headerDetails.getPurchaser());
			  header.setDuedate(headerDetails.getDuedate());
			  header.setNetvalue(headerDetails.getNetvalue());
			  header.setTaxvalue(headerDetails.getTaxvalue());
			  header.setGrossvalue(headerDetails.getGrossvalue());
			  header.setCurrency(headerDetails.getCurrency());
			  header.setCreatedby(headerDetails.getCreatedby());
			  header.setCreateddate(headerDetails.getCreateddate());
			  header.setLastmodifiedby(headerDetails.getLastmodifiedby());
			  header.setLastmodifieddate(headerDetails.getLastmodifieddate());
			  
			  List<Polineitems> items= header.getPolineitemslist();
			  
			  for (Polineitems poitem : items) {
				  Polineitems polineitems= new Polineitems();
				  //poitem.setAsnstatus(poitem.getAsnstatus());
				  polineitems.setAsnstatus(poitem.getAsnstatus());
				  polineitems.setPolineid(poitem.getPolineid());
				  polineitems.setItemtype(poitem.getItemtype());
				  polineitems.setMaterialnumber(poitem.getMaterialnumber());
				  polineitems.setDescription(poitem.getDescription());
				  polineitems.setPlant(poitem.getPlant());
				  polineitems.setMaterialcatagory(poitem.getMaterialcatagory());
				  polineitems.setOrderquantity(poitem.getOrderquantity());
				  polineitems.setUom(poitem.getUom());
				  polineitems.setGrossvalue(poitem.getGrossvalue());
				  polineitems.setNetvalue(poitem.getNetvalue());
				  polineitems.setBalanceasnqty(poitem.getBalanceasnqty());
				  polineitems.setPreviousasnqty(poitem.getPreviousasnqty()); 
			 // itemsupdate.add(items);
			  }
			  
			poheaderDao.flush();
			return "updated";
			//return headerdao.save(header);
		}).orElseThrow(() -> new NotFoundException("Header not found with id " + id));
	}
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

/*
 * Poheader poheader = new Poheader(); List<Poheader> poheadersList = new
 * ArrayList<Poheader>();
 * 
 * List<Polineitems> polineitemsList = new ArrayList<Polineitems>();
 * List<PolineitemsHelper> lineitems= new ArrayList<PolineitemsHelper>();
 * 
 * for (PolineitemsHelper polineitemshelper : lineitems) { Polineitems
 * polineitems = new Polineitems();
 * 
 * polineitems.setAsnstatus(polineitemshelper.getAsnstatus());
 * polineitems.setPolineid(Integer.parseInt(polineitemshelper.getPolineid()));
 * polineitems.setItemtype(polineitemshelper.getItemtype());
 * polineitems.setMaterialnumber(polineitemshelper.getMaterialnumber());
 * polineitems.setDescription(polineitemshelper.getDescription());
 * polineitems.setPlant(polineitemshelper.getPlant());
 * polineitems.setMaterialcatagory(polineitemshelper.getMaterialcatagory());
 * polineitems.setOrderquantity(Integer.parseInt(polineitemshelper.
 * getOrderquantity())); polineitems.setUom(polineitemshelper.getUom());
 * polineitems.setGrossvalue(new BigDecimal(polineitemshelper.getGrossvalue()));
 * polineitems.setNetvalue(new BigDecimal(polineitemshelper.getNetvalue()));
 * polineitems.setBalanceasnqty(new
 * BigDecimal(polineitemshelper.getBalanceasnqty()));
 * polineitems.setPreviousasnqty(new
 * BigDecimal(polineitemshelper.getPreviousasnqty()));
 * 
 * // polineitems.setPonumber(polineitemshelper.getPonumber());
 * polineitemsList.add(polineitems); }
 * 
 * for (PoheaderHelper poheaderhelper : header) {
 * 
 * poheader.setPonumber(Long.parseLong(poheaderhelper.getPonumber()));
 * poheader.setVendorsapcode(poheaderhelper.getVendorsapcode());
 * poheader.setDescription(poheaderhelper.getDescription());
 * poheader.setPotype(poheaderhelper.getPotype());
 * poheader.setPurchaser(poheaderhelper.getPurchaser());
 * poheader.setDuedate(poheaderhelper.getDuedate()); poheader.setNetvalue(new
 * BigDecimal(poheaderhelper.getNetvalue())); poheader.setTaxvalue(new
 * BigDecimal(poheaderhelper.getTaxvalue())); poheader.setGrossvalue(new
 * BigDecimal(poheaderhelper.getGrossvalue()));
 * poheader.setCurrency(poheaderhelper.getCurrency());
 * poheader.setCreatedby(poheaderhelper.getCreatedby());
 * poheader.setCreateddate(poheaderhelper.getCreateddate());
 * poheader.setLastmodifiedby(poheaderhelper.getLastmodifiedby());
 * poheader.setLastmodifieddate(poheaderhelper.getLastmodifieddate());
 * 
 * poheader.setPolineitemslist(polineitemsList);
 * 
 * poheadersList.add(poheader);
 * 
 * }
 */