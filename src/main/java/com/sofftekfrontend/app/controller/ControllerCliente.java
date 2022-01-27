package com.sofftekfrontend.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Cliente;
import com.sofftekfrontend.app.models.Rol;
import com.sofftekfrontend.app.service.ServiceCliente;
import com.sofftekfrontend.app.util.JWTUtil;

@RestController
public class ControllerCliente {
	
	@Autowired
	private ServiceCliente service;
	@Autowired
	private JWTUtil jwtUtil;
	@PostMapping("/usuario/registrar")
	public Cliente registerClient(@RequestBody Cliente c) {
		c.setRol(Rol.USUARIO);
		return service.save(c);
	}
	@GetMapping("/usuario/cliente")
	public List<Cliente> findAll(@RequestHeader(value = "Authorization")String token) {
		if (validarToken(token).equals("ADMIN") || validarToken(token).equals("EMPLEADO") ) {
			return service.findAll();
		}
		return null;
		
	}
	private String validarToken(String token) {
		String rol = jwtUtil.getValue(token) ;
		return rol;
	}
}
