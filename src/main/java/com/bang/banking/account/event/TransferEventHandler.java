package com.bang.banking.account.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class TransferEventHandler {

  @Async
  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMPLETION
  )
  public void handler(TransferEventDto dto) {
    log.info("message 전송 : {} , {}", dto.getTransferId(), dto.getReceiverId());
  }
}
