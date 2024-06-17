package com.example.accountmanagementservice.repository;

import com.example.accountmanagementservice.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {  // 활용할 엔티티, pk의 타입


}
