package com.tcs.loan_management.controller;

import com.tcs.loan_management.entity.Loan;
import com.tcs.loan_management.service.LoanService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@Valid @RequestBody Loan loan) {
        return ResponseEntity.ok(loanService.createLoan(loan));
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.getLoanById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Loan> updateLoanStatus(
            @PathVariable Long id,
            @RequestBody Loan loan) {

        return ResponseEntity.ok(
                loanService.updateLoanStatus(id, loan.getStatus())
        );
    }
}