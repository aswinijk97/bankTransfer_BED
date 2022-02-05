package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.AccountDetails;
@Service
public interface AccountService {

	List<AccountDetails> findAllAccountDetails();
	AccountDetails findAccountById(long accountNumber);
	AccountDetails saveAccount(AccountDetails account);
	AccountDetails updateAccount(long accountNumber,AccountDetails account);
	void deleteAccount(long accountNumber);
}
