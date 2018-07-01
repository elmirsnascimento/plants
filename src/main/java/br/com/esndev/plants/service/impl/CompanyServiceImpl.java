package br.com.esndev.plants.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Company;
import br.com.esndev.plants.filter.CompanyFilter;
import br.com.esndev.plants.repository.CompanyRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company, CompanyFilter, CompanyRepository> {

	public List<Company> findByNameAndIdNot(String name, Long id) {
		return (List<Company>) getRepository().findByNameAndIdNot(name, id);
	}
}
