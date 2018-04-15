package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Grow;
import br.com.esndev.plants.filter.GrowFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface GrowRepository extends BaseRepository<Grow, GrowFilter> {

	@Query("select s from Grow s where (:#{#filter.name} is null or UPPER(s.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%')))")
	Page<Grow> findByFilter(@Param("filter") GrowFilter filter, Pageable pageable);

}