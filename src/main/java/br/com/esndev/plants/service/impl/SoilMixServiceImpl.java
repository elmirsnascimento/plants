package br.com.esndev.plants.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.SoilMix;
import br.com.esndev.plants.filter.SoilMixFilter;
import br.com.esndev.plants.repository.SoilMixRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class SoilMixServiceImpl extends BaseServiceImpl<SoilMix, SoilMixFilter, SoilMixRepository> {

	public Optional<List<SoilMix>> findByFilter(SoilMixFilter filter) {
		return (Optional<List<SoilMix>>) repository.findByFilter(filter);
	}
}
