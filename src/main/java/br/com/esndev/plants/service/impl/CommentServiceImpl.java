package br.com.esndev.plants.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Comment;
import br.com.esndev.plants.filter.CommentFilter;
import br.com.esndev.plants.repository.CommentRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentFilter, CommentRepository> {

	public Page<Comment> findByUserId(CommentFilter filter, Pageable pageable) {
		return this.getRepository().findByUserId(filter, pageable);
	}

	public Page<Comment> findByFertilizerId(CommentFilter filter, Pageable pageable) {
		return this.getRepository().findByFertilizerId(filter, pageable);
	}

	public Page<Comment> findByGrowId(CommentFilter filter, Pageable pageable) {
		return this.getRepository().findByGrowId(filter, pageable);
	}

	public Page<Comment> findByPlantId(CommentFilter filter, Pageable pageable) {
		return this.getRepository().findByPlantId(filter, pageable);
	}

	public Page<Comment> findByStrainId(CommentFilter filter, Pageable pageable) {
		return this.getRepository().findByStrainId(filter, pageable);
	}

	public Page<Comment> findBySoilMixId(CommentFilter filter, Pageable pageable) {
		return this.getRepository().findBySoilMixId(filter, pageable);
	}
}
