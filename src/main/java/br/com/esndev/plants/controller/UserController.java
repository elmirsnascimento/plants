package br.com.esndev.plants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.User;
import br.com.esndev.plants.filter.UserFilter;
import br.com.esndev.plants.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/plants/user")
public class UserController extends BaseController<User, UserFilter, UserServiceImpl> {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@PostMapping({ "/" })
	public ResponseEntity<Object> create(@RequestBody User entity) {
		if (entity.getName() != null)
			entity.setName(entity.getName().toUpperCase());
		if (entity.getEmail() != null)
			entity.setEmail(entity.getEmail().toUpperCase());
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return super.create(entity);
	}

	@Override
	@PostMapping({ "/many" })
	public ResponseEntity<Object> createMany(@RequestBody List<User> entities) {
		entities.forEach(entity -> {
			entity.setName(entity.getName().toUpperCase());
			entity.setEmail(entity.getEmail().toUpperCase());
			entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		});
		return super.createMany(entities);
	}
}
