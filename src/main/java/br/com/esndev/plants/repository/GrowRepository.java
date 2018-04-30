package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Grow;
import br.com.esndev.plants.filter.GrowFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface GrowRepository extends BaseRepository<Grow, GrowFilter> {

	@Query("select g from Grow g " + " left join g.plants p " + " join p.strain s " + " join g.user u " + " where "
			+ " (:#{#filter.name} is null or UPPER(g.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) "
			+ " AND (:#{#filter.idPlant} is null or p.id = :#{#filter.idPlant}) "
			+ " AND (:#{#filter.idUser} is null or u.id = :#{#filter.idUser}) "
			+ " AND (:#{#filter.terminated} is null or (:#{#filter.terminated} is true and g.terminated = true)"
			+ " OR (:#{#filter.terminated} is false and g.terminated = false)) "
			+ " AND (:#{#filter.strains} is null or s.id IN :#{#filter.idsStrains}) ")
	Page<Grow> findByFilter(@Param("filter") GrowFilter filter, Pageable pageable);

}