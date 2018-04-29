package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Log;
import br.com.esndev.plants.filter.LogFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface LogRepository extends BaseRepository<Log, LogFilter> {

	@Query("select l from Log l " + " join l.plant p" + " join p.grow g" + " where "
			+ " (:#{#filter.description} is null or UPPER(l.description) LIKE UPPER(CONCAT('%', :#{#filter.description}, '%'))) "
			+ " AND (:#{#filter.idPlant} is null or p.id = :#{#filter.idPlant} ) "
			+ " AND (:#{#filter.idGrow} is null or g.id = :#{#filter.idGrow} ) "
			+ " AND (:#{#filter.attended} is null or (:#{#filter.attended} is true and l.logDate < SYSDATE )"
			+ " or (:#{#filter.attended} is false and l.logDate > SYSDATE )) "
			+ " AND (:#{#filter.registrationDate} is null or l.registrationDate = :#{#filter.registrationDate} ) "
			+ " AND (:#{#filter.stages} is null or l.stage IN :#{#filter.stages}) ")
	Page<Log> findByFilter(@Param("filter") LogFilter filter, Pageable pageable);
}