package com.example.accountmanagementservice.service;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.domain.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;


    @BeforeEach
    void init() {
        accountService.createAccount();
    }


    @Test
    @DisplayName("Test 1")
    void testGetAccount1(){

        accountService.createAccount();
        Account account = accountService.getAccount(1L);

        assertEquals("40000", account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
        }

    @Test
    @DisplayName("Test 2")
    void testGetAccount2(){

        accountService.createAccount();
        Account account = accountService.getAccount(2L);

        assertEquals("40000", account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
        }

}