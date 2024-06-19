package com.example.accountmanagementservice.dto;

import com.example.accountmanagementservice.domain.Account;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private Long userId;          // 사용자 아이디
    private String accountNumber; // 계좌 번호
    private Long balance;         // 잔액

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;


    // 특정 엔티티에서 특정 Dto로 변환할 때 쓰는 정적메서드
    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .userId(account.getAccountUser().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnRegisteredAt())
                .build();
    }
}
