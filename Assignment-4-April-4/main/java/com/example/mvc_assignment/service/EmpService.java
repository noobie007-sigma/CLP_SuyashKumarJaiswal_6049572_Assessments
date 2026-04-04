package com.example.mvc_assignment.service;

import java.util.List;

import com.example.mvc_assignment.dto.EmpDto;

public interface EmpService {

    List<EmpDto> getAllEmployees();

    EmpDto getEmpById(Integer id);

    void updateEmployee(EmpDto dto);

    void deleteEmployee(Integer id);
}