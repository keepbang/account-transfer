package com.bang.banking.account.application;

import com.bang.banking.account.dto.AccountTransferRequest;

public interface AccountService {

  void accountTransfer(AccountTransferRequest request);
}
