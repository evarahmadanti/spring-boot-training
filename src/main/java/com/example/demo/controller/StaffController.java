package com.example.demo.controller;

import com.example.demo.dto.StaffDto;
import com.example.demo.dto.UpdateBalanceDto;
import com.example.demo.entity.StaffEntity;
import com.example.demo.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/add-staff")
    public StaffEntity addStaff(@RequestBody StaffDto staffDto) {
        return staffService.add(staffDto);
    }

    @GetMapping("/staff-data")
    public List<StaffEntity> getStaff() {
        return staffService.fetchAll();
    }

    @PutMapping("/update-balance")
    public StaffEntity addBalance(@RequestBody UpdateBalanceDto req) {
        return staffService.updateBalance(req);
    }
}
