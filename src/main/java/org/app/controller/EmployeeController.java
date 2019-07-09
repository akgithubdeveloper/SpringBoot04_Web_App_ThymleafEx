package org.app.controller;

import java.util.Arrays;
import java.util.List;

import org.app.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@RequestMapping("/reg")
	public String regPage(ModelMap map) {
		
		//Form Backing Object
		Employee e=new Employee();
		map.addAttribute("employee",e);
		
		return "Register";
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Employee employee, ModelMap map) {
		
		map.addAttribute("emp",employee);
		return "Info";
		
	}
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		
		map.addAttribute("message","Hello UI");
		List<Employee> emps=Arrays.asList(
				new Employee(10,"A",2.2),
				new Employee(11,"B",3.3),
				new Employee(12,"C",4.4));
		map.addAttribute("list",emps);
		return "Data";
				
	}
}
