package com.Noam.CouponsSystem_part2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Noam.CouponsSystem_part2.beans.Company;
import com.Noam.CouponsSystem_part2.repo.CompanyRepository;

@Service
public class CompaniesService {

	@Autowired
	private CompanyRepository repo;

	public void addCompany(Company company) {
		repo.save(company);
	}

	public void updateCompany(Company company) {
		repo.saveAndFlush(company);
	}

	public void deleteCompany(Company company) {
		repo.delete(company);
	}

	public List<Company> getAllCompanies() {
		return repo.findAll();
	}

	public Company getOneCompany(int id) {
		return repo.getOne(id);
	}

	public boolean isCompanyExist(String email, String password) {
		return (repo.findByEmailAndPassword(email, password)!= null);
	}

}
