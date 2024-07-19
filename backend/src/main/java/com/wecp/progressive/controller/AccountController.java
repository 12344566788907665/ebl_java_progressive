package com.wecp.progressive.controller;
 
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.exception.AccountNotFoundException;
import com.wecp.progressive.service.AccountServiceImplJpa;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
 
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountServiceImplJpa accountServiceImplJpa;
 
    @GetMapping
    public ResponseEntity<List<Accounts>> getAllAccounts() {
        return new ResponseEntity<List<Accounts>>(accountServiceImplJpa.getAllAccounts(),HttpStatus.OK);
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<Accounts> getAccountById(int accountId) {
        return new ResponseEntity<>(accountServiceImplJpa.getAccountById(accountId),HttpStatus.OK);
    }
 
    public ResponseEntity<List<Accounts>> getAccountsByUser(String param) {
        return null;
    }
   
    @PostMapping
    public ResponseEntity<Integer> addAccount(Accounts accounts) {
        return new ResponseEntity<>(accountServiceImplJpa.addAccount(accounts),HttpStatus.CREATED);
    }
    @PutMapping("/{accountId}")
    public ResponseEntity<Void> updateAccount(int accountId, Accounts accounts) {
        return null;
    }
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(int accountId) {
        return null;
    }
 
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> accountNotFoundExceptionHandler(AccountNotFoundException messege){
        return new ResponseEntity<>(messege.getMessage(),HttpStatus.OK);
    }
}