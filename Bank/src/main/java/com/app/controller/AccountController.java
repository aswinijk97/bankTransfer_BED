package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.AccountDetails;
import com.app.service.AccountService;

@RestController
public class AccountController {
@Autowired
AccountService service;

@PostMapping("/accounts/create")
public ResponseEntity<AccountDetails> createNew(@RequestBody AccountDetails account){
	return new ResponseEntity<AccountDetails>(service.saveAccount(account),HttpStatus.CREATED);
}

@GetMapping("/accounts/get")
public List<AccountDetails> getAll(){
	return service.findAllAccountDetails();
}

@GetMapping("/accounts/get/{accountNumber}")
public AccountDetails getById(@PathVariable long accountNumber){
	return service.findAccountById(accountNumber);
}
@PutMapping("/accounts/update/{accountNumber}")
public ResponseEntity<AccountDetails> updateDetails(@PathVariable long accountNumber,AccountDetails account){
	return new ResponseEntity<AccountDetails>(service.updateAccount(accountNumber, account),HttpStatus.OK);
}

}
