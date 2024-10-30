package com.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDetailsDTO {

	private int collegeId;

	private String collegeName;

	private String collegeAddress;
}
