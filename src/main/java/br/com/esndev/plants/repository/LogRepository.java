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

	@Query("select l from Log l where (:#{#filter.description} is null or UPPER(l.description) LIKE UPPER(CONCAT('%', :#{#filter.description}, '%')))")
	Page<Log> findByFilter(@Param("filter") LogFilter filter, Pageable pageable);
}