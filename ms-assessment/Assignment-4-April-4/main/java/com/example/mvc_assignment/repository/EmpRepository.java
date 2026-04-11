package com.example.mvc_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvc_assignment.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	
}