package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.SoilIngredient;
import br.com.esndev.plants.filter.SoilIngredientFilter;
import br.com.esndev.plants.repository.SoilIngredientRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class SoilIngredientServiceImpl extends BaseServiceImpl<SoilIngredient, SoilIngredientFilter, SoilIngredientRepository> {

}
