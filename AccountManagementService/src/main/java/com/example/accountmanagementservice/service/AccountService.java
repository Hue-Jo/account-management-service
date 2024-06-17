package com.example.accountmanagementservice.service;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.domain.AccountStatus;
import com.example.accountmanagementservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // 꼭 필요한 요소들만 들어간 생성자 만들어줌 (안 보이지만 아무튼 존재함)
public class AccountService {

    private final AccountRepository accountRepository; // 타입을 final로 만들어주기

    @Transactional
    public void createAccount(){
        Account account = Account.builder()
                .accountNumber("40000")
                .accountStatus(AccountStatus.IN_USE)
                .build();
        accountRepository.save(account);
    }

    @Transactional
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }

}
