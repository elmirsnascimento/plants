package br.com.esndev.plants.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Log;
import br.com.esndev.plants.entity.Watering;
import br.com.esndev.plants.filter.WateringFilter;
import br.com.esndev.plants.repository.WateringRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class WateringServiceImpl extends BaseServiceImpl<Watering, WateringFilter, WateringRepository> {

	public Watering generateWateringForLog(Log log) {
		Watering watering = new Watering();
		watering.setPh(log.getPh());
		watering.setEc(log.getEc());
		watering.setRegistrationDate(new Date());
		watering.setWateringDate(log.getLogDate());
		watering.setSkip(false);
		return watering;
	}
}
