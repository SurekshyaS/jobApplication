package com.surekshya.jobApplication.repository;

import com.surekshya.jobApplication.dto.response.ApplicantCountDto;
import com.surekshya.jobApplication.entity.Applicant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ApplicantRepository extends CrudRepository<Applicant, Integer>, PagingAndSortingRepository<Applicant, Integer> {

    @Query("SELECT a FROM Applicant a WHERE a.address.state = :state")
    List<Applicant> findApplicantsByState(@Param("state") String state);
}
