package com.tcs.loan_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Applicant name is required")
    private String applicantName;

    @Min(value = 1, message = "Loan amount must be greater than 0")
    @Max(value = 5000000, message = "Loan amount must not exceed 5000000")
    private double loanAmount;

    private String status;

    public Loan() {}

    public Loan(Long id, String applicantName, double loanAmount, String status) {
        this.id = id;
        this.applicantName = applicantName;
        this.loanAmount = loanAmount;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}