package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Strain;
import br.com.esndev.plants.filter.StrainFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface StrainRepository extends BaseRepository<Strain, StrainFilter> {

	@Query("select s from Strain s where (:#{#filter.name} is null or UPPER(s.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%')))")
	Page<Strain> findByFilter(@Param("filter") StrainFilter filter, Pageable pageable);

}