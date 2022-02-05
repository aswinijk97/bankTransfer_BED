package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.AccountDetails;
import com.app.model.Customer;
import com.app.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService custService;
	
	@PostMapping("/customers/create")
	public ResponseEntity<Customer> createNew(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(custService.createNewCustomer(customer), HttpStatus.CREATED);
	}
	@GetMapping("/customers/getAll")
	public List<Customer> getAll(){
	
		return custService.findAllCustomers();
	}
	@GetMapping("/customers/get/{custId}")
	public Customer getById(@PathVariable long custId){
	
		return custService.findByCustId(custId);
	}
	@PutMapping("/customers/update/{custId}")
	public ResponseEntity<Customer> updateCust(@PathVariable long custId,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(custService.updateCustomerByCUstId(custId, customer), HttpStatus.OK);
	}
	@DeleteMapping("/customers/delete/{custId}")
	public void deleteCustomer(@PathVariable long custId) {
		custService.deleteByCustId(custId);
	}
	@PutMapping("/customers/from/{fromAcntId}/to/{toAcntId}/amount/{send}")
	
//	@PutMapping("/customers/{}")
	
	public ResponseEntity<AccountDetails> transferAmount(@PathVariable long fromAcntId, @PathVariable long toAcntId,@PathVariable int send){
		return new ResponseEntity<AccountDetails>(custService.transferAmnt(fromAcntId, toAcntId, send), HttpStatus.OK);
		
	}
	
}
