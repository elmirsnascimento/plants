package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Grow;
import br.com.esndev.plants.filter.GrowFilter;
import br.com.esndev.plants.repository.GrowRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class GrowServiceImpl extends BaseServiceImpl<Grow, GrowFilter, GrowRepository> {

}
