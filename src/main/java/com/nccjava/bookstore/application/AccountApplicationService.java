package com.nccjava.bookstore.application;

import com.nccjava.bookstore.domain.account.Account;
import com.nccjava.bookstore.domain.account.AccountRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@Transactional
public class AccountApplicationService {

    @Inject
    private AccountRepository repository;

    public void createAccount(Account account){
        repository.save(account);
    }

    public Iterable<Account> getAllAccounts() {
        return repository.findAll();
    }

}
