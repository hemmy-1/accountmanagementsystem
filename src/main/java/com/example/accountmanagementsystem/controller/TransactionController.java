package com.example.accountmanagementsystem.controller;

import com.example.accountmanagementsystem.entity.Transaction;
import com.example.accountmanagementsystem.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tran")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    
    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(
            @RequestParam int accountNum,
            @RequestParam int amount,
            @RequestParam(required = false) String description) {

        Transaction transaction = transactionService.deposit(accountNum, amount, description);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    
    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(
            @RequestParam int accountNum,
            @RequestParam int amount,
            @RequestParam(required = false) String description) {

        Transaction transaction = transactionService.withdraw(accountNum, amount, description);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    // GET /api/transactions/history/1029384756
    @GetMapping("/history/{accountNum}")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable int accountNum) {
        List<Transaction> history = transactionService.getTransactionHistory(accountNum);
        return ResponseEntity.ok(history);
    }
}