package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Plant;
import br.com.esndev.plants.filter.PlantFilter;
import br.com.esndev.plants.repository.PlantRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class PlantServiceImpl extends BaseServiceImpl<Plant, PlantFilter, PlantRepository> {
	public int getDaysToFlowering(Long idPlant) {
		return this.repository.getDaysToFlowering(idPlant);
	}

	public int getDaysToHarvest(Long idPlant) {
		return this.repository.getDaysToHarvest(idPlant);
	}
}
