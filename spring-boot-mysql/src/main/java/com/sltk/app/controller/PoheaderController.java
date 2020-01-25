package com.sltk.app.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.app.dao.PoheaderDao;
import com.sltk.app.entity.sap.GrnDetailSapEntity;
import com.sltk.app.entity.sap.GrnSapEntity;
import com.sltk.app.entity.sap.PoheaderSapEntity;
import com.sltk.app.entity.sap.PolineTaxSapEntity;
import com.sltk.app.entity.sap.PolineitemsSapEntity;
import com.sltk.app.model.Grn;
import com.sltk.app.model.Grndetails;
import com.sltk.app.model.Poheader;
import com.sltk.app.model.PolineItemTaxes;
import com.sltk.app.model.Polineitems;

import javassist.NotFoundException;

@RestController
@RequestMapping("/header")
public class PoheaderController {

	// private static final Logger
	// logger=LoggerFactory.getLogger(PoheaderController.class);
	@Autowired
	private PoheaderDao poheaderDao;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@Transactional
	public List<Poheader> getAllHeader() {

		// logger.debug("debugging mode getall() method");
		List<Poheader> h = (List<Poheader>) poheaderDao.findAll();
		return h;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@Transactional
	public Poheader getHeaderByID(@PathVariable("id") Long id) throws NotFoundException {
		Optional<Poheader> optHeader = poheaderDao.findById(id);
		if (optHeader.isPresent()) {
			return optHeader.get();
		} else {
			throw new NotFoundException("Header not found with id " + id);
		}
	}

	@RequestMapping(value = "/save/update", method = RequestMethod.POST)
	@Transactional
	public String createHeader(@Valid @RequestBody List<PoheaderSapEntity> header) throws ParseException {

		System.out.println(header.toString());
		
		List<Poheader> headerlist=new ArrayList<Poheader>();
		List<Polineitems> polineitemslist= new ArrayList<Polineitems>();
		List<PolineItemTaxes> polineItemTaxeslist= new ArrayList<PolineItemTaxes>();
		
		for (PoheaderSapEntity poheaderSapEntity : header) {
			Poheader poheader = new Poheader();
			poheader.setPonumber(poheaderSapEntity.getPonumber());
			poheader.setVendorSapCode(poheaderSapEntity.getVendorsapcode());
			poheader.setDescription(poheaderSapEntity.getVendorsapcode());
			poheader.setPotype(poheaderSapEntity.getPotype());
			poheader.setPurchaser(poheaderSapEntity.getPurchaser());
			poheader.setOtherCharges(new BigDecimal(100.00));
			poheader.setNetValue(new BigDecimal(poheaderSapEntity.getNetvalue()));
			poheader.setTaxValue(new BigDecimal(poheaderSapEntity.getTaxvalue()));
			poheader.setGrossValue(new BigDecimal(poheaderSapEntity.getGrossvalue()));
			poheader.setCurrency(poheaderSapEntity.getCurrency());
			poheader.setCreatedDate(poheaderSapEntity.getCreateddate());
			poheader.setLastModifiedBy(poheaderSapEntity.getLastmodifiedby());
			poheader.setLastModifiedDate(poheaderSapEntity.getLastmodifieddate());			
			
			List<PolineitemsSapEntity> polineitemsSapEntities = poheaderSapEntity.getPolineitemslist();
			
			for (PolineitemsSapEntity polineitemsSapEntity : polineitemsSapEntities) {
				Polineitems polineitems = new Polineitems();
				
				Integer orderOqantity=Integer.parseInt(polineitemsSapEntity.getOrderquantity());
				
				polineitems.setPonumber(poheader);
				polineitems.setAsnStatus(polineitemsSapEntity.getAsnstatus());
				polineitems.setPoLineId(Integer.parseInt(polineitemsSapEntity.getPolineid()));
				polineitems.setItemType(polineitemsSapEntity.getItemtype());
				polineitems.setMaterialNumber(polineitemsSapEntity.getMaterialnumber());
				polineitems.setDescription(polineitemsSapEntity.getDescription());
				polineitems.setPlant(polineitemsSapEntity.getPlant());
				polineitems.setMaterialCatagory(polineitemsSapEntity.getMaterialcatagory());
				polineitems.setOrderQuantity(Integer.parseInt(polineitemsSapEntity.getOrderquantity()));
				polineitems.setUom(polineitemsSapEntity.getUom());
				polineitems.setSapTaxCode(polineitemsSapEntity.getTaxcode());
				polineitems.setBalanceAsnQty(new BigDecimal(orderOqantity));
				polineitems.setGrossValue(new BigDecimal(orderOqantity).multiply(new BigDecimal(polineitemsSapEntity.getNetvalue())));
				polineitems.setNetValue(new BigDecimal(polineitemsSapEntity.getNetvalue()));	
				polineitems.setPreviousAsnQty(new BigDecimal(0));			
				
				List<PolineTaxSapEntity> polineTaxSapEntities = polineitemsSapEntity.getPotax();
				
				for (PolineTaxSapEntity polineitemsTaxSapEntity : polineTaxSapEntities) {
					PolineItemTaxes polineItemTaxes = new PolineItemTaxes();
					
					polineItemTaxes.setLine_id(polineitems);
					polineItemTaxes.setTaxDescription(polineitemsTaxSapEntity.getTax_description());
					if(polineitemsTaxSapEntity.getTax_rate()==null||polineitemsTaxSapEntity.getTax_rate()==" ") {
						polineItemTaxes.setTaxRate(new BigDecimal(0.00));
					}else {
					polineItemTaxes.setTaxRate(new BigDecimal(polineitemsTaxSapEntity.getTax_rate()));
					}
					polineItemTaxeslist.add(polineItemTaxes);
				}
				polineitems.setPolineItemTaxes(polineItemTaxeslist);
				polineitemslist.add(polineitems);
			}
		
			poheader.setPolineitemsList(polineitemslist);
			headerlist.add(poheader);
		}
		poheaderDao.saveAll(headerlist);	
        
        System.out.println(header.toString());
		
        return "header created";
		/**
		List<PolineItemTaxes> polineItemTaxList=new ArrayList<PolineItemTaxes>();
		List<Poheader> headerlist=new ArrayList<Poheader>();
		List<Polineitems> polineitemslist= new ArrayList<Polineitems>();
		
		for (PoheaderSapEntity poheaderSapEntity : header) {
			Poheader header1= new  Poheader();
			
			header1.setPonumber(poheaderSapEntity.getPonumber());
			header1.setVendorSapCode(poheaderSapEntity.getVendorsapcode());
			header1.setDescription(poheaderSapEntity.getDescription());
			header1.setPotype(poheaderSapEntity.getPotype());
			header1.setPurchaser(poheaderSapEntity.getPurchaser());
			header1.setOtherCharges(new BigDecimal(poheaderSapEntity.getOthercharges()));
			header1.setNetValue(new BigDecimal(poheaderSapEntity.getNetvalue()));
			header1.setTaxValue(new BigDecimal(poheaderSapEntity.getTaxvalue()));
			header1.setGrossValue(new BigDecimal(poheaderSapEntity.getGrossvalue()));
			header1.setCurrency(poheaderSapEntity.getCurrency());
			//header1.setCreatedDate(new SimpleDateFormat().parse(poheaderSapEntity.getCreateddate()));
			header1.setCreatedDate(poheaderSapEntity.getCreateddate());
			header1.setLastModifiedBy(poheaderSapEntity.getLastmodifiedby());
			//header1.setLastModifiedDate(new SimpleDateFormat().parse(poheaderSapEntity.getLastmodifieddate()));
			header1.setLastModifiedDate(poheaderSapEntity.getLastmodifieddate());
			//header1.setCompId("1");
			
			List<PolineitemsSapEntity> lineitem =poheaderSapEntity.getPolineitemslist();
		
			for (PolineitemsSapEntity poitementity : lineitem) {
				Polineitems lineitems1= new Polineitems();
				
				Integer orderQty=Integer.parseInt(poitementity.getOrderquantity());
				
				//lineitems1.setLineId(Integer.parseInt(poitementity.getLineid()));
				lineitems1.setAsnStatus(poitementity.getAsnstatus());
				lineitems1.setPoLineId(Integer.parseInt(poitementity.getPolineid()));
				lineitems1.setItemType(poitementity.getItemtype());
				lineitems1.setMaterialNumber(poitementity.getMaterialnumber());
				lineitems1.setDescription(poitementity.getDescription());
				lineitems1.setPlant(poitementity.getPlant());
				lineitems1.setMaterialCatagory(poitementity.getMaterialcatagory());
				lineitems1.setOrderQuantity(Integer.parseInt(poitementity.getOrderquantity()));
				lineitems1.setUom(poitementity.getUom());
				lineitems1.setBalanceAsnQty(new BigDecimal(orderQty));
				lineitems1.setPreviousAsnQty(new BigDecimal(0));
				lineitems1.setGrossValue(lineitems1.getNetValue().multiply(new BigDecimal(orderQty)));
				lineitems1.setSapTaxCode(poitementity.getTaxcode());
				lineitems1.setPonumber(new Poheader(poitementity.getPonumber()));
				
				List<PolineTaxSapEntity> polinesaptax=poitementity.getPotax();
				for (PolineTaxSapEntity polineitemssaptax : polinesaptax) {
					
					PolineItemTaxes itemTaxes= new PolineItemTaxes();
					itemTaxes.setTaxDetailId(Integer.parseInt(polineitemssaptax.getTaxdetailid()));
					itemTaxes.setLine_id(new Polineitems(polineitemssaptax.getLine_id()));
					itemTaxes.setTaxDescription(polineitemssaptax.getTax_description());
					itemTaxes.setTaxRate(new BigDecimal(polineitemssaptax.getTax_rate()));
					
					
					polineItemTaxList.add(itemTaxes);
				}				
					
				lineitems1.setPolineItemTaxes(polineItemTaxList);
				polineitemslist.add(lineitems1);
			}			
			header1.setPolineitemsList(polineitemslist);
			headerlist.add(header1);			
		}
		poheaderDao.saveAll(headerlist);	
           
           System.out.println(header.toString());
		**/
		
		
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Object> update(@PathVariable("id") Long id, @Valid @RequestBody Poheader header) {

		Optional<Poheader> headerObject = poheaderDao.findById(id);

		if (!headerObject.isPresent())
			return ResponseEntity.notFound().build();

		poheaderDao.save(header);

		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@Transactional
	public ResponseEntity<Object> deleteHeader(@PathVariable("id") Long id) throws NotFoundException {
		System.out.println("delete this " + id + " from header");
		Optional<Poheader> obj = poheaderDao.findById(id);
		if (!obj.isPresent())
			return ResponseEntity.notFound().build();
		poheaderDao.deleteById(id);
		return ResponseEntity.ok().build();

	}
}
