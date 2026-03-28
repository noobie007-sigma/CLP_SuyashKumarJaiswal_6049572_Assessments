package com.tcs.loan_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tcs.loan_management.entity.Loan;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByApplicantNameAndStatus(String applicantName, String status);
}