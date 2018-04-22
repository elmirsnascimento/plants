package br.com.esndev.plants.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Grow;
import br.com.esndev.plants.filter.GrowFilter;
import br.com.esndev.plants.service.impl.GrowServiceImpl;

@RestController
@RequestMapping("/plants/grow")
public class GrowController extends BaseController<Grow, GrowFilter, GrowServiceImpl> {

}
