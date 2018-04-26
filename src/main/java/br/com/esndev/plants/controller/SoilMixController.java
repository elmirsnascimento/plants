package br.com.esndev.plants.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.SoilMix;
import br.com.esndev.plants.filter.SoilMixFilter;
import br.com.esndev.plants.service.impl.SoilMixServiceImpl;

@RestController
@RequestMapping("/plants/soilmix")
public class SoilMixController extends BaseController<SoilMix, SoilMixFilter, SoilMixServiceImpl> {

	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody SoilMix entity) {
		if (entity.getName() != null) {
			entity.setName(entity.getName().toUpperCase());
		}
		entity.setRegistrationDate(new Date());
		return super.create(entity);
	}

	@Override
	@PostMapping({ "/many" })
	public ResponseEntity<Object> createMany(@RequestBody List<SoilMix> entities) {
		entities.forEach(entity -> {
			if (entity.getName() != null) {
				entity.setName(entity.getName().toUpperCase());
			}
			entity.setRegistrationDate(new Date());
		});
		return super.createMany(entities);
	}

	@DeleteMapping(value = "/{userId}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id,
			@PathVariable(value = "userId") Long userId) {
		SoilMixFilter filter = new SoilMixFilter();
		filter.setId(id);
		filter.setUserId(userId);
		Optional<List<SoilMix>> optionalEntities = getService().findByFilter(filter);

		if (!optionalEntities.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		getService().deleteById(id);
		return ResponseEntity.ok().build();
	}
}
