package com.example.accountmanagementservice.controller;

import com.example.accountmanagementservice.dto.AccountDto;
import com.example.accountmanagementservice.dto.CancelBalance;
import com.example.accountmanagementservice.dto.TransactionDto;
import com.example.accountmanagementservice.dto.UseBalance;
import com.example.accountmanagementservice.service.TransactionService;
import com.example.accountmanagementservice.type.TransactionResultType;
import com.example.accountmanagementservice.type.TransactionType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.example.accountmanagementservice.type.TransactionResultType.*;
import static com.example.accountmanagementservice.type.TransactionType.USE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {
    @MockBean
    private TransactionService transactionService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void successUseBalance() throws Exception {
        //given
        given(transactionService.useBalance(anyLong(), anyString(), anyLong()))
                .willReturn(TransactionDto.builder()
                        .accountNumber("1000000000")
                        .transactedAt(LocalDateTime.now())
                        .amount(12345L)
                        .transactionId("transactionId")
                        .transactionResultType(S)
                        .build());
        //when
        //then
        mockMvc.perform(post("/transaction/use")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                        new UseBalance.Request(1L, "2000000000", 3000L))
                )
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("1000000000"))
                .andExpect(jsonPath("$.transactionResult").value("S"))
                .andExpect(jsonPath("$.amount").value(12345L))
                .andExpect(jsonPath("$.transactionId").value("transactionId"));
    }

    @Test
    void successCancelBalance() throws Exception {
        //given
        given(transactionService.cancelBalance(anyString(), anyString(), anyLong()))
                .willReturn(TransactionDto.builder()
                        .accountNumber("1000000000")
                        .transactedAt(LocalDateTime.now())
                        .amount(54321L)
                        .transactionId("transactionIdForCancel")
                        .transactionResultType(S)
                        .build());
        //when
        //then
        mockMvc.perform(post("/transaction/cancel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new CancelBalance.Request("transactionId", "2000000000", 3000L))
                        )
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("1000000000"))
                .andExpect(jsonPath("$.transactionResult").value("S"))
                .andExpect(jsonPath("$.amount").value(54321L))
                .andExpect(jsonPath("$.transactionId").value("transactionIdForCancel"));
    }


    @Test
    void successQueryTransaction() throws Exception {
        //given
        List<AccountDto> accountDtos =
                Arrays.asList(
                        AccountDto.builder()
                                .accountNumber("1234567890")
                                .balance(1000L)
                                .build(),
                        AccountDto.builder()
                                .accountNumber("1111111111")
                                .balance(2000L)
                                .build(),
                        AccountDto.builder()
                                .accountNumber("2222222222")
                                .balance(3000L)
                                .build()
                );

        given(transactionService.queryTransaction(anyString()))
                .willReturn(TransactionDto.builder()
                                .accountNumber("1000000000")
                        .transactionType(USE)
                                .transactedAt(LocalDateTime.now())
                                .amount(54321L)
                                .transactionId("transactionIdForCancel")
                                .transactionResultType(S)
                                .build());
        //when
        //then
        mockMvc.perform(get("/transaction/12345"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("1000000000"))
                .andExpect(jsonPath("$.transactionType").value("USE"))
                .andExpect(jsonPath("$.transactionResult").value("S"))
                .andExpect(jsonPath("$.amount").value(54321L))
                .andExpect(jsonPath("$.transactionId").value("transactionIdForCancel"));

    }

}