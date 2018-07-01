package br.com.esndev.plants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Image;
import br.com.esndev.plants.filter.ImageFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface ImageRepository extends BaseRepository<Image, ImageFilter> {

	@Query("select i from Image i " + " join i.user u " + " where " + " u.id = :#{#filter.idElement} ")
	List<Image> findByFilter(ImageFilter filter);

	@Query("select i from Image i " + " join i.user u " + " where " + " u.id = :#{#filter.idElement} ")
	Image findByUserId(@Param("filter") ImageFilter filter);

	@Query("select i from Image i " + " join i.fertilizer f " + " where " + " f.id = :#{#filter.idElement} ")
	List<Image> findByFertilizerId(@Param("filter") ImageFilter filter);

	@Query("select i from Image i " + " join i.grow g " + " where " + " g.id = :#{#filter.idElement} ")
	List<Image> findByGrowId(@Param("filter") ImageFilter filter);

	@Query("select i from Image i " + " join i.plant p " + " where " + " p.id = :#{#filter.idElement} ")
	List<Image> findByPlantId(@Param("filter") ImageFilter filter);

	@Query("select i from Image i " + " join i.strain s " + " where " + " s.id = :#{#filter.idElement} ")
	List<Image> findByStrainId(@Param("filter") ImageFilter filter);

	@Query("select i from Image i " + " join i.soilMix sm " + " where " + " sm.id = :#{#filter.idElement} ")
	List<Image> findBySoilMixId(@Param("filter") ImageFilter filter);
}