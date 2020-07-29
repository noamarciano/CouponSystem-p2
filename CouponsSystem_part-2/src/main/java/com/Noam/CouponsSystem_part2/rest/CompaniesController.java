package com.Noam.CouponsSystem_part2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Noam.CouponsSystem_part2.beans.Company;
import com.Noam.CouponsSystem_part2.service.CompaniesService;

@RestController
@RequestMapping("company")
public class CompaniesController {

	@Autowired
	CompaniesService companiesService;

	@PostMapping("add")
	public ResponseEntity<?> addCompany(@RequestBody Company company) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("update")
	public ResponseEntity<?> updateCompany(Company company) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> deleteCompany(Company company) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("get-all")
	public ResponseEntity<?> getAllCompanies() {
		return new ResponseEntity<List<Company>>(companiesService.getAllCompanies(), HttpStatus.OK);
	}

	@GetMapping("get-one")
	public ResponseEntity<?> getOneCompany(int id) {
		return new ResponseEntity<Company>(companiesService.getOneCompany(id), HttpStatus.OK);
	}

}
