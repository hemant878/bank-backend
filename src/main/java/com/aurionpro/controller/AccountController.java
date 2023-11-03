package com.aurionpro.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Account;
import com.aurionpro.service.IAccountService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {

	private IAccountService accountservice;

	public AccountController(IAccountService accountservice) {
		super();
		this.accountservice = accountservice;
	}

	@GetMapping("/accounts")
	public List<Account> getAccounts(){
		return accountservice.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public Account getAccountsById(@PathVariable int id){
		return accountservice.findById(id);
	}
	
	@PostMapping("/accounts")
	public Account addAccounts(@RequestBody Account account){
		return accountservice.save(account);
	}
	
	@PutMapping("/accounts/{id}")
	public Account updateAccounts(@RequestBody Account account) {
		return accountservice.updateAccount(account);
	}
	
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable int id) {
		accountservice.deleteAccount(id); 
	}
	
	
	
	
}
