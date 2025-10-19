package com.poly.lab8.service;

import com.poly.lab8.entity.Account;

public interface AccountService {
    Account findByUserName(String name);
    boolean login(String name, String password);
}
