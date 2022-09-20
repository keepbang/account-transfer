package com.bang.banking.account.event;

import com.bang.banking.account.model.TransferHistory;
import lombok.Getter;

@Getter
public class TransferEventDto {

  private long transferId;

  private String receiverId;

  private TransferEventDto() {
  }

  public TransferEventDto(TransferHistory transferHistory) {
    this.transferId = transferHistory.getId();
    this.receiverId = transferHistory.getReceiverId();
  }
}
