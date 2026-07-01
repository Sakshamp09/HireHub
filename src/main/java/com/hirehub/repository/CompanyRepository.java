package com.hirehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirehub.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}