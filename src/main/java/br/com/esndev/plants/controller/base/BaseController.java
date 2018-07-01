package br.com.esndev.plants.controller.base;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.service.base.BaseService;

public class BaseController<E extends BaseEntity, F, S extends BaseService<E, F>> {

	@Autowired
	private BaseService<E, F> service;

	@GetMapping(value = "/{id}")
	public Optional<E> findById(@PathVariable(value = "id") Long id) {
		return getService().findById(id);
	}

	@PostMapping(value = "/find")
	public ResponseEntity<Object> findByFilter(@RequestBody F filter) {
		return ResponseEntity.accepted().body(getService().findByFilter(filter));
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody @Valid E entity) {
		try {
			return ResponseEntity.accepted().body(getService().save(entity));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
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

	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid E entity) {
		Optional<E> optionalEntity = getService().findById(id);

		if (!optionalEntity.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		if (entity.equalsValidationForUpdate(optionalEntity.get())) {
			return ResponseEntity.badRequest().body("Nothing changed");
		}
		try {
			return ResponseEntity.accepted().body(getService().save(entity));
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
		Optional<E> optionalEntity = getService().findById(id);

		if (!optionalEntity.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		getService().deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

	@SuppressWarnings("unchecked")
	public S getService() {
		return (S) service;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		return ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.toList());
	}

}
