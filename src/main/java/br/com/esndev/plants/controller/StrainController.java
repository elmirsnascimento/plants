package br.com.esndev.plants.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Strain;
import br.com.esndev.plants.filter.StrainFilter;

@RestController
@RequestMapping("/plants/strain")
public class StrainController extends BaseController<Strain, StrainFilter> {

}
