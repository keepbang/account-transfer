package com.bang.banking.account.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.bang.banking.account.application.AccountService;
import com.bang.banking.account.dto.AccountTransferRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountApi {

  private final AccountService accountService;

  @PostMapping(value = "/transfer", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> accountTransfer(
      @RequestBody @Valid AccountTransferRequest request
  ) {
    accountService.accountTransfer(request);

    return new ResponseEntity<>(HttpStatus.OK);
  }

}
