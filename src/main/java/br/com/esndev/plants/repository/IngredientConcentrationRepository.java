package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.IngredientConcentration;
import br.com.esndev.plants.filter.IngredientConcentrationFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface IngredientConcentrationRepository
		extends BaseRepository<IngredientConcentration, IngredientConcentrationFilter> {

	@Query("select ic from IngredientConcentration ic where "
			+ " (:#{#filter.idsSoilIngredients} is null or UPPER(ic.soilIngredient.id) IN (:#{#filter.idsSoilIngredients})) ")
	Page<IngredientConcentration> findByFilter(@Param("filter") IngredientConcentrationFilter filter,
			Pageable pageable);

}