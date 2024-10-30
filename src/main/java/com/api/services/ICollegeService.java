package com.api.services;

import java.util.List;

import com.api.dtos.CollegeDetailsDTO;


public interface ICollegeService {

	public CollegeDetailsDTO saveCollegeDetails(CollegeDetailsDTO collegeDetailsDTO);

	public CollegeDetailsDTO getCollegeDetailsById(int collegeId);

	public List<CollegeDetailsDTO> getAllCollegeDetails();

	public CollegeDetailsDTO updateCollegeDetailsById(CollegeDetailsDTO collegeDetailsDTO, int collegeId);
	
	public void deleteCollegeDetailsById(int collegeId);
}
