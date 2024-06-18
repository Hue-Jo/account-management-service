package com.example.accountmanagementservice.service;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.domain.AccountUser;
import com.example.accountmanagementservice.dto.AccountDto;
import com.example.accountmanagementservice.exception.AccountException;
import com.example.accountmanagementservice.repository.AccountRepository;
import com.example.accountmanagementservice.repository.AccountUserRepository;
import com.example.accountmanagementservice.type.AccountStatus;
import com.example.accountmanagementservice.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.example.accountmanagementservice.type.AccountStatus.IN_USE;

@Service
@RequiredArgsConstructor // 꼭 필요한 요소들만 들어간 생성자 만들어줌 (안 보이지만 아무튼 존재함)
public class AccountService {

    private final AccountRepository accountRepository; // 타입을 final로 만들어주기
    private final AccountUserRepository accountUserRepository;

    /**
     * 사용자 존재여부 조회
     * 계좌번호 생성
     * 계좌 저장, 정보 리턴
     */
    @Transactional
    public AccountDto createAccount(Long userId, Long initialBalance) {

        AccountUser accountUser = accountUserRepository.findById(userId)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));


        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()
                .map(account -> (Integer.parseInt(account.getAccountNumber())) + 1 + "") // 1 더한 후 문자화
                .orElse("1000000000"); // 현재 계좌가 하나도 없을 경우, 10자리


        return AccountDto.fromEntity(
                accountRepository.save(
                        Account.builder()
                                .accountUser(accountUser)
                                .accountStatus(IN_USE)
                                .accountNumber(newAccountNumber)
                                .balance(initialBalance)
                                .registeredAt(LocalDateTime.now())
                                .build()
                )
        );
    }

    @Transactional
    public Account getAccount(Long id) {
        if (id < 0) {
            throw new RuntimeException("Minus");
        }
        return accountRepository.findById(id).get();
    }

}
