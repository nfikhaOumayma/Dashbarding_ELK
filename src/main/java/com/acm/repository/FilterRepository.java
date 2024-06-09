package com.acm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.entity.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {

}
