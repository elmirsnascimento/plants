package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Company;
import br.com.esndev.plants.filter.CompanyFilter;
import br.com.esndev.plants.repository.CompanyRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company, CompanyFilter, CompanyRepository> {

}
