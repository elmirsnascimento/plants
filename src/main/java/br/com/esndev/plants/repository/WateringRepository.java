package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Watering;
import br.com.esndev.plants.filter.WateringFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface WateringRepository extends BaseRepository<Watering, WateringFilter> {

	@Query("select w from Watering w " + " join w.log l " + " join w.fertilizers f " + " where "
			+ " (:#{#filter.idLog} is null or l.id = :#{#filter.idLog} ) "
			+ " AND (:#{#filter.idsFertilizers} is null or f.id IN :#{#filter.idsFertilizers}) "
			+ " AND (:#{#filter.skip} is null or (:#{#filter.skip} is true and w.skip is true )"
			+ " or (:#{#filter.skip} is false and w.skip is false )) ")
	Page<Watering> findByFilter(@Param("filter") WateringFilter filter, Pageable pageable);
}