package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.SoilMix;
import br.com.esndev.plants.filter.SoilMixFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface SoilMixRepository extends BaseRepository<SoilMix, SoilMixFilter> {

	@Query("select distinct sm from SoilMix sm " + " join sm.user u " + " join sm.ingredientConcentrations ic "
			+ " where "
			+ " (:#{#filter.name} is null or UPPER(sm.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) "
			+ " AND (:#{#filter.userName} is null or UPPER(u.name) LIKE UPPER(CONCAT('%', :#{#filter.userName}, '%'))) "
			+ " AND (:#{#filter.mostSuitableStages} is null or sm.mostSuitableStage IN (:#{#filter.mostSuitableStages})) "
			+ " AND (:#{#filter.soilIngredients} is null or ic.soilIngredient IN (:#{#filter.soilIngredients})) ")
	Page<SoilMix> findByFilter(@Param("filter") SoilMixFilter filter, Pageable pageable);

}