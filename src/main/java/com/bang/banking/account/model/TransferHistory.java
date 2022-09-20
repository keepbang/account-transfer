package com.bang.banking.account.model;

import com.bang.banking.account.dto.AccountTransferRequest;
import com.bang.banking.account.model.type.TransferStatus;
import com.bang.banking.account.model.type.TransferType;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transfer_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TransferHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "withdraw_account", length = 20, nullable = false)
  private String withdrawAccountNumber;

  @Column(name = "deposit_account", length = 20)
  private String depositAccountNumber;

  @Column(name = "sender_id", length = 32, nullable = false)
  private String senderId;

  @Column(name = "receiver_id", length = 32, nullable = false)
  private String receiverId;

  @Column(name = "transfer_amount", length = 32, nullable = false)
  private Long transferAmount;

  @Column(name = "transfer_status", length = 32, nullable = false)
  private TransferStatus transferStatus = TransferStatus.REQUEST;

  @Column(name = "transfer_type", length = 32, nullable = false)
  @Enumerated(EnumType.STRING)
  private TransferType transferType;

  @Column(name = "send_at", nullable = false)
  private LocalDateTime sendAt = LocalDateTime.now();

  @Column(name = "receive_at")
  private LocalDateTime receiveAt;

  public TransferHistory(String withdrawAccountNumber, String senderId, String receiverId,
      Long transferAmount, TransferType transferType) {
    this.withdrawAccountNumber = withdrawAccountNumber;
    this.senderId = senderId;
    this.receiverId = receiverId;
    this.transferAmount = transferAmount;
    this.transferType = transferType;
  }

  public static TransferHistory ofFriendTransfer(AccountTransferRequest request) {
    return new TransferHistory(
        request.getSenderAccountNumber(),
        request.getSenderId(),
        request.getReceiverId(),
        request.getTransferAmount(),
        TransferType.FRIEND
    );
  }
}
