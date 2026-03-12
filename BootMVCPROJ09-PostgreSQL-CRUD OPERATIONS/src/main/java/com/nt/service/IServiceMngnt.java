package com.nt.service;

import java.util.List;

import com.nt.entity.EmployeeEntiity;
import com.nt.voclass.EmployeeVo;

public interface IServiceMngnt {
	public List<EmployeeVo> showAllEmps();
	public String addEmployee(EmployeeVo evo);
	public EmployeeVo showEmployeeById(int id);
	public String saveEditedData(EmployeeVo empv);
	public String removeData(int id);

}
