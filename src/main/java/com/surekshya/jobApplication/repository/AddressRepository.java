package com.surekshya.jobApplication.repository;

import com.surekshya.jobApplication.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>, PagingAndSortingRepository<Address, Integer> {
}
