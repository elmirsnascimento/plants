package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Fertilizer;
import br.com.esndev.plants.filter.FertilizerFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface FertilizerRepository extends BaseRepository<Fertilizer, FertilizerFilter> {

	@Query("select distinct f from Fertilizer f " + " left join f.soilIngredients si " + " left join f.company c "
			+ " left join f.user u " + " where "
			+ " (:#{#filter.name} is null or UPPER(f.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) ")
	Page<Fertilizer> findByFilter(@Param("filter") FertilizerFilter filter, Pageable pageable);

}