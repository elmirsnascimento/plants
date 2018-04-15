package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Strain;
import br.com.esndev.plants.filter.StrainFilter;
import br.com.esndev.plants.repository.StrainRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class StrainServiceImpl extends BaseServiceImpl<Strain, StrainFilter, StrainRepository> {

}
