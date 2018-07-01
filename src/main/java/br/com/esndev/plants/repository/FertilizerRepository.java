package br.com.esndev.plants.repository;

import java.util.List;

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
			+ " (:#{#filter.name} is null or UPPER(f.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) "
			+ " AND ((:#{#filter.minNitrogenRatio} is null or :#{#filter.maxNitrogenRatio} is null) or (f.nitrogenRatio BETWEEN :#{#filter.minNitrogenRatio} and :#{#filter.maxNitrogenRatio})) "
			+ " AND ((:#{#filter.minPotassiumRatio} is null or :#{#filter.maxPotassiumRatio} is null) or (f.potassiumRatio BETWEEN :#{#filter.minPotassiumRatio} and :#{#filter.maxPotassiumRatio})) "
			+ " AND ((:#{#filter.minPhosphorusRatio} is null or :#{#filter.maxPhosphorusRatio} is null) or (f.phosphorusRatio BETWEEN :#{#filter.minPhosphorusRatio} and :#{#filter.maxPhosphorusRatio})) ")
	List<Fertilizer> findByFilter(@Param("filter") FertilizerFilter filter);

}