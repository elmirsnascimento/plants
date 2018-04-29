package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Plant;
import br.com.esndev.plants.filter.PlantFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface PlantRepository extends BaseRepository<Plant, PlantFilter> {

	@Query("select p from Plant p " + " join p.strain s" + " join p.lastLog ll " + " where "
			+ " (:#{#filter.name} is null or UPPER(p.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) "
			+ " AND (:#{#filter.genders} is null or p.gender IN (:#{#filter.genders})) "
			+ " AND (:#{#filter.idsStrains} is null or s.id IN (:#{#filter.idsStrains})) "
			+ " AND (:#{#filter.weeksToLive} is null or p.weeksToLive = :#{#filter.weeksToLive} ) "
			+ " AND (:#{#filter.idGrow} is null or p.id = :#{#filter.idGrow}) "
			+ " AND (:#{#filter.stillAlive} is null or (:#{#filter.stillAlive} is false and ll.stage IN ('HARVEST', 'DRYING'))"
			+ " OR (:#{#filter.stillAlive} is true and ll.stage NOT IN ('HARVEST', 'DRYING'))) ")
	Page<Plant> findByFilter(@Param("filter") PlantFilter filter, Pageable pageable);
}