package com.sofftekfrontend.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Orden;
import com.sofftekfrontend.app.models.Producto;
import com.sofftekfrontend.app.service.ServiceOrden;

@RestController
public class ControllerOrden {
	@Autowired
	ServiceOrden service;

	@GetMapping("/orden/{id}")
	public Orden findAllById(@PathVariable int id) {
		return service.findById(id);
	}

	@PostMapping("/cliente/{idCliente}/checkout")
	public void createOrdenCarrito(@RequestBody List<Producto> lista, @PathVariable int idCliente) {
		service.createCart(lista, idCliente);
	}
}
