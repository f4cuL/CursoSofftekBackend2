package com.sofftekfrontend.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Categoria;
import com.sofftekfrontend.app.models.Proveedor;
import com.sofftekfrontend.app.service.ServiceProveedor;

@RestController
public class ControllerProveedor {
	@Autowired
	private ServiceProveedor service;

	@GetMapping("/proveedor")
	public List<Proveedor> findAll() {
		return service.findAll();
	}

	@GetMapping("/proveedor/{id}")
	public Proveedor findById(@PathVariable int id) {
		return service.findById(id);
	}

	@PostMapping("/proveedor")
	public Proveedor add(@Valid @RequestBody Proveedor p) {
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

	@GetMapping("/proveedor/page/{pag}")
	public Page<Proveedor> findAllPaginated(@PathVariable int pag) {
		return service.findAllPaginated(pag, 5);
	}

	@PostMapping("/proveedor/{id}/categoria/{idcat}")
	public Proveedor addCategoriaToProveedor(@PathVariable int id, @PathVariable int idcat) {
		return service.addCategoriaToProveedor(id, idcat);
	}

	@GetMapping("/proveedor/{id}/categoria")
	public List<Categoria> getCategoriasByIdProveedor(@PathVariable int id) {
		return service.getCategoriasByIdProveedor(id);
	}
	
	@DeleteMapping("/proveedor/{id}/categoria/{idCat}")
	public void removeCategoriaFromProveedor(@PathVariable int id, @PathVariable int idCat) {
		 service.removeCategoriaFromProveedor(id, idCat);
	}

}
