package com.example.accountmanagementservice;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountDtoTest {

    @Test
    void accountDto() {
        AccountDto accountDto = new AccountDto(
                "accountNumber",
                "Hue-Jo",
                LocalDateTime.now());
        //accountDto.setAccountNumber("accountNumber");
        //accountDto.setNickname("Hue-Jo");
        System.out.println(accountDto.getAccountNumber());

        System.out.println(accountDto.toString());

    }

}