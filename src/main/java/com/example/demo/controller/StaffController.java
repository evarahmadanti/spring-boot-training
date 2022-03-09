package com.example.demo.controller;

import com.example.demo.dto.StaffDto;
import com.example.demo.entity.StaffEntity;
import com.example.demo.service.StaffService;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/add-staff")
    public StaffEntity addStaff(@RequestBody StaffDto staffDto) {
        return staffService.add(staffDto);
    }
}
