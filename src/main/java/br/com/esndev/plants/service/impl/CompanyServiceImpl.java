package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.esndev.plants.entity.Company;
import br.com.esndev.plants.filter.CompanyFilter;
import br.com.esndev.plants.repository.CompanyRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
@Transactional
public class CompanyServiceImpl extends BaseServiceImpl<Company, CompanyFilter, CompanyRepository> {

	public CompanyServiceImpl(CompanyRepository repository) {
		this.repository = repository;
	}
}
