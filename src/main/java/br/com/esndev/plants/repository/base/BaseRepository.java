package br.com.esndev.plants.repository.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E, F> extends JpaRepository<E, Long> {

	List<E> findByFilter(F filter);

}
