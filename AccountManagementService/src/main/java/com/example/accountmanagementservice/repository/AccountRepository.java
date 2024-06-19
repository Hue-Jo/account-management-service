package com.example.accountmanagementservice.repository;

import com.example.accountmanagementservice.domain.Account;
import com.example.accountmanagementservice.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {  // 활용할 엔티티, pk의 타입

    Optional<Account> findFirstByOrderByIdDesc();

    Integer countByAccountUser(AccountUser accountUser);


}
