package com.sofftekfrontend.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Orden;
import com.sofftekfrontend.app.models.Producto;
import com.sofftekfrontend.app.service.ServiceOrden;
import com.sofftekfrontend.app.util.JWTUtil;

@RestController
public class ControllerOrden {
	@Autowired
	ServiceOrden service;
	@Autowired
	JWTUtil jwtUtil;
	
	
	@GetMapping("/orden/{id}")
	public Orden findAllById(@PathVariable int id) {
		return service.findById(id);
	}

	@PostMapping("/cliente/{idCliente}/checkout")
	public String createOrdenCarrito(@RequestHeader(name = "Authorization")String token,@RequestBody List<Producto> lista, @PathVariable int idCliente) {
		if(!validarToken(token)) {
			return "NOLOGIN";
		}else {
		service.createCart(lista, idCliente);
		return "CARRITOCREADO";
		}
	}
	
	private boolean validarToken(String token) {
		String idUsuario = jwtUtil.getKey(token);
			return !(idUsuario == null);
	}
}
