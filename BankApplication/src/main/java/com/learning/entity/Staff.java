package com.learning.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table
@CrossOrigin
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fullName;
	private String username;
	private String password;
	private Long ssn;
	private String email;
	private String phoneNumber;
	private String address;
	private UserRoleType userRoleType = UserRoleType.STAFF;
	private StaffStatusType staffStatusType;
	private String securityQuestionAnswer;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateOfCreation;
	
	@PrePersist
	private void onCreate() {
		dateOfCreation = new Date();
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(Long id, String fullName, String username, String password, Long ssn, String email, String phoneNumber,
			String address, UserRoleType userRoleType, StaffStatusType staffStatusType, String securityQuestionAnswer,
			Date dateOfCreation) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.ssn = ssn;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userRoleType = userRoleType;
		this.staffStatusType = staffStatusType;
		this.securityQuestionAnswer = securityQuestionAnswer;
		this.dateOfCreation = dateOfCreation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserRoleType getUserRoleType() {
		return userRoleType;
	}

	public void setUserRoleType(UserRoleType userRoleType) {
		this.userRoleType = userRoleType;
	}

	public StaffStatusType getStaffStatusType() {
		return staffStatusType;
	}

	public void setStaffStatusType(StaffStatusType staffStatusType) {
		this.staffStatusType = staffStatusType;
	}

	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", fullName=" + fullName + ", username=" + username + ", password=" + password
				+ ", ssn=" + ssn + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", userRoleType=" + userRoleType + ", staffStatusType=" + staffStatusType
				+ ", securityQuestionAnswer=" + securityQuestionAnswer + ", dateOfCreation=" + dateOfCreation + "]";
	}
	
	
}
