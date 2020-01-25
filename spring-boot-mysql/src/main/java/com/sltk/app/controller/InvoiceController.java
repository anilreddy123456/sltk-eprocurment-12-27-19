package com.sltk.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.validation.Valid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.app.dao.InvoiceDao;
import com.sltk.app.model.Invoices;

@RequestMapping(value="/invoice")
@RestController
public class InvoiceController {

	@Autowired
	private InvoiceDao invoiceDao;
	
	@RequestMapping(value="/invsave",method = RequestMethod.POST)
	public String createInvoice(@Valid @RequestBody List<Invoices> invoice) throws IOException {
		
		String postEndpoint = "http://eccehp7.4vm.com:8073/sap/bc/webser_invoice";
		 
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 
		 HttpPost httpPost = new HttpPost(postEndpoint);
		 
		 httpPost.setHeader("Accept", "application/json");
		 httpPost.setHeader("Content-type", "application/json");
		 
		 
		 String inputJson = " ";
		 
		 StringEntity stringEntity = new StringEntity(inputJson);
		 httpPost.setEntity(stringEntity);
		 
		 System.out.println("Executing request " + httpPost.getRequestLine());
		 
		 HttpResponse response = httpclient.execute(httpPost);
		 
		 BufferedReader br = new BufferedReader(
		 new InputStreamReader((response.getEntity().getContent())));
		 
		 
		 //Throw runtime exception if status code isn't 200
		 if (response.getStatusLine().getStatusCode() != 200) {
		 throw new RuntimeException("Failed : HTTP error code : "+ response.getStatusLine().getStatusCode());
		 }		 
		 
		 //Create the StringBuffer object and store the response into it.
		 StringBuffer result = new StringBuffer();
		 String line = "";
		 while ((line = br.readLine()) != null) {
		 System.out.println("Response : \n"+result.append(line));
		 }
		 
		return "";
	}
	
}
