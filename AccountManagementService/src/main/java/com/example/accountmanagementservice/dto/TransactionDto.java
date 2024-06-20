package com.example.accountmanagementservice.dto;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.type.TransactionResultType;
import com.example.accountmanagementservice.type.TransactionType;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private String accountNumber;
    private TransactionType transactionType;
    private TransactionResultType transactionResultType;
    private Long amount; // 거래금액
    private Long balanceSnapshot;
    private String transactionId; // 거래고유 아이디
    private LocalDateTime transactedAt; //
}
