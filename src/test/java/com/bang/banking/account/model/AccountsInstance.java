package com.bang.banking.account.model;

import com.bang.banking.user.model.Users;
import java.math.BigDecimal;

public class AccountsInstance {

  public static Accounts getInstance() {
    Users users = new Users(
        "userId",
        "name",
        "password",
        "email",
        "010-1111-2222",
        "nickName"
    );
    return new Accounts("1111",
        users,
        "계좌 이름",
        true,
        "1234",
        BigDecimal.valueOf(10_000)
    );
  }
}
