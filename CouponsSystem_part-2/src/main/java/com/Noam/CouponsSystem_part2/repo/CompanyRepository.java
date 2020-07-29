package com.Noam.CouponsSystem_part2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Noam.CouponsSystem_part2.beans.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	public Company findByEmailAndPassword(String email, String password);
}
