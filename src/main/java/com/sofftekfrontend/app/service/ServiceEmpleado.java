package com.sofftekfrontend.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sofftekfrontend.app.models.Empleado;
import com.sofftekfrontend.app.repository.RepositorioEmpleado;

@Service
public class ServiceEmpleado{
	 @Autowired
	 RepositorioEmpleado repository;
	 
	 
	 public Empleado save(@Valid @RequestBody Empleado e) {
		 return repository.save(e);
	 }
}
