package br.com.esndev.plants.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Comment;
import br.com.esndev.plants.filter.CommentFilter;
import br.com.esndev.plants.service.impl.CommentServiceImpl;

@RestController
@RequestMapping("/plants/comment")
public class CommentController extends BaseController<Comment, CommentFilter, CommentServiceImpl> {

	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody Comment entity) {
		entity.setRegistrationDate(new Date());
		return super.create(entity);
	}

	@Override
	@PostMapping({ "/many" })
	public ResponseEntity<Object> createMany(@RequestBody List<Comment> entities) {
		entities.forEach(entity -> {
			entity.setRegistrationDate(new Date());
		});
		return super.createMany(entities);
	}

	@Override
	@PostMapping(value = "/find")
	public ResponseEntity<Object> findByFilter(@RequestBody CommentFilter filter) {
		if (filter.isUserElement()) {
			return ResponseEntity.accepted().body(getService().findByUserId(filter));
		} else if (filter.isFertilizerElement()) {
			return ResponseEntity.accepted().body(getService().findByFertilizerId(filter));
		} else if (filter.isGrowElement()) {
			return ResponseEntity.accepted().body(getService().findByGrowId(filter));
		} else if (filter.isPlantElement()) {
			return ResponseEntity.accepted().body(getService().findByPlantId(filter));
		} else if (filter.isStrainElement()) {
			return ResponseEntity.accepted().body(getService().findByStrainId(filter));
		} else {
			return ResponseEntity.accepted().body(getService().findBySoilMixId(filter));
		}
	}
}
