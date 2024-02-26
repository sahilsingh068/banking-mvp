package com.account.management.service;

import java.util.List;

import com.account.management.model.Account;

public interface AccountService {
	Account addAccount(Account account);

	Account getAccountDetails(String accountId);

	List<Account> getAccountByCustomerId(String customerId);

	Account addMoneyToAccount(String accId, Double amount, String customerId);

	Account withdrawMoney(String accId, Double amount, String customerId);

	void delete(String accId);

	void deleteAccByCustomerId(String customerId);
	
	List<Account> fetchAllAccount();

}
