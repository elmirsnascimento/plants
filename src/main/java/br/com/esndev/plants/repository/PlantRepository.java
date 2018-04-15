package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Plant;
import br.com.esndev.plants.filter.PlantFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface PlantRepository extends BaseRepository<Plant, PlantFilter> {

	@Query("select p from Plant p where (:#{#filter.name} is null or UPPER(p.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%')))")
	Page<Plant> findByFilter(@Param("filter") PlantFilter filter, Pageable pageable);
}