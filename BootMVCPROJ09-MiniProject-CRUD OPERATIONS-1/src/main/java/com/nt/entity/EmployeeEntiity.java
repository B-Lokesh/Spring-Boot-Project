package com.nt.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@Table(name="MINPRO_EMP_TAB")
public class EmployeeEntiity {
	//PROPERTIES OF EMPLOYEE
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empno;
	@Column(length=30)
	@NonNull
	private String empName;
	@Column(length=30)
	@NonNull
	private String empAdd;
	@Column(length=30)
	@NonNull
	private Double empSal;
	@Column(length=30)
	@NonNull
	private String empDesg;
	
	//meta properties
	@Version
	private int updateCount;
	@CreationTimestamp
	@Column(updatable=false,insertable=true)
	private LocalDate createdTime;
	@UpdateTimestamp
	@Column(updatable=true,insertable=false)
	private LocalDate UpdatedTime;
	@Column
	private String createdBy;
	@Column
	private String updatedBy;

}
