package com.example.accountmanagementservice.domain;

import com.example.accountmanagementservice.type.TransactionResultType;
import com.example.accountmanagementservice.type.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType;

    @ManyToOne //(n개가 특정 계좌에 연결)
    private Account account; // 연결계좌
    private Long amount; // 거래금액
    private Long balanceSnapshot;

    private String transactionId; // 거래고유 아이디
    private LocalDateTime transactedAt; //

}
