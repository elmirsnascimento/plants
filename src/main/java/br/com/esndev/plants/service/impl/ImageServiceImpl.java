package br.com.esndev.plants.service.impl;

import java.util.List;

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

	public List<Image> findByFertilizerId(ImageFilter filter) {
		return this.getRepository().findByFertilizerId(filter);
	}

	public List<Image> findByGrowId(ImageFilter filter) {
		return this.getRepository().findByGrowId(filter);
	}

	public List<Image> findByPlantId(ImageFilter filter) {
		return this.getRepository().findByPlantId(filter);
	}

	public List<Image> findByStrainId(ImageFilter filter) {
		return this.getRepository().findByStrainId(filter);
	}

	public List<Image> findBySoilMixId(ImageFilter filter) {
		return this.getRepository().findBySoilMixId(filter);
	}

}
