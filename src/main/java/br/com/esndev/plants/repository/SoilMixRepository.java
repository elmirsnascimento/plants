package br.com.esndev.plants.repository;

import java.util.List;
import java.util.Optional;

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
			+ " AND (:#{#filter.id} is null or sm.id = :#{#filter.id} ) "
			+ " AND (:#{#filter.idUser} is null or u.id = :#{#filter.idUser} ) "
			+ " AND (:#{#filter.nameUser} is null or UPPER(u.name) LIKE UPPER(CONCAT('%', :#{#filter.nameUser}, '%'))) "
			+ " AND (:#{#filter.mostSuitableStages} is null or sm.mostSuitableStage IN (:#{#filter.mostSuitableStages})) "
			+ " AND (:#{#filter.soilIngredients} is null or ic.soilIngredient IN (:#{#filter.soilIngredients})) ")
	Optional<List<SoilMix>> findByFilter(@Param("filter") SoilMixFilter filter);
	
	@Query("select distinct sm from SoilMix sm " + " join sm.user u " + " join sm.ingredientConcentrations ic "
			+ " where "
			+ " (:#{#filter.name} is null or UPPER(sm.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) "
			+ " AND (:#{#filter.idUser} is null or u.id = :#{#filter.idUser} ) "
			+ " AND (:#{#filter.nameUser} is null or UPPER(u.name) LIKE UPPER(CONCAT('%', :#{#filter.nameUser}, '%'))) "
			+ " AND (:#{#filter.mostSuitableStages} is null or sm.mostSuitableStage IN (:#{#filter.mostSuitableStages})) "
			+ " AND (:#{#filter.idsSoilIngredients} is null or ic.soilIngredient.id IN (:#{#filter.idsSoilIngredients})) ")
	Page<SoilMix> findByFilter(@Param("filter") SoilMixFilter filter, Pageable pageable);

}