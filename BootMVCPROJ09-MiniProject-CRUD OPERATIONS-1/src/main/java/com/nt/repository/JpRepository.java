package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.EmployeeEntiity;

public interface JpRepository extends JpaRepository<EmployeeEntiity, Integer> {

}
