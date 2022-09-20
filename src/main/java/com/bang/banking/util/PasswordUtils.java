package com.bang.banking.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public final class PasswordUtils {

  private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  private PasswordUtils() {
  }

  public static String encode(String password) {
    return passwordEncoder.encode(password);
  }

  public static boolean matches(String rawPassword, String encodedPassword) {
    return passwordEncoder.matches(rawPassword, encodedPassword);
  }
}
