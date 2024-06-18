package com.example.accountmanagementservice.controller;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.dto.CreateAccount;
import com.example.accountmanagementservice.service.AccountService;
import com.example.accountmanagementservice.service.RedisTestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @PostMapping("/account")
    public CreateAccount.Response createAccount(
        @RequestBody @Valid CreateAccount.Request request
    ) {
        accountService.createAccount(request.getUserId(),
                request.getInitialBalance());
        return "계좌가 생성되었습니다";
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
