package com.example.accountmanagementservice.repository;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.domain.AccountUser;
import com.example.accountmanagementservice.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {  // 활용할 엔티티, pk의 타입

    Optional<Transaction> findByTransactionId(String transactionId);
}
