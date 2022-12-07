package com.devsuperior.bds01.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;

public class DepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private List<EmployeeDTO> employees = new ArrayList<>();
	
	
	public DepartmentDTO() {
	}
	
	public DepartmentDTO(Department dep) {
		this.id = dep.getId();
		this.name = dep.getName();
	}
	
	public DepartmentDTO(Department dep,Set<Employee>employees) {
		this(dep);
		employees.forEach(x->this.employees.add(new EmployeeDTO(x)));
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<EmployeeDTO> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}
	
	
	


}
