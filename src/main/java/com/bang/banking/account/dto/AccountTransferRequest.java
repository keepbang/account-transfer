package com.bang.banking.account.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountTransferRequest {

  @NotEmpty(message = "sender_id is not null.")
  private String senderId;

  @NotEmpty(message = "sender_account_number is not null.")
  private String senderAccountNumber;

  @NotEmpty(message = "sender_account_password is not null.")
  private String senderAccountPassword;

  @NotEmpty(message = "receiver_id is not null.")
  private String receiverId;

  @NotNull(message = "transfer_amount is not null.")
  @Min(value = 0, message = "A value of transfer_amount field must be over than 0.")
  private Long transferAmount;

  public AccountTransferRequest(String senderId, String senderAccountNumber,
      String senderAccountPassword, String receiverId, Long transferAmount) {
    this.senderId = senderId;
    this.senderAccountNumber = senderAccountNumber;
    this.senderAccountPassword = senderAccountPassword;
    this.receiverId = receiverId;
    this.transferAmount = transferAmount;
  }
}
