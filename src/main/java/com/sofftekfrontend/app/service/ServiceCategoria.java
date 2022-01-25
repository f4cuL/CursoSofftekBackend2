package com.sofftekfrontend.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofftekfrontend.app.models.Categoria;
import com.sofftekfrontend.app.repository.RepositorioCategorias;

@Service
public class ServiceCategoria implements ServiceInteface<Categoria> {
	
	@Autowired
	private RepositorioCategorias repository;
	
	@Override
	public List<Categoria> findAll() {
		return repository.findAll();
	}

	@Override
	public Categoria findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Categoria save(Categoria t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public void update(Categoria t, int id) {
		Categoria categoria = repository.findById(id).orElse(null);
		categoria.setNombreCategoria(t.getNombreCategoria());
		repository.save(categoria);
		
	}

}
