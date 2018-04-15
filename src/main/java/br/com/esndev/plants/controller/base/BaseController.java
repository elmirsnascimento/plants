package br.com.esndev.plants.controller.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.service.base.BaseService;
import lombok.Data;

@Data
public class BaseController<E extends BaseEntity, F> {

	@Autowired
	private BaseService<E, F> service;

	@RequestMapping(value = "/findByFilter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<E> findByFilter(@RequestBody F filter, @PageableDefault(size = 5) Pageable pageable) {
		return getService().findByFilter(filter, pageable);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody E entity) {
		try {
			return ResponseEntity.accepted().body(getService().save(entity));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/createMany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createMany(@RequestBody List<E> entities) {
		try {
			return ResponseEntity.accepted().body(getService().saveAll(entities));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody E entity) {
		Optional<E> optionalEntity = getService().findById(entity.getId());

		if (!optionalEntity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		try {
			return ResponseEntity.accepted().body(getService().save(entity));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@DeleteMapping("/deleteById")
	public ResponseEntity<Object> deleteById(@RequestBody E entity) {
		Optional<E> optionalEntity = getService().findById(entity.getId());

		if (!optionalEntity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		getService().deleteById(entity.getId());
		return ResponseEntity.ok().build();
	}

}
