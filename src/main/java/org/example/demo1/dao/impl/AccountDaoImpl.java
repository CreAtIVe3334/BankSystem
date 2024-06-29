package org.example.demo1.dao.impl;

import org.example.demo1.dao.inter.AccountDaoInte;
import org.example.demo1.dto.AccountGetDto;
import org.example.demo1.dto.AccountUpdate;
import org.example.demo1.dto.BalanceChange;
import org.example.demo1.dto.CreateAccountDto;
import org.example.demo1.entity.Account;
import org.example.demo1.entity.User;
import org.example.demo1.enums.AccountStatus;

import javax.persistence.*;
import java.util.List;

public class AccountDaoImpl implements AccountDaoInte {


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("company");
    private static final EntityManager em = emf.createEntityManager();

    private static final EntityTransaction emt = em.getTransaction();


    @Override
    public void create(CreateAccountDto createAccountDto,User user) {
        em.getTransaction().begin();
        Account account = Account.builder()
                .accountStatus(AccountStatus.ACTIVE)
                .acountNumber(createAccountDto.getAcountNumber())
                .balance(0.0)
                .user(user)
                .build();

        em.persist(account);
        em.getTransaction().commit();
    }

    @Override
    public List<AccountGetDto> findAll(Long userId) {
        String jpql = "select new org.example.demo1.dto.AccountGetDto(a.acountNumber,a.balance) from Account a where a.user.id = :userId and a.accountStatus = 'ACTIVE'";
        TypedQuery<AccountGetDto> query = em.createQuery(jpql, AccountGetDto.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public void update(AccountUpdate accountUpdate) {
        String jpql = "select a from Account a where a.acountNumber = :userId";
        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        query.setParameter("userId", accountUpdate.getAccountNumber());
        Account account = query.getSingleResult();
        emt.begin();
        account.setBalance(accountUpdate.getBalance());
        emt.commit();
    }

    @Override
    public Account findByNumber(String number){
        String jpql = "select a from Account a where a.acountNumber = :userId";
        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        query.setParameter("userId", number);
        return query.getSingleResult();
    }
}
