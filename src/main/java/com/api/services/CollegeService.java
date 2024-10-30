package com.api.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dtos.CollegeDetailsDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.models.CollegeDetails;
import com.api.repositries.CollegeRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CollegeService implements ICollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

	@Autowired
	private ModelMapper mapper;

	// DTO to Entity conversion
	public CollegeDetails convertToEntity(CollegeDetailsDTO collegeDetailsDTO) {
		return mapper.map(collegeDetailsDTO, CollegeDetails.class);
	}

	// Entity to DTO conversion
	public CollegeDetailsDTO convertToDto(CollegeDetails collegeDetails) {
		return mapper.map(collegeDetails, CollegeDetailsDTO.class);
	}

	@Override
	public CollegeDetailsDTO saveCollegeDetails(CollegeDetailsDTO collegeDetailsDTO) {
		if (Objects.nonNull(collegeDetailsDTO)) {
			CollegeDetails convertToEntity = convertToEntity(collegeDetailsDTO);
			log.info("Save College Details...",collegeDetailsDTO.getCollegeName());
			collegeRepository.save(convertToEntity);
			return convertToDto(convertToEntity);

		}
		return null;

	}

	@Override
	public CollegeDetailsDTO getCollegeDetailsById(int collegeId) {
		log.info("Fetching College Detail with id :"+collegeId);
		CollegeDetails collegeDetails = collegeRepository.findById(collegeId)
				.orElseThrow(() -> new ResourceNotFoundException("detail not found with id :" + collegeId));
		return convertToDto(collegeDetails);
	}

	@Override
	public List<CollegeDetailsDTO> getAllCollegeDetails() {
		log.info("Fetching All College Details");
		List<CollegeDetails> allCollegeDetails = collegeRepository.findAll();
		return allCollegeDetails.stream().map(collegeDetails -> mapper.map(collegeDetails, CollegeDetailsDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CollegeDetailsDTO updateCollegeDetailsById(CollegeDetailsDTO collegeDetailsDTO, int collegeId) {
		log.info("Updating College Detail with id :"+collegeId);
		 collegeRepository.findById(collegeId)
				.orElseThrow(() -> new ResourceNotFoundException("Detail not found with id :" + collegeId));
		CollegeDetails convertToEntity = convertToEntity(collegeDetailsDTO);
		 collegeRepository.save(convertToEntity);
		 return convertToDto(convertToEntity);
		 
	}

	@Override
	public void deleteCollegeDetailsById(int collegeId) {
		log.info("Deleting College Detail with ID : "+collegeId);
		CollegeDetails collegeDetails = collegeRepository.findById(collegeId)
				.orElseThrow(() -> new ResourceNotFoundException("Detail not found with id :" + collegeId));
		collegeRepository.delete(collegeDetails);
	}
	
	
	
	
}
