# Account Transfer API 구현

```text
java : 17
project : gradle project
IDE : intellij
```

- [AccountServiceImpl.java](/src/main/java/com/bang/banking/account/application/AccountServiceImpl.java)
```java
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;
  private final TransferHistoryRepository transferHistoryRepository;
  private final ApplicationEventPublisher publisher;

  @Transactional
  @Override
  public void accountTransfer(AccountTransferRequest request) {
    // 계좌 조회
    Accounts accounts = accountRepository.findById(request.getSenderAccountNumber())
        .orElseThrow(() -> new IllegalArgumentException("요청한 계좌번호가 존재하지 않습니다."));

    // 계좌에서 출금
    accounts.withdraw(request.getTransferAmount(), request.getSenderAccountPassword());

    // 이체 정보 저장
    TransferHistory transferHistory = TransferHistory.ofFriendTransfer(request);
    transferHistoryRepository.save(transferHistory);
    // 메세지 전달
    publisher.publishEvent(new TransferEventDto(transferHistory));
  }
}
```