package com.sofftekfrontend.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Producto;
import com.sofftekfrontend.app.models.Proveedor;
import com.sofftekfrontend.app.service.ServiceProducto;

@RestController
public class ControllerProducto {
	@Autowired
	private ServiceProducto service;
	@GetMapping("/producto")
	public List<Producto> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/proveedor/{id}/producto")
	public Proveedor save(@Valid @RequestBody Producto p,@PathVariable int id) {
		return service.saveProducto(p,id);
	}
	@DeleteMapping("/producto/{id}")
	public void delete(@PathVariable int id){
		 service.delete(id);
	}
	@PutMapping("/producto/{id}")
	public void update(@RequestBody Producto p,@PathVariable int id){
		 service.update(p,id);
	}
}
