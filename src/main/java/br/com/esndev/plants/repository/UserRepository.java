package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.User;
import br.com.esndev.plants.filter.UserFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User, UserFilter> {

	@Query("select u from User u where (:#{#filter.name} is null or UPPER(u.name) LIKE UPPER(CONCAT('%', :#{#filter.name}, '%')))")
	Page<User> findByFilter(@Param("filter") UserFilter filter, Pageable pageable);

}