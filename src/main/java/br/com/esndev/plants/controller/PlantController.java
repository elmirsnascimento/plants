package br.com.esndev.plants.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Plant;
import br.com.esndev.plants.filter.PlantFilter;
import br.com.esndev.plants.service.impl.PlantServiceImpl;

@RestController
@RequestMapping("/plants/plant")
public class PlantController extends BaseController<Plant, PlantFilter, PlantServiceImpl> {

	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody Plant entity) {
		if (entity.getName() != null) {
			entity.setName(entity.getName().toUpperCase());
		}
		entity.setRegistrationDate(new Date());
		return super.create(entity);
	}

	@Override
	@PostMapping({ "/many" })
	public ResponseEntity<Object> createMany(@RequestBody List<Plant> entities) {
		entities.forEach(entity -> {
			if (entity.getName() != null) {
				entity.setName(entity.getName().toUpperCase());
			}
			entity.setRegistrationDate(new Date());
		});
		return super.createMany(entities);
	}
}
