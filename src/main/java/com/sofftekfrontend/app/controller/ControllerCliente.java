package com.sofftekfrontend.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Cliente;
import com.sofftekfrontend.app.models.Rol;
import com.sofftekfrontend.app.service.ServiceCliente;

@RestController
public class ControllerCliente {
	
	@Autowired
	ServiceCliente service;
	@PostMapping("/usuario/registrar")
	public Cliente registerClient(@RequestBody Cliente c) {
		c.setRol(Rol.USUARIO);
		return service.save(c);
	}
	@GetMapping("/usuario/cliente")
	public List<Cliente> findAll() {
		return service.findAll();
	}
}
