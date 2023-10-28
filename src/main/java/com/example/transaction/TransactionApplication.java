package com.example.transaction;

import com.example.transaction.domain.Account;
import com.example.transaction.repository.AccountRepository;
import com.example.transaction.service.AccountService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TransactionApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        Account from=accountRepository.findById(1L).get();
        Account to=accountRepository.findById(2L).get();
        accountService.transfer(from,to,30.0);


    }
}
