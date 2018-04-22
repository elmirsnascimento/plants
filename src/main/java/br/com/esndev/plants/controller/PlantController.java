package br.com.esndev.plants.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Plant;
import br.com.esndev.plants.filter.PlantFilter;
import br.com.esndev.plants.service.impl.PlantServiceImpl;

@RestController
@RequestMapping("/plants/plant")
public class PlantController extends BaseController<Plant, PlantFilter, PlantServiceImpl> {

}
