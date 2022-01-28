package com.sofftekfrontend.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sofftekfrontend.app.models.Categoria;
import com.sofftekfrontend.app.service.ServiceCategoria;

@CrossOrigin(origins ="https://retail-facu-sofftek-frontend.herokuapp.com/")
@RestController
public class ControllerCategoria {
	
	@Autowired
	ServiceCategoria service;
	
	@GetMapping("/categoria")
	public List<Categoria> findAll(){
		return service.findAll();
	}
	@PostMapping("/categoria")
	public Categoria addCategory(@Valid @RequestBody Categoria t){
		return service.save(t);
	}
	@PutMapping("/categoria/{id}")
	public void modifyCategory(@Valid @RequestBody Categoria t, @PathVariable int id) {
		service.update(t, id);
	}
	@DeleteMapping("/categoria/{id}")
	public void deleteCategory(@PathVariable int id) {
		service.delete(id);
	}
}
