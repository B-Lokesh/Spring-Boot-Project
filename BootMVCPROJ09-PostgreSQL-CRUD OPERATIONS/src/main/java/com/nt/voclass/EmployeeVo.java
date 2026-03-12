package com.nt.voclass;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeVo {
	//PROPERTIES OF EMPLOYEE
	private int empno;
	@NonNull
	private String empName;
	@NonNull
	private String empAdd="hyd";
	@NonNull
	private Double empSal;
	@NonNull
	private String empDesg;
	private Double grossSalary;
	private Double netSalary;
}
