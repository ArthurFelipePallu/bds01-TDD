package com.devsuperior.bds01.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentResource {

	@Autowired
	private DepartmentService department_Service;

	@GetMapping
	public ResponseEntity<Page<DepartmentDTO>> findAll(Pageable pageable) {

		Page<DepartmentDTO> list = department_Service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}

}
