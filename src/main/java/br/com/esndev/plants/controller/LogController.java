package br.com.esndev.plants.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.Log;
import br.com.esndev.plants.filter.LogFilter;

@RestController
@RequestMapping("/plants/log")
public class LogController extends BaseController<Log, LogFilter> {

}
