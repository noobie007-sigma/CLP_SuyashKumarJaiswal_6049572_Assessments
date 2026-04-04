package com.example.mvc_assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc_assignment.dto.EmpDto;
import com.example.mvc_assignment.entity.Emp;
import com.example.mvc_assignment.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository repo;

    private EmpDto mapToDto(Emp emp) {
        EmpDto dto = new EmpDto();
        dto.setEmpId(emp.getEmpId());
        dto.setEmpName(emp.getEmpName());
        dto.setEmpSal(emp.getEmpSal());
        dto.setEmpDoj(emp.getEmpDoj());
        dto.setDeptName(emp.getDeptName());
        return dto;
    }

    private Emp mapToEntity(EmpDto dto) {
        Emp emp = new Emp();
        emp.setEmpId(dto.getEmpId());
        emp.setEmpName(dto.getEmpName());
        emp.setEmpSal(dto.getEmpSal());
        emp.setEmpDoj(dto.getEmpDoj());
        emp.setDeptName(dto.getDeptName());
        return emp;
    }

    @Override
    public List<EmpDto> getAllEmployees() {

        List<Emp> empList = repo.findAll();
        List<EmpDto> dtoList = new ArrayList<>();

        for (Emp emp : empList) {
            dtoList.add(mapToDto(emp));
        }

        return dtoList;
    }

    @Override
    public EmpDto getEmpById(Integer id) {
        Emp emp = repo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        return mapToDto(emp);
    }

    @Override
    public void updateEmployee(EmpDto dto) {
        repo.save(mapToEntity(dto));
    }

    @Override
    public void deleteEmployee(Integer id) {
        repo.deleteById(id);
    }
}