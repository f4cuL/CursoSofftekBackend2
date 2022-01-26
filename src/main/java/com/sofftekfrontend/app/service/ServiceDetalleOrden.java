package com.sofftekfrontend.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofftekfrontend.app.models.DetalleOrden;
import com.sofftekfrontend.app.repository.RepositorioDetalleOrden;

@Service
public class ServiceDetalleOrden implements ServiceInteface<DetalleOrden>{

	@Autowired
	RepositorioDetalleOrden repo;
	
	@Override
	public List<DetalleOrden> findAll() {
		return repo.findAll();
	}

	@Override
	public DetalleOrden findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public DetalleOrden save(DetalleOrden t) {
		return repo.save(t);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void update(DetalleOrden t, int id) {
		// TODO Auto-generated method stub
		
	}

}
