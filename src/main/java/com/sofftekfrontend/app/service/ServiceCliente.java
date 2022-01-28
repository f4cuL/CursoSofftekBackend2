package com.sofftekfrontend.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofftekfrontend.app.models.Cliente;
import com.sofftekfrontend.app.models.Usuario;
import com.sofftekfrontend.app.repository.RepositorioCliente;
import com.sofftekfrontend.app.repository.RepositorioUsuario;

@Service
public class ServiceCliente implements ServiceInteface<Cliente> {

	@Autowired
	private RepositorioCliente repository;
	@Autowired
	private RepositorioUsuario repositoryUsuario;

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Cliente findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente save(Cliente t) {
		Usuario aux = repositoryUsuario.findByUsername(t.getUsername());
		if (aux == null) {
			return repository.save(t);
		}
		return null;
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
