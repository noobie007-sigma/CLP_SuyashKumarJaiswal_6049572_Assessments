package com.example.mvc_assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc_assignment.dto.EmpDto;
import com.example.mvc_assignment.service.EmpService;

import jakarta.validation.Valid;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/viewall")
    public String viewAll(Model model, @RequestParam(required = false) String msg) {
        model.addAttribute("employees", service.getAllEmployees());
        model.addAttribute("message", msg);
        return "viewall";
    }

    
    @GetMapping("/edit/{eid}")
    public String editForm(@PathVariable Integer eid, Model model) {
        model.addAttribute("emp", service.getEmpById(eid));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateEmployee(@Valid @ModelAttribute("emp") EmpDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        service.updateEmployee(dto);
        return "redirect:/viewall?msg=Employee Edited";
    }

    @GetMapping("/delete/{eid}")
    public String deleteEmployee(@PathVariable Integer eid) {

        service.deleteEmployee(eid);
        return "redirect:/viewall?msg=Employee Deleted";
    }
}