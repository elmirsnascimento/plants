package br.com.esndev.plants.service.impl.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.repository.base.BaseRepository;
import br.com.esndev.plants.service.base.BaseService;

public class BaseServiceImpl<E extends BaseEntity, F, R extends BaseRepository<E, F>> implements BaseService<E, F> {

	@Autowired
	public R repository;

	@Override
	public List<E> findAll() {
		return (List<E>) repository.findAll();
	}

	@Override
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Page<E> findByFilter(F filter, Pageable pageable) {
		return (Page<E>) repository.findByFilter(filter, pageable);
	}

	@Override
	public void delete(E entity) {
		repository.delete(entity);

	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	@Override
	public E save(E entity) throws DataIntegrityViolationException {
		return repository.save(entity);
	}

	@Override
	public List<E> saveAll(List<E> entities) throws DataIntegrityViolationException {
		return repository.saveAll(entities);
	}

	@SuppressWarnings("unchecked")
	public List<E> replicate(E entity, int amoutOfTimesToReplicate) {
		List<E> replicas = new ArrayList<E>();
		try {
			for (int amout = 1; amout <= amoutOfTimesToReplicate; amout++) {
				replicas.add((E) entity.clone());
			}
		} catch (CloneNotSupportedException e) {
			throw new ServiceException("Impossible to replicate.");
		}
		return replicas;
	}

	public R getRepository() {
		return this.repository;
	}
}
