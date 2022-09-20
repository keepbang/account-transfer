package com.bang.banking.user.model;

import com.bang.banking.util.PasswordUtils;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Users {

  @Id
  @Column(name = "user_id", length = 32)
  private String userId;

  @Column(name = "name", length = 30, nullable = false)
  private String name;

  @Column(name = "password", length = 100, nullable = false)
  private String password;

  @Column(name = "email", length = 100, nullable = false, unique = true)
  private String email;

  @Column(name = "phone_number", length = 13, nullable = false, unique = true)
  private String phoneNumber;

  @Column(name = "nick_name", length = 30, nullable = false)
  private String nickName;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "modified_at")
  private LocalDateTime modifiedAt;

  public Users(String userId, String name, String password, String email, String phoneNumber,
      String nickName) {
    this.userId = userId;
    this.name = name;
    this.password = PasswordUtils.encode(password);
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.nickName = nickName;
  }
}
