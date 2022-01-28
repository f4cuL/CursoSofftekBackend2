package com.sofftekfrontend.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Categoria;
import com.sofftekfrontend.app.models.Proveedor;
import com.sofftekfrontend.app.service.ServiceProveedor;
import com.sofftekfrontend.app.util.JWTUtil;
@CrossOrigin(origins ="https://retail-facu-sofftek-frontend.herokuapp.com/")
@RestController
public class ControllerProveedor {
	@Autowired
	private ServiceProveedor service;
	@Autowired
	private JWTUtil jwtUtil;

	@GetMapping("/proveedor")
	public List<Proveedor> findAll(@RequestHeader(value = "Authorization") String token) {
		System.out.println(jwtUtil.getValue(token));
		if (validarToken(token).equals("ADMIN")) {
			return service.findAll();
		}
		return null;
	}

	@GetMapping("/proveedor/{id}")
	public Proveedor findById(@PathVariable int id) {
		return service.findById(id);
	}

	@PostMapping("/proveedor")
	public Proveedor add(@RequestHeader(value = "Authorization")String token, @Valid @RequestBody Proveedor p) {
		if (validarToken(token).equals("ADMIN") || validarToken(token).equals("EMPLEADO") ) {
			return service.save(p);
		}
		return null;
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
	public Page<Proveedor> findAllPaginated(@RequestHeader(value = "Authorization") String token, @PathVariable int pag) {
		if (validarToken(token).equals("ADMIN") || validarToken(token).equals("EMPLEADO") ) {
			return service.findAllPaginated(pag, 5);
		}
		return null;
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

	private String validarToken(String token) {
		String rol = jwtUtil.getValue(token) ;
		return rol;
	}
}
