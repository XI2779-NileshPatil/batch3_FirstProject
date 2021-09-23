package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int salary;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="org_loc_id")
//	private OrgLocation orgLocation;
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "emp_id")
//	private Set<EmployeeDetails> employeeDetails;
//	
//	@ManyToOne
//	@JoinColumn(name="dept_id")
//	private Department department;
//	
//	@ManyToMany
//	@JoinTable(name = "employee_training",
//	joinColumns = @JoinColumn(name = "emp_id"),
//	inverseJoinColumns = @JoinColumn(name = "training_id"))
//	private Set<Training> trainings;
	
	
}
