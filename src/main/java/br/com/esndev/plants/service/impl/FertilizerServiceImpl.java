package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Fertilizer;
import br.com.esndev.plants.filter.FertilizerFilter;
import br.com.esndev.plants.repository.FertilizerRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class FertilizerServiceImpl extends BaseServiceImpl<Fertilizer, FertilizerFilter, FertilizerRepository> {

}
