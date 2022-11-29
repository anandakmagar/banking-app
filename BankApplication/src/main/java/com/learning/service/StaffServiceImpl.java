package com.learning.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Account;
import com.learning.entity.Staff;
import com.learning.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	StaffRepository staffRepository;

	@Override
	public Staff createStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	@Override
	public Staff updateStaffStatus(Long id, Staff staff) {
        Staff staff1 = staffRepository.findById(id).get();

        if(Objects.nonNull(staff.getId())){
            staff1.setId(staff.getId());
        }

        if(Objects.nonNull(staff.getStaffStatusType())){
            staff1.setStaffStatusType(staff.getStaffStatusType());
        }
        return staffRepository.save(staff1);
	}
	
	
}
