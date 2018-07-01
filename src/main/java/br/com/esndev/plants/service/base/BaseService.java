package br.com.esndev.plants.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<E, F> {
	List<E> findAll();

	Optional<E> findById(Long id);

	List<E> findByFilter(F filter);

	void delete(E entity);

	void deleteById(Long id);

	E save(E entity) throws DataIntegrityViolationException;

	List<E> saveAll(List<E> entities) throws DataIntegrityViolationException;

}
