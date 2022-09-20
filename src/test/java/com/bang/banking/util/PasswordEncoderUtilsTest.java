package com.bang.banking.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PasswordEncoderUtilsTest {

  @Test
  void passwordEncoderTest() {
    // given
    String password = "1234";
    // when
    String encodePassword = PasswordUtils.encode(password);
    // then
    System.out.println(encodePassword);
  }
}