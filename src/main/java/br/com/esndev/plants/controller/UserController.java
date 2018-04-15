package br.com.esndev.plants.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esndev.plants.controller.base.BaseController;
import br.com.esndev.plants.entity.User;
import br.com.esndev.plants.filter.UserFilter;

@RestController
@RequestMapping("/plants/user")
public class UserController extends BaseController<User, UserFilter> {

}