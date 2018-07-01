package br.com.esndev.plants.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.SoilMix;
import br.com.esndev.plants.filter.SoilMixFilter;
import br.com.esndev.plants.repository.SoilMixRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class SoilMixServiceImpl extends BaseServiceImpl<SoilMix, SoilMixFilter, SoilMixRepository> {

	public List<SoilMix> findByFilter(SoilMixFilter filter) {
		return (List<SoilMix>) repository.findByFilter(filter);
	}
}
