package com.example.accountmanagementservice.controller;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.dto.AccountDto;
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
        return CreateAccount.Response.from(
                accountService.createAccount(
                    request.getUserId(),
                    request.getInitialBalance())
        );
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
