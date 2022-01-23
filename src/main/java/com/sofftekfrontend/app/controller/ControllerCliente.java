package com.sofftekfrontend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Cliente;
import com.sofftekfrontend.app.service.ServiceCliente;

@RestController
public class ControllerCliente {
	
	@Autowired
	ServiceCliente service;
	@PostMapping("/usuario/cliente")
	public Cliente registerClient(@RequestBody Cliente c) {
		return service.save(c);
	}
}
