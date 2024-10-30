package com.api.pagination.service;

import org.springframework.data.domain.Page;

import com.api.models.CollegeDetails;

public interface IPaginationService {

	Page<CollegeDetails> getCollegeDetaills(int page, int size);
}
