package br.com.esndev.plants.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Log;
import br.com.esndev.plants.exception.impl.ServiceException;
import br.com.esndev.plants.filter.LogFilter;
import br.com.esndev.plants.service.impl.LogServiceImpl;

@RestController
@RequestMapping("/plants/log")
public class LogController extends BaseController<Log, LogFilter, LogServiceImpl> {

	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody Log entity) {
		if (entity.getDescription() != null) {
			entity.setDescription(entity.getDescription().toUpperCase());
		}
		entity.setWatering(this.getService().getWateringService().generateWateringForLog(entity));
		return super.create(entity);
	}

	@PostMapping({ "/replicate" })
	public ResponseEntity<Object> replicate(@RequestBody Log entity) {
		try {
			return super.createMany(this.getService().replicate(entity));
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
