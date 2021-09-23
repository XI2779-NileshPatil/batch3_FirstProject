package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTests {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Test
	public void getEmployeeTest() {
		int id=1;
		when(employeeRepository.findById(id)).thenReturn(Optional.of(new Employee(1, "Test", 2000)));
		when(employeeRepository.save(new Employee(1, "Test", 2000))).thenReturn(new Employee(1, "Test", 2000));
		
		Employee actualResult =  employeeService.getEmployee(id);
		System.out.println(actualResult.getName());
		
		assertEquals("Test  Chnaged", actualResult.getName());
		
	}

}
