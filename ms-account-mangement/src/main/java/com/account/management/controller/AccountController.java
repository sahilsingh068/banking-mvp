package com.account.management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.management.model.Account;
import com.account.management.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

	private AccountService accountService;

	@PostMapping(value = "/addAccount")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		var newAccount = accountService.addAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
	}

	@GetMapping(value = "/account/{customerId}")
	public ResponseEntity<List<Account>> getAccountByCustomerId(@PathVariable String customerId) {
		var customer = accountService.getAccountByCustomerId(customerId);
		return ResponseEntity.ok(customer);
	}

	// add money to account
	@PutMapping(value = "/addMoney/{accountId}")
	public ResponseEntity<Account> addMoney(@PathVariable String accountId, @RequestParam Double amount,
			@RequestParam String customerId) {
		var newMoney = accountService.addMoneyToAccount(accountId, amount, customerId);
		return ResponseEntity.ok(newMoney);
	}

	// withdraw money to account
	@PutMapping(value = "/withdraw/{accountId}")
	public ResponseEntity<Account> withdrawMoney(@PathVariable String accountId, @RequestParam Double amount,
			@RequestParam String customerId) {
		var updatedMoney = accountService.withdrawMoney(accountId, amount, customerId);
		return ResponseEntity.ok(updatedMoney);
	}
	// Delete account 
	@DeleteMapping(value = "/account/{accountId}")
	public void deleteAccount(@PathVariable String accountId) {
		accountService.delete(accountId);
	}
	// Delete account using customer id
	@DeleteMapping(value = "/accountDelete/{customerId}")
	public void deleteAccountByCustomerId(@PathVariable String customerId) {
		accountService.deleteAccByCustomerId(customerId);
	}
	// getAccountDetails
	@GetMapping(value = "/accontDetails/{accountId}")
	public ResponseEntity<Account> getAccountDetails(@PathVariable String accountId) {
		var accountDetails = accountService.getAccountDetails(accountId);
		return ResponseEntity.ok(accountDetails);
	}

}
