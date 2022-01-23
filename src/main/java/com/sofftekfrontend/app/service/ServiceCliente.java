package com.sofftekfrontend.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofftekfrontend.app.models.Cliente;
import com.sofftekfrontend.app.repository.RepositorioCliente;

@Service
public class ServiceCliente implements ServiceInteface<Cliente> {

	@Autowired
	private RepositorioCliente repository;
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente save(Cliente t) {
		return repository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente t, int id) {
		// TODO Auto-generated method stub	
	}

}
