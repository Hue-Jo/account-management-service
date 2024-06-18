package com.example.accountmanagementservice.controller;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.service.AccountService;
import com.example.accountmanagementservice.service.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @GetMapping("/create-account")
    public String createAccount() {
        accountService.createAccount();
        return "계좌가 생성되었습니다";
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
