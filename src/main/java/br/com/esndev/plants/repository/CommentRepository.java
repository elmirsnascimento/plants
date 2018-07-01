package br.com.esndev.plants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.esndev.plants.entity.Comment;
import br.com.esndev.plants.filter.CommentFilter;
import br.com.esndev.plants.repository.base.BaseRepository;

@Repository
public interface CommentRepository extends BaseRepository<Comment, CommentFilter> {

	@Query("select cm from Comment cm " + " join cm.user u " + " where " + " u.id = :#{#filter.idElement} ")
	List<Comment> findByFilter(CommentFilter filter);

	@Query("select cm from Comment cm " + " join cm.user u " + " where " + " u.id = :#{#filter.idElement} ")
	List<Comment> findByUserId(@Param("filter") CommentFilter filter);

	@Query("select cm from Comment cm " + " join cm.fertilizer f " + " where " + " f.id = :#{#filter.idElement} ")
	List<Comment> findByFertilizerId(@Param("filter") CommentFilter filter);

	@Query("select cm from Comment cm " + " join cm.grow g " + " where " + " g.id = :#{#filter.idElement} ")
	List<Comment> findByGrowId(@Param("filter") CommentFilter filter);

	@Query("select cm from Comment cm " + " join cm.plant p " + " where " + " p.id = :#{#filter.idElement} ")
	List<Comment> findByPlantId(@Param("filter") CommentFilter filter);

	@Query("select cm from Comment cm " + " join cm.strain s " + " where " + " s.id = :#{#filter.idElement} ")
	List<Comment> findByStrainId(@Param("filter") CommentFilter filter);

	@Query("select cm from Comment cm " + " join cm.soilMix sm " + " where " + " sm.id = :#{#filter.idElement} ")
	List<Comment> findBySoilMixId(@Param("filter") CommentFilter filter);
}