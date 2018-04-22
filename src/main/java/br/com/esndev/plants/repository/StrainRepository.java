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

	@Query("select s from Strain s where "
			+ " (:#{#filter.name} is null or UPPER(s.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) "
			+ " AND (:#{#filter.species} is null or s.specie IN (:#{#filter.species})) "
			+ " AND (:#{#filter.requiredExpertizes} is null or s.requiredExpertize IN :#{#filter.requiredExpertizes} ) "
			+ " AND (:#{#filter.heightes} is null or s.expectedHeight IN :#{#filter.heightes}) "
			+ " AND (:#{#filter.yields} is null or s.expectedYield IN :#{#filter.yields}) "
			+ " AND (:#{#filter.flowerings} is null or s.expectedFlowerWeeks IN :#{#filter.flowerings}) ")
	Page<Strain> findByFilter(@Param("filter") StrainFilter filter, Pageable pageable);

}