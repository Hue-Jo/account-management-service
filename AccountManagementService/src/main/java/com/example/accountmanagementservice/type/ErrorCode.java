package com.example.accountmanagementservice.type;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("사용자가 존재하지 않습니다."),
    MAX_ACCOUNT_PER_USER_10("사용자 최대 계좌 수는 10개입니다.");

    private final String description;
}
