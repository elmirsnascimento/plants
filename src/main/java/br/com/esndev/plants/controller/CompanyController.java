package br.com.esndev.plants.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Company;
import br.com.esndev.plants.filter.CompanyFilter;
import br.com.esndev.plants.service.impl.CompanyServiceImpl;

@RestController
@RequestMapping("/plants/company")
public class CompanyController extends BaseController<Company, CompanyFilter, CompanyServiceImpl> {

	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody @Valid Company entity) {
		if (entity.getName() != null) {
			entity.setName(entity.getName().toUpperCase());
		}
		return super.create(entity);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid Company entity) {
		if (!getService().findByNameAndIdNot(entity.getName(), entity.getId()).isEmpty()) {
			return ResponseEntity.badRequest().body("Company name is taken.");
		}
		return super.update(id, entity);
	}
}
