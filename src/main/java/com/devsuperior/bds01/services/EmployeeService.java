package com.devsuperior.bds01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import com.devsuperior.bds01.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private DepartmentRepository departmentrepository;

	public Page<EmployeeDTO> findAllPaged(Pageable request) {
		Page<Employee> list = repository.findAll(request); 
		return list.map(x->new EmployeeDTO(x));
	}

	@Transactional(readOnly = true)
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee employee = new Employee();
		copyDtoToEntity(dto,employee);
		employee = repository.save(employee);
		return new EmployeeDTO(employee);
	}
	
	private void copyDtoToEntity(EmployeeDTO dto, Employee employee) {
		employee.setName(dto.getName());
		employee.setEmail(dto.getEmail());	
		Department dpt = departmentrepository.findById(dto.getDepartmentId()).get();
		employee.setDepartment(dpt);
	}
}
