package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.AccountDetails;

public interface AccountRepo extends JpaRepository<AccountDetails, Long>  {

}
