package br.com.esndev.plants.controller;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Image;
import br.com.esndev.plants.filter.ImageFilter;
import br.com.esndev.plants.service.impl.ImageServiceImpl;

@RestController
@RequestMapping("/plants/image")
public class ImageController extends BaseController<Image, ImageFilter, ImageServiceImpl> {

	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody Image entity) {
		if (entity.getName() != null) {
			entity.setName(entity.getName().toUpperCase());
		}
		entity.setRegistrationDate(new Date());
		return super.create(entity);
	}

	@Override
	@PostMapping({ "/many" })
	public ResponseEntity<Object> createMany(@RequestBody List<Image> entities) {
		entities.forEach(entity -> {
			if (entity.getName() != null) {
				entity.setName(entity.getName().toUpperCase());
			}
			entity.setRegistrationDate(new Date());
		});
		return super.createMany(entities);
	}

	@PostMapping(value = "/findByUserId")
	public Image findByUserId(@RequestBody ImageFilter filter) {
		return getService().findByUserId(filter);
	}

	@Override
	@PostMapping(value = "/find")
	public Page<Image> findByFilter(@RequestBody ImageFilter filter, @PageableDefault(size = 5) Pageable pageable) {
		if (filter.isFertilizerElement()) {
			return getService().findByFertilizerId(filter, pageable);
		} else if (filter.isGrowElement()) {
			return getService().findByGrowId(filter, pageable);
		} else if (filter.isPlantElement()) {
			return getService().findByPlantId(filter, pageable);
		} else if (filter.isStrainElement()) {
			return getService().findByStrainId(filter, pageable);
		} else {
			return getService().findBySoilMixId(filter, pageable);
		}
	}
}
