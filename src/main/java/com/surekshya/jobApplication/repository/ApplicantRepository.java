package com.surekshya.jobApplication.repository;

import com.surekshya.jobApplication.entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ApplicantRepository extends CrudRepository<Applicant, Integer>, PagingAndSortingRepository<Applicant, Integer> {

}
