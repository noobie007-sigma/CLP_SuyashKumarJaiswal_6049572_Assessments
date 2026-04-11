package com.tcs.loan_management.service;

import com.tcs.loan_management.entity.Loan;
import com.tcs.loan_management.exception.DuplicateLoanApplicationException;
import com.tcs.loan_management.exception.LoanNotFoundException;
import com.tcs.loan_management.repository.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan createLoan(Loan loan) {

        // Business Rule: No duplicate PENDING loan
        loanRepository.findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING")
                .ifPresent(existingLoan -> {
                    throw new DuplicateLoanApplicationException(
                            "Applicant already has a loan with PENDING status"
                    );
                });

        loan.setStatus("PENDING");

        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() ->
                        new LoanNotFoundException("Loan not found with id: " + id)
                );
    }

    @Override
    public Loan updateLoanStatus(Long id, String status) {

        Loan loan = getLoanById(id);

        if (!status.equals("APPROVED") && !status.equals("REJECTED")) {
            throw new IllegalArgumentException(
                    "Invalid status. Only APPROVED or REJECTED allowed"
            );
        }

        loan.setStatus(status);

        return loanRepository.save(loan);
    }
}