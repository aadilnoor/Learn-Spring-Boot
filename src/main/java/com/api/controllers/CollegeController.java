package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dtos.CollegeDetailsDTO;
import com.api.services.ICollegeService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/college")
@Log4j2
public class CollegeController {

	@Autowired
	private ICollegeService collegeService;

	
	@PostMapping("/save")
	public ResponseEntity<CollegeDetailsDTO> saveCollegeDetails(@RequestBody CollegeDetailsDTO collegeDetailsDTO) {
		CollegeDetailsDTO savecollegeDetailsDTO = collegeService.saveCollegeDetails(collegeDetailsDTO);
		return new ResponseEntity<>(savecollegeDetailsDTO, HttpStatus.CREATED);
	}

	@GetMapping("/getBy/{collegeId}")
	public ResponseEntity<CollegeDetailsDTO> getCollegeDetailById(@PathVariable int collegeId) {
		CollegeDetailsDTO collegeDetailsById = collegeService.getCollegeDetailsById(collegeId);
		return new ResponseEntity<>(collegeDetailsById, HttpStatus.FOUND);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CollegeDetailsDTO>> getAllCollegeDetails() {
		List<CollegeDetailsDTO> collegeDetails = collegeService.getAllCollegeDetails();
		return new ResponseEntity<>(collegeDetails, HttpStatus.OK);

	}

	@PutMapping("/update/{collegeId}")
	public ResponseEntity<?> updateById(@RequestBody CollegeDetailsDTO collegeDetails, @PathVariable int collegeId) {
		CollegeDetailsDTO collegeDetailsById = collegeService.updateCollegeDetailsById(collegeDetails, collegeId);
		return new ResponseEntity<>(collegeDetailsById, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{collegeId}")
	public ResponseEntity<?> deleteById(@PathVariable int collegeId) {
		collegeService.deleteCollegeDetailsById(collegeId);
		return new ResponseEntity<>("Details deleted with id :" + collegeId, HttpStatus.GONE);
	}

}
