package com.example.accountmanagementservice.domain;

import com.example.accountmanagementservice.type.AccountStatus;
import com.example.accountmanagementservice.type.TransactionResultType;
import com.example.accountmanagementservice.type.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    @Id // pk지정
    @GeneratedValue
    private Long id;

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

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
