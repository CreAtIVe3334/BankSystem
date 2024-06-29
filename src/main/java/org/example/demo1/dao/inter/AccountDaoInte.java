package org.example.demo1.dao.inter;

import org.example.demo1.dto.AccountGetDto;
import org.example.demo1.dto.AccountUpdate;
import org.example.demo1.dto.BalanceChange;
import org.example.demo1.dto.CreateAccountDto;
import org.example.demo1.entity.Account;
import org.example.demo1.entity.User;

import java.util.List;

public interface AccountDaoInte {

    public void create(CreateAccountDto createAccountDto, User user);

    public List<AccountGetDto> findAll(Long userId);

    public void update(AccountUpdate accountUpdate);
    public Account findByNumber(String number);
}
