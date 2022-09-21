package com.bang.banking.account.model;

import com.bang.banking.user.model.Users;
import com.bang.banking.util.PasswordUtils;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Accounts {

  @Id
  @Column(name = "account_number", length = 20)
  private String accountNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private Users users;

  @Column(name = "account_name", length = 30, nullable = false)
  private String accountName;

  @Column(name = "is_representative", nullable = false)
  private boolean representative;

  @Column(name = "account_password", length = 100, nullable = false)
  private String accountPassword;

  @Column(name = "balance", nullable = false)
  private BigDecimal balance;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "modified_at")
  private LocalDateTime modifiedAt;

  public Accounts(String accountNumber, Users users, String accountName, boolean representative,
      String accountPassword, BigDecimal balance) {
    this.accountNumber = accountNumber;
    this.users = users;
    this.accountName = accountName;
    this.representative = representative;
    this.accountPassword = PasswordUtils.encode(accountPassword);
    this.balance = balance;
  }

  private void checkPassword(String inputPassword) {
    if (inputPassword == null ||
        !PasswordUtils.matches(inputPassword, this.accountPassword)) {
      throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
    }
  }

  private void isNotValidAmount(BigDecimal amount) {
    if (this.balance.compareTo(amount) < 0) {
      throw new IllegalArgumentException("금액이 잔액을 초과했습니다.");
    }

    if (amount.compareTo(BigDecimal.ONE) < 0) {
      throw new IllegalArgumentException("금액이 1보다 작습니다.");
    }
  }

  public void withdraw(BigDecimal amount, String inputPassword) {
    checkPassword(inputPassword);
    isNotValidAmount(amount);

    this.balance = this.balance.subtract(amount);
  }
}
