package com.sofftekfrontend.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofftekfrontend.app.models.Proveedor;
import com.sofftekfrontend.app.repository.RepositorioProveedor;

@Service
public class ServiceProveedor implements ServiceInteface<Proveedor> {
	@Autowired
	private RepositorioProveedor repo;
	
	public List<Proveedor> findAll(){
		return repo.findAll();
	}
	
	public Proveedor findById(int id){
		return repo.findById(id).orElse(null);
	}
	
	public Proveedor save(Proveedor p){
		return repo.save(p);
	}

	public void delete(int id) {
		repo.deleteById(id);
	}	
	
	public void update(Proveedor t, int id) {
		Proveedor p = repo.findById(id).orElse(null);
		p.setNombre(t.getNombre());
		p.setCuit(t.getCuit());
		p.setDireccion(t.getDireccion());
		repo.save(p);
	}
}
