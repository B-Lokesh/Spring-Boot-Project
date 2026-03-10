package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.service.IServiceMngnt;
import com.nt.voclass.EmployeeVo;

@Controller
public class RequestHandlerController {
	@Autowired
	private  IServiceMngnt serv;
	
	@GetMapping("/")
	public String showHomePage()
	{
		//return lvn
		return "welcome";
	}
	@GetMapping("/report")
	public String showReportPage(Map<String,Object> map)
	{
		List<EmployeeVo> listVo =serv.showAllEmps();
		map.put("listEmps",listVo );
		//lvn
		return "report_show";
	}
		
	@GetMapping("/add")
	public String showDetailsPage(@ModelAttribute("Emp") EmployeeVo emp)
	{
		return "fill_data";
	}
	
	@PostMapping("/add")
	public String saveDataToDB(RedirectAttributes attr,@ModelAttribute("Emp") EmployeeVo emp)
	{
		//use service
		String msz=serv.addEmployee(emp);
		//map.put("resultMsz", msz);
		attr.addFlashAttribute("resultMsz",msz);
		return "redirect:report";
	}
	
	@GetMapping("/edit")
	public String showEditForm(@ModelAttribute("Emp") EmployeeVo Emp,@RequestParam("sno")int no) {
		EmployeeVo empvo1 = serv.showEmployeeById(no);
		BeanUtils.copyProperties(empvo1, Emp);
		return "edit_Form";
	}
	
	@PostMapping("/edit")
	public String saveEmpEditedData(@ModelAttribute("Emp") EmployeeVo emp,RedirectAttributes attr)
	{
		String resMsz = serv.saveEditedData(emp);
		System.out.println(resMsz);
		//add msz to attrs
		attr.addFlashAttribute("resultMsz",resMsz);
		//return request
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String removeDataById(RedirectAttributes attr,@RequestParam("sno") int no,@ModelAttribute("Emp")EmployeeVo vo)
	{
		String msz=serv.removeData(no);
		attr.addFlashAttribute("resultMsz",msz);
		return "redirect:report";	
	}
}
