package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.exception.RunTimeExeption;
import com.app.model.AccountDetails;
import com.app.repo.AccountRepo;
@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepo accountRepo;
	@Override
	public List<AccountDetails> findAllAccountDetails() {
		
		return accountRepo.findAll();
	}

	@Override
	public AccountDetails findAccountById(long accountNumber) {
		return accountRepo.findById(accountNumber).orElseThrow(()-> new RunTimeExeption("Account number not found"));				
	}

	@Override
	public AccountDetails saveAccount(AccountDetails account) {
		
		
		return accountRepo.save(account);
	}

	@Override
	public AccountDetails updateAccount(long accountNumber, AccountDetails account) {
		AccountDetails existAccount = accountRepo.findById(accountNumber).orElseThrow(()-> new RunTimeExeption("Account number not found"));
		existAccount.setAccountType(account.getAccountType());
		
		accountRepo.save(existAccount);
		return existAccount;
	}

	@Override
	public void deleteAccount(long accountNumber) {
		accountRepo.findById(accountNumber).orElseThrow(()-> new RunTimeExeption("Account number not found"));
		accountRepo.deleteById(accountNumber);
		
	}

}
