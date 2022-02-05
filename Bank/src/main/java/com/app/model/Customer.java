package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="customer")
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="fk_accountNumber")
	private AccountDetails account ;

	
//	public List<AccountDetails> addAccount(AccountDetails accnt) {
//		account.add(accnt);
//		return account;
//	}
//	public void removeAccount(AccountDetails accnt) {
//		account.remove(accnt);
//	}
	
}
