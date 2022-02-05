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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="account")
@Data
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;
	@Column(name="type")
	private String accountType;
	@Column(name="ifsc")
	private String ifsc;
	@Column(name="status")
	private String status;
	@Column(name="balance")
	private int balance;
	
	@OneToOne(mappedBy = "account")
	@JsonIgnore
	private Customer customer;
	
	
}
