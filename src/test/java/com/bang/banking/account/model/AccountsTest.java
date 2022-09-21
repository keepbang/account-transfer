package com.bang.banking.account.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class AccountsTest {

  private final String inputPassword = "1234";

  @Test
  @DisplayName("패스워드 매칭 성공")
  void checkPasswordSuccess() {
    // given
    // when
    Accounts accounts = AccountsInstance.getInstance();
    accounts.withdraw(BigDecimal.valueOf(1_000), inputPassword);
    // then
    assertThat(accounts.getBalance()).isEqualTo(BigDecimal.valueOf(9_000));
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {
      "", "12 34"
  })
  @DisplayName("패스워드 매칭 실패")
  void checkPasswordThrowException(String inputPassword) {
    // given
    // when
    Accounts accounts = AccountsInstance.getInstance();
    // then
    assertThatThrownBy(() -> accounts.withdraw(BigDecimal.valueOf(1_000), inputPassword))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("패스워드가 일치하지 않습니다.");
  }

  @ParameterizedTest
  @CsvSource({
      "1,9999",
      "9999,1"
  })
  @DisplayName("잔액 검증 성공")
  void checkBalanceSuccess(BigDecimal amount, BigDecimal balance) {
    // given
    // when
    Accounts accounts = AccountsInstance.getInstance();
    accounts.withdraw(amount, inputPassword);
    // then
    assertThat(accounts.getBalance()).isEqualTo(balance);
  }

  @ParameterizedTest
  @CsvSource({
      "0, 금액이 1보다 작습니다.",
      "10001, 금액이 잔액을 초과했습니다."
  })
  @DisplayName("잔액 검증 실패")
  void checkBalanceThrowException(BigDecimal amount, String message) {
    // given
    // when
    Accounts accounts = AccountsInstance.getInstance();
    // then
    assertThatThrownBy(() -> accounts.withdraw(amount, inputPassword))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(message);
  }

}