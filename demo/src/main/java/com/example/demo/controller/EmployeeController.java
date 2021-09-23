package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.mathutils.MathCalculation;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "Employee Added Successfully";
	}
	
	@GetMapping("/employees/{pageNo}/{pageSize}/{order}")
	public List<Employee> getAllEmployee(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @PathVariable("order") String order) {
		return employeeService.getAllEmployee(pageNo, pageSize, order);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		System.out.println(new MathCalculation().calculateMultiplication(2, 3));
		return employeeService.getEmployee(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		System.out.println(new MathCalculation().calculation(5, 2));
		employeeService.deleteEmployee(id);
		return "Employee Deleted Successfully";
	}
	
	@PutMapping("/employees/{id}")
	public String updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	@GetMapping("/employees/sumOfSalary")
	public Long getSumOfSalary() {
		return employeeService.getSumOfSalary();
	}
	
	
	
	//get, post, put, delete
	
}
