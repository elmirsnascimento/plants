package br.com.esndev.plants.service.impl;

import org.springframework.stereotype.Service;

import br.com.esndev.plants.entity.User;
import br.com.esndev.plants.filter.UserFilter;
import br.com.esndev.plants.repository.UserRepository;
import br.com.esndev.plants.service.impl.base.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserFilter, UserRepository> {

}
