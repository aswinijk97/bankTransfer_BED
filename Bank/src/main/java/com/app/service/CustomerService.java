package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.AccountDetails;
import com.app.model.Customer;

@Service
public interface CustomerService {
	//findAll
	List<Customer>  findAllCustomers();
	//findByCustId
	Customer findByCustId(long custId);
	//Create
	Customer createNewCustomer(Customer customer);
	//updateByCustId
	Customer updateCustomerByCUstId(long custId,Customer customer);
	AccountDetails transferAmnt(long fromCustId, long toCustId, int sendAmount);
	//deletByCustId
	void deleteByCustId(long custId);
}
