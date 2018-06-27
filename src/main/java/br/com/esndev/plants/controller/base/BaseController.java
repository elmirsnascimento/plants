package br.com.esndev.plants.controller.base;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.service.base.BaseService;

public class BaseController<E extends BaseEntity, F, S extends BaseService<E, F>> {

	@Autowired
	private BaseService<E, F> service;

	@PostMapping(value = "/find")
	public Page<E> findByFilter(@RequestBody F filter, @PageableDefault(size = 5) Pageable pageable) {
		return getService().findByFilter(filter, pageable);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody @Valid E entity) {
		try {
			return ResponseEntity.accepted().body(getService().save(entity));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping(value = "/many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createMany(@RequestBody @Valid List<E> entities) {
		try {
			return ResponseEntity.accepted().body(getService().saveAll(entities));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid E entity) {
		Optional<E> optionalEntity = getService().findById(id);

		if (!optionalEntity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		try {
			return ResponseEntity.accepted().body(getService().save(entity));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
		Optional<E> optionalEntity = getService().findById(id);

		if (!optionalEntity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		getService().deleteById(id);
		return ResponseEntity.ok().build();
	}

	@SuppressWarnings("unchecked")
	public S getService() {
		return (S) service;
	}

}
