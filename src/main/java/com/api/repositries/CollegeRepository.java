package com.api.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.models.CollegeDetails;

@Repository
public interface CollegeRepository extends JpaRepository<CollegeDetails, Integer> {

}
