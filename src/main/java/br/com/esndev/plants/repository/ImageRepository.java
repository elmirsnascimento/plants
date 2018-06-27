package br.com.esndev.plants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Image;
import br.com.esndev.plants.filter.ImageFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface ImageRepository extends BaseRepository<Image, ImageFilter> {

	@Query("select i from Image i " + " join i.user u " + " where " + " u.id = :#{#filter.idElement} ")
	Page<Image> findByFilter(ImageFilter filter, Pageable pageable);

	@Query("select i from Image i " + " join i.user u " + " where " + " u.id = :#{#filter.idElement} ")
	Image findByUserId(@Param("filter") ImageFilter filter);

	@Query("select i from Image i " + " join i.fertilizer f " + " where " + " f.id = :#{#filter.idElement} ")
	Page<Image> findByFertilizerId(@Param("filter") ImageFilter filter, Pageable pageable);

	@Query("select i from Image i " + " join i.grow g " + " where " + " g.id = :#{#filter.idElement} ")
	Page<Image> findByGrowId(@Param("filter") ImageFilter filter, Pageable pageable);

	@Query("select i from Image i " + " join i.plant p " + " where " + " p.id = :#{#filter.idElement} ")
	Page<Image> findByPlantId(@Param("filter") ImageFilter filter, Pageable pageable);

	@Query("select i from Image i " + " join i.strain s " + " where " + " s.id = :#{#filter.idElement} ")
	Page<Image> findByStrainId(@Param("filter") ImageFilter filter, Pageable pageable);

	@Query("select i from Image i " + " join i.soilMix sm " + " where " + " sm.id = :#{#filter.idElement} ")
	Page<Image> findBySoilMixId(@Param("filter") ImageFilter filter, Pageable pageable);
}