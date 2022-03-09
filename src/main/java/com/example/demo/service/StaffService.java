package com.example.demo.service;

import com.example.demo.dto.StaffDto;
import com.example.demo.repository.StaffRepository;
import com.example.demo.entity.StaffEntity;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public StaffEntity add(StaffDto request) {
        StaffEntity staff = new StaffEntity();
        staff.setStaffName(request.getStaffName());
        staff.setPosition(request.getPosition());
        staff.setBalance(request.getBalance());

        return staffRepository.save(staff);
    }
}
