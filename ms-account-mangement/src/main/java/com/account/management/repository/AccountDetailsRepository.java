package com.account.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.management.model.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, String> {

}
