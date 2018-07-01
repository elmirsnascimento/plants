package br.com.esndev.plants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Company;
import br.com.esndev.plants.filter.CompanyFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface CompanyRepository extends BaseRepository<Company, CompanyFilter> {

	@Query("select c from Company c where "
			+ " (:#{#filter.name} is null or UPPER(c.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%'))) ")
	List<Company> findByFilter(@Param("filter") CompanyFilter filter);

	List<Company> findByNameAndIdNot(String name, Long id);

}