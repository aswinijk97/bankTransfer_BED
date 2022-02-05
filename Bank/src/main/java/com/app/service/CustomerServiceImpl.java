package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.AccountDetails;
import com.app.model.Customer;
import com.app.repo.AccountRepo;
import com.app.repo.CustomerRepo;
@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	AccountRepo acntRepo;

	@Override
	public List<Customer> findAllCustomers() {
		
		return customerRepo.findAll();
	}

	@Override
	public Customer findByCustId(long custId) {
		
		return customerRepo.findById(custId).orElseThrow(()->new RuntimeException("Customer with given id "+custId+" not found"));
	}

	@Override
	public Customer createNewCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomerByCUstId(long custId, Customer customer) {
		Customer existCust = customerRepo.findById(custId).orElseThrow(()->new RuntimeException("Customer with given id "+custId+" not found"));
		existCust.setAddress(customer.getAddress());
		existCust.setName(customer.getName());
		customerRepo.save(existCust);
		return existCust;
		
	}

	@Override
	public void deleteByCustId(long custId) {
		if(custId!=0) {
		customerRepo.findById(custId).orElseThrow(()->new RuntimeException("Customer with given id "+custId+" not found")  );
		customerRepo.deleteById(custId);
		}
	}

	@Override
	public AccountDetails transferAmnt(long fromAcntId, long toAcntId,int sendAmnt) {
		AccountDetails fromAcnt = acntRepo.findById(fromAcntId).orElseThrow(()->new RuntimeException("Account not found"));
		AccountDetails toAcnt = acntRepo.findById(toAcntId).orElseThrow(()->new RuntimeException("Account not found"));
		
		int balance = fromAcnt.getBalance();
		if(balance>10) {
		
			fromAcnt.setBalance(fromAcnt.getBalance()-sendAmnt);
			acntRepo.save(fromAcnt);
			
			toAcnt.setBalance(toAcnt.getBalance()+sendAmnt);
			acntRepo.save(toAcnt);
		}
		return fromAcnt;
	}
	
}
