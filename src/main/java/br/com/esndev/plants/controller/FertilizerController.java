package br.com.esndev.plants.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Fertilizer;
import br.com.esndev.plants.filter.FertilizerFilter;
import br.com.esndev.plants.service.impl.FertilizerServiceImpl;

@RestController
@RequestMapping("/plants/fertilizer")
public class FertilizerController extends BaseController<Fertilizer, FertilizerFilter, FertilizerServiceImpl> {

	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody Fertilizer entity) {
		if (entity.getName() != null) {
			entity.setName(entity.getName().toUpperCase());
		}
		return super.create(entity);
	}

	@Override
	@PostMapping({ "/many" })
	public ResponseEntity<Object> createMany(@RequestBody List<Fertilizer> entities) {
		entities.forEach(entity -> {
			if (entity.getName() != null) {
				entity.setName(entity.getName().toUpperCase());
			}
		});
		return super.createMany(entities);
	}
}
