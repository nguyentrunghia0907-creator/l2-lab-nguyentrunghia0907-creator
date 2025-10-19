package com.poly.lab8.service.impl;

import com.poly.lab8.dao.AccountDAO;
import com.poly.lab8.entity.Account;
import com.poly.lab8.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO adao;

    @Override
    public Account findByUserName(String name) {
        return adao.findById(name).orElse(null);
    }

    @Override
    public boolean login(String name, String password) {
        Account account = adao.findById(name).orElse(null);
        if(account != null && account.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
