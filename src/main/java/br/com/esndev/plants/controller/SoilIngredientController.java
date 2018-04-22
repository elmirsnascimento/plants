package br.com.esndev.plants.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.SoilIngredient;
import br.com.esndev.plants.filter.SoilIngredientFilter;
import br.com.esndev.plants.service.impl.SoilIngredientServiceImpl;

@RestController
@RequestMapping("/plants/soilingredient")
public class SoilIngredientController extends BaseController<SoilIngredient, SoilIngredientFilter, SoilIngredientServiceImpl> {

	
	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody SoilIngredient entity) {
		if (entity.getName() != null)
			entity.setName(entity.getName().toUpperCase());
		return super.create(entity);
	}

	@Override
	@PostMapping({ "/many" })
	public ResponseEntity<Object> createMany(@RequestBody List<SoilIngredient> entities) {
		entities.forEach(entity -> {
			entity.setName(entity.getName().toUpperCase());
		});
		return super.createMany(entities);
	}
}
