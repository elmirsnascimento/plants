package br.com.esndev.plants.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.IngredientConcentration;
import br.com.esndev.plants.filter.IngredientConcentrationFilter;
import br.com.esndev.plants.repository.IngredientConcentrationRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class IngredientConcentrationServiceImpl extends
		BaseServiceImpl<IngredientConcentration, IngredientConcentrationFilter, IngredientConcentrationRepository> {

	public boolean isSoilMixCompleted(Set<IngredientConcentration> ingredientConcentrations) {
		int total = ingredientConcentrations.stream()
				.mapToInt(ingredientConcentration -> ingredientConcentration.getConcentration()).sum();
		if (total == 100) {
			return true;
		}
		return false;
	}
}
