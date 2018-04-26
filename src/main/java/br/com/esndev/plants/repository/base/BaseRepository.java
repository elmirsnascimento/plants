package br.com.esndev.plants.repository.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E, F> extends JpaRepository<E, Long> {
	
	Page<E> findByFilter(F filter, Pageable pageable);

}
