package com.example.demo.service;

import com.example.demo.dto.StaffDto;
import com.example.demo.dto.UpdateBalanceDto;
import com.example.demo.repository.StaffRepository;
import com.example.demo.entity.StaffEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<StaffEntity> fetchAll() {
        return (List<StaffEntity>) staffRepository.findAll();
    }

    public StaffEntity getByIds(long ids) {
        return staffRepository.findById(ids).orElse(new StaffEntity());
    }

    public StaffEntity updateBalance(UpdateBalanceDto req) {
        StaffEntity staff = getByIds((req.getIds()));

        //Update balance
        long currentBalance = staff.getBalance();
        long updatedBalance = currentBalance + req.getBalanceAmount();
        staff.setBalance(updatedBalance);

        //save into DB
        return staffRepository.save(staff);
    }
}
