package com.example.accountmanagementservice;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
//@NoArgsConstructor // 아무것도 없는 생성자
@AllArgsConstructor // 모든 요소가 다 들어간 생성자
@RequiredArgsConstructor // 필수값들을 받는 생성자
@Data // 상위 것들 포함한 세트 (그런데 주의해야 함. 중요한 것들이 들어가면 곤란할 수도)
@Slf4j // 로그
public class AccountDto {
    private String accountNumber;
    private String nickname;
    private LocalDateTime registeredAt;

    public void log() {
        log.error("Error is occurred!");
    }

}
