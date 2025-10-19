package com.poly.lab7.dao;

import com.poly.lab7.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, Integer> {
}
