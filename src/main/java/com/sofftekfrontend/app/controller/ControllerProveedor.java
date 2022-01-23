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

import com.sofftekfrontend.app.models.Proveedor;
import com.sofftekfrontend.app.service.ServiceProveedor;

@RestController
public class ControllerProveedor {
	@Autowired
	private ServiceProveedor service;
	
	@GetMapping("/proveedor")
	public List<Proveedor> findAll(){
		return service.findAll();
	}
	@GetMapping("/proveedor/{id}")
	public Proveedor findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@PostMapping("/proveedor")
	public Proveedor add(@Valid @RequestBody Proveedor p){
		return service.save(p);
	}
	
	@DeleteMapping("/proveedor/{id}")
	public void eliminarProveedor(@PathVariable int id) {
		service.delete(id);
	}
	
	@PutMapping("/proveedor/{id}")
	public void modificarProveedor(@Valid @RequestBody Proveedor p, @PathVariable int id) {
		service.update(p, id);
	}

}
