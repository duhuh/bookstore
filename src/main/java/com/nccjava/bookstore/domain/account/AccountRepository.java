package com.nccjava.bookstore.domain.account;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Override
    <S extends Account> S save(S entity);

    @Override
    Optional<Account> findById(Integer integer);

    @Override
    Iterable<Account> findAll();
}
