package com.api.pagination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.CollegeDetails;
import com.api.pagination.service.IPaginationService;

@RestController
@RequestMapping("/api")
public class PaginationController {

	@Autowired
	private IPaginationService paginationService;

	@GetMapping("/page")
	public Page<CollegeDetails> getAllCollegeDetails(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		return paginationService.getCollegeDetaills(page, size);
	}

}
