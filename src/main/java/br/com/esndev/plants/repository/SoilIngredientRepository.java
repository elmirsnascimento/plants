package br.com.esndev.plants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.SoilIngredient;
import br.com.esndev.plants.filter.SoilIngredientFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface SoilIngredientRepository extends BaseRepository<SoilIngredient, SoilIngredientFilter> {

	@Query("select si from SoilIngredient si where "
			+ " (:#{#filter.name} is null or UPPER(si.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) ")
	List<SoilIngredient> findByFilter(@Param("filter") SoilIngredientFilter filter);

}