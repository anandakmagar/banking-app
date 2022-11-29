package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Staff;
import com.learning.service.StaffService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StaffController {
	@Autowired
	StaffService staffService;
	
	@PostMapping("/admin/staff")
	public String createStaff(@RequestBody Staff staff) {
		staffService.createStaff(staff);
		return "Staff record has been created successfully";
	}
	
	@PutMapping("/admin/staff/{id}")
	public Staff updateStaffStatus(@PathVariable("id") Long id, @RequestBody Staff staff) {
		return staffService.updateStaffStatus(id, staff);
	}
}
