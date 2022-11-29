package com.learning.service;

import org.springframework.stereotype.Service;

import com.learning.entity.Staff;

@Service
public interface StaffService {
	public Staff createStaff(Staff staff);
	public Staff updateStaffStatus(Long id, Staff staff);
}
