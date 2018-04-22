package br.com.esndev.plants.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Strain;
import br.com.esndev.plants.filter.StrainFilter;
import br.com.esndev.plants.service.impl.StrainServiceImpl;

@RestController
@RequestMapping("/plants/strain")
public class StrainController extends BaseController<Strain, StrainFilter, StrainServiceImpl> {

	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody Strain entity) {
		if (entity.getName() != null) {
			entity.setName(entity.getName().toUpperCase());
		}
		entity.setSpecie(entity.getSpecie());
		entity.setRequiredExpertize(entity.getRequiredExpertize());
		entity.setExpectedHeight(entity.getExpectedHeight());
		entity.setExpectedYield(entity.getExpectedYield());
		entity.setExpectedFlowerWeeks(entity.getExpectedFlowerWeeks());
		return super.create(entity);
	}

	@Override
	@PostMapping({ "/many" })
	public ResponseEntity<Object> createMany(@RequestBody List<Strain> entities) {
		entities.forEach(entity -> {
			entity.setSpecie(entity.getSpecie());
			entity.setRequiredExpertize(entity.getRequiredExpertize());
			entity.setExpectedHeight(entity.getExpectedHeight());
			entity.setExpectedYield(entity.getExpectedYield());
			entity.setExpectedFlowerWeeks(entity.getExpectedFlowerWeeks());
		});
		return super.createMany(entities);
	}
}
