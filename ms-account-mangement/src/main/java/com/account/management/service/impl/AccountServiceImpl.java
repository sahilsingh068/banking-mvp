package com.account.management.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.account.management.exception.ResourceNotFoundException;
import com.account.management.external.services.CustomerAPIFeignClient;
import com.account.management.model.Account;
import com.account.management.repository.AccountRepository;
import com.account.management.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	private CustomerAPIFeignClient customerApiFeignClient;
	
	@Override
	public Account addAccount(Account account) {
		String accountId = UUID.randomUUID().toString();
		account.setAccountId(accountId);
		return accountRepository.save(account);
	}

	@Override
	public Account getAccountDetails(String accountNo) {
		Account account = accountRepository.findById(accountNo).get();
		var customer = customerApiFeignClient.getSingleCustomer(account.getCustomerId());
		
		return account;
		
	}

	@Override
	public List<Account> getAccountByCustomerId(String customerId) {
		return accountRepository.findByCustomerId(customerId);
	}

	@Override
	public Account addMoneyToAccount(String accId, Double amount, String customerId) {
		Account account = accountRepository.findById(accId).get();
		var customer = customerApiFeignClient.getSingleCustomer(customerId);
		if (customer == null) {
			throw new ResourceNotFoundException("Customer not found");
		} else {
			Double newAmount = account.getAmount() + amount;
			account.setAmount(newAmount);
			return accountRepository.save(account);
		}
	}

	@Override
	public Account withdrawMoney(String accId, Double amount, String customerId) {
		Account account = accountRepository.findById(accId).get();
		var customer = customerApiFeignClient.getSingleCustomer(customerId);
		if (customer == null) {
			throw new ResourceNotFoundException("Customer not found");
		} else {
			Double newAmount = account.getAmount() - amount;
			account.setAmount(newAmount);
			return accountRepository.save(account);
		}
	}

	@Override
	public void delete(String accId) {
		Account account = accountRepository.findById(accId).get();
		accountRepository.delete(account);
		
	}

	@Override
	public void deleteAccByCustomerId(String customerId) {
		List<Account> account  = accountRepository.findByCustomerId(customerId);
		for(Account accounts: account) {
			accountRepository.delete(accounts);
		}
	}

	@Override
	public List<Account> fetchAllAccount() {
		return accountRepository.findAll();
	}

}
