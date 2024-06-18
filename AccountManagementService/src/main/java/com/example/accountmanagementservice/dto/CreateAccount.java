package com.example.accountmanagementservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

public class CreateAccount {

    @Getter
    @Setter
    public static class Request {
        @NotNull
        @Min(1)
        private Long userId; // 사용자 아이디

        @NotNull
        @Min(100)
        private Long initialBalance; // 초기 액수
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId; // 사용자 아이디
        private String accountNumber; // 계좌 번호
        private LocalDateTime registeredAt; // 등록일시
    }
}
