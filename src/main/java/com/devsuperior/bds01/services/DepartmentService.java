package com.devsuperior.bds01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;

public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	@Transactional(readOnly = true)
	public Page<DepartmentDTO> findAll(Pageable request){
		Page<Department> list = repository.findAll(request);
		return list.map(x->new DepartmentDTO(x));		
	}
	

}
