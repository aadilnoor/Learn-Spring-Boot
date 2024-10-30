package com.api.pagination.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.models.CollegeDetails;
import com.api.repositries.CollegeRepository;

@Service
public class PaginationService implements IPaginationService {

	@Autowired
	private CollegeRepository collegeRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Page<CollegeDetails> getCollegeDetaills(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return collegeRepository.findAll(pageable);
		 
	}
}
