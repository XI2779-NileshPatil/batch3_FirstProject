package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee(int pageNo, int pageSize, String order) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, order.equals("asc") ? Sort.by("name").ascending() : Sort.by("name").descending());
		Page<Employee> page = employeeRepository.findAll(pageable);
		return page.toList();
		
		//return employeeRepository.findAll();
	}

	public Employee getEmployee(int id) {
		Optional<Employee> optEmp = employeeRepository.findById(id);
		Employee e = optEmp.isPresent() ? optEmp.get() : null;
		e.setName(e.getName()+ " Chnaged");
		return e;
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public String updateEmployee(int id, Employee employee) {
		Optional<Employee> optEmp = employeeRepository.findById(id);
		
		if (optEmp.isPresent()) {
			Employee emp = optEmp.get();
			emp.setName(employee.getName());
			emp.setSalary(employee.getSalary());
			emp = employeeRepository.save(emp);
			return "Employee Updated successfully with id "+id;
		} else {
			return "Employee is not present with ID "+id;
		}
		
		
	}

	public Long getSumOfSalary() {
		return employeeRepository.getSumOfSalary();
	}

}
