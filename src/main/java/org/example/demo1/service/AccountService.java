package org.example.demo1.service;

import org.example.demo1.dao.impl.AccountDaoImpl;
import org.example.demo1.dao.impl.UserDaoImpl;
import org.example.demo1.dao.inter.AccountDaoInte;
import org.example.demo1.dao.inter.UserDaoInter;
import org.example.demo1.dto.AccountGetDto;
import org.example.demo1.dto.AccountUpdate;
import org.example.demo1.dto.BalanceChange;
import org.example.demo1.dto.CreateAccountDto;
import org.example.demo1.entity.Account;
import org.example.demo1.entity.User;
import org.example.demo1.exception.AccountException;

import java.util.List;

public class AccountService {

    private AccountDaoInte accountDaoInte = new AccountDaoImpl();

    private UserDaoInter userDaoInter = new UserDaoImpl();

    public void create(CreateAccountDto createAccountDto) throws Exception{
        String umumi = createAccountDto.getAcountNumber();
        String ilkIkiSimvol = umumi.substring(0,2);
        String digerSimvol=umumi.substring(2);
        if(umumi.length()!=16)throw new AccountException("Duzgun uzunluqda hesab nomresi daxil etmemisiniz");
        if(!ilkIkiSimvol.matches("[A-Z]{2}")) throw new AccountException("Ilk 2 simvol boyuk herfle olmalidir");
        if (!digerSimvol.matches("\\d*")) throw new AccountException("Diger simvollar reqem olmalidir");
        User user = userDaoInter.findId(createAccountDto.getUserId());
        accountDaoInte.create(createAccountDto,user);

    }

    public List<AccountGetDto> findAll(Long userId){
        return accountDaoInte.findAll(userId);
    }

    public void update(BalanceChange balanceChange) throws Exception{
        Account account = accountDaoInte.findByNumber(balanceChange.getFromNumber());
        Account account1 = accountDaoInte.findByNumber(balanceChange.getToNumber());
        if(account.getBalance()==0.0) throw new  AccountException("Balansinizda vesait yoxdur");
        if(account.getBalance()<balanceChange.getMoney()) throw new AccountException("Balansinizda kifayet qeder vesait yoxdur");
        account.setBalance(account.getBalance()-balanceChange.getMoney());
        account1.setBalance(account1.getBalance()+balanceChange.getMoney());
        accountDaoInte.update(new AccountUpdate(account.getAcountNumber(),account.getBalance()));
        accountDaoInte.update(new AccountUpdate(account1.getAcountNumber(),account1.getBalance()));
    }
}
