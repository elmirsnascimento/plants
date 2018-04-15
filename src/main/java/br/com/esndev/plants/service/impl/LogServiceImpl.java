package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.Log;
import br.com.esndev.plants.filter.LogFilter;
import br.com.esndev.plants.repository.LogRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class LogServiceImpl extends BaseServiceImpl<Log, LogFilter, LogRepository> {

}
