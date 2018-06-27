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
	public Page<Comment> findByFilter(@RequestBody CommentFilter filter, @PageableDefault(size = 5) Pageable pageable) {
		if (filter.isUserElement()) {
			return getService().findByUserId(filter, pageable);
		} else if (filter.isFertilizerElement()) {
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
