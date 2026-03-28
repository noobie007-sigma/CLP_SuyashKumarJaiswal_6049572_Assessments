package com.tcs.loan_management.service;

import com.tcs.loan_management.entity.Loan;
import java.util.List;

public interface LoanService {

    Loan createLoan(Loan loan);

    List<Loan> getAllLoans();

    Loan getLoanById(Long id);

    Loan updateLoanStatus(Long id, String status);
}