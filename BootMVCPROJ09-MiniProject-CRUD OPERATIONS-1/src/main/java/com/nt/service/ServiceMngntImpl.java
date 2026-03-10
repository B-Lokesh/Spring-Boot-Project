package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeEntiity;
import com.nt.error.EmployeeNotFoundException;
import com.nt.repository.JpRepository;
import com.nt.voclass.EmployeeVo;

@Service
public class ServiceMngntImpl implements IServiceMngnt {
	@Autowired
	private JpRepository repo;

	@Override
	public List<EmployeeVo> showAllEmps() {
		//store all employeentity to a list
		List<EmployeeEntiity> listEntity =repo.findAll();
		//now copy data of listentity to listVo
		List<EmployeeVo> listVo = new ArrayList<>();
		listEntity.forEach(var->{
			EmployeeVo empVo = new EmployeeVo();
			BeanUtils.copyProperties( var,empVo);
			empVo.setGrossSalary(empVo.getEmpSal()+empVo.getEmpSal()*0.5);
			empVo.setNetSalary(empVo.getGrossSalary()- empVo.getGrossSalary()*0.2);
			listVo.add(empVo);
		});
		return listVo;
	}

	@Override
	public String addEmployee(EmployeeVo evo) {
		EmployeeEntiity ee = new EmployeeEntiity();
		ee.setCreatedBy(System.getProperty("user.name"));
		BeanUtils.copyProperties(evo, ee);
		int id = repo.save(ee).getEmpno();
		String msz="Record Saved With ID::"+id;
		return msz;
	}

	@Override
	public EmployeeVo showEmployeeById(int id) {
		//use repo, take already date so meta remain same and remainaing copied to vo
		EmployeeEntiity empEn = repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("invalid id"));
		EmployeeVo empvo = new EmployeeVo();
		//copy to vo
		BeanUtils.copyProperties(empEn, empvo);
		return empvo;
	}

	@Override
	public String saveEditedData(EmployeeVo empv) {
		//take old data of entity
		EmployeeEntiity empEn = repo.findById(empv.getEmpno()).orElseThrow(()->new EmployeeNotFoundException("invalid id"));
		BeanUtils.copyProperties(empv, empEn);
		empEn.setUpdatedBy(System.getProperty("user.name"));
		int id = repo.save(empEn).getEmpno();
		String msz1 = "Updated Employee Data With ID:: "+id;
		return msz1;
	}

	@Override
	public String removeData(int id) {
		EmployeeEntiity empEn = repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("invalid id"));
		/*EmployeeVo empv = new EmployeeVo();
		BeanUtils.copyProperties(empEn, empv);*/
		repo.deleteById(id);
		String msz="Deleted Record";
		return msz;
	}

	
	

}
