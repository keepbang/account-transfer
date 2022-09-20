package com.bang.banking.account.dao;

import com.bang.banking.account.model.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferHistoryRepository extends JpaRepository<TransferHistory, Long> {

}
