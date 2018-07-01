package br.com.esndev.plants.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Comment;
import br.com.esndev.plants.filter.CommentFilter;
import br.com.esndev.plants.repository.CommentRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentFilter, CommentRepository> {

	public List<Comment> findByUserId(CommentFilter filter) {
		return this.getRepository().findByUserId(filter);
	}

	public List<Comment> findByFertilizerId(CommentFilter filter) {
		return this.getRepository().findByFertilizerId(filter);
	}

	public List<Comment> findByGrowId(CommentFilter filter) {
		return this.getRepository().findByGrowId(filter);
	}

	public List<Comment> findByPlantId(CommentFilter filter) {
		return this.getRepository().findByPlantId(filter);
	}

	public List<Comment> findByStrainId(CommentFilter filter) {
		return this.getRepository().findByStrainId(filter);
	}

	public List<Comment> findBySoilMixId(CommentFilter filter) {
		return this.getRepository().findBySoilMixId(filter);
	}
}
