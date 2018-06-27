package br.com.esndev.plants.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Image;
import br.com.esndev.plants.filter.ImageFilter;
import br.com.esndev.plants.repository.ImageRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class ImageServiceImpl extends BaseServiceImpl<Image, ImageFilter, ImageRepository> {

	public Image findByUserId(ImageFilter filter) {
		return this.getRepository().findByUserId(filter);
	}

	public Page<Image> findByFertilizerId(ImageFilter filter, Pageable pageable) {
		return this.getRepository().findByFertilizerId(filter, pageable);
	}

	public Page<Image> findByGrowId(ImageFilter filter, Pageable pageable) {
		return this.getRepository().findByGrowId(filter, pageable);
	}

	public Page<Image> findByPlantId(ImageFilter filter, Pageable pageable) {
		return this.getRepository().findByPlantId(filter, pageable);
	}

	public Page<Image> findByStrainId(ImageFilter filter, Pageable pageable) {
		return this.getRepository().findByStrainId(filter, pageable);
	}

	public Page<Image> findBySoilMixId(ImageFilter filter, Pageable pageable) {
		return this.getRepository().findBySoilMixId(filter, pageable);
	}

}
