package br.com.esndev.plants.repository;

import java.util.List;

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
			+ " AND ((:#{#filter.minHeight} is null or :#{#filter.maxHeight} is null) or s.expectedHeight BETWEEN :#{#filter.minHeight} and :#{#filter.maxHeight}) "
			+ " AND ((:#{#filter.minYield} is null or :#{#filter.maxYield} is null) or s.expectedYield BETWEEN :#{#filter.minYield} and :#{#filter.maxYield}) "
			+ " AND (:#{#filter.flowerings} is null or s.expectedFlowerWeeks IN :#{#filter.flowerings}) ")
	List<Strain> findByFilter(@Param("filter") StrainFilter filter);

}