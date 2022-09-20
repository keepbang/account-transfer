package com.bang.banking.account.dao;

import com.bang.banking.account.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts, String> {

}
