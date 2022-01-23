package com.sofftekfrontend.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofftekfrontend.app.models.Producto;
import com.sofftekfrontend.app.models.Proveedor;
import com.sofftekfrontend.app.repository.RepositorioProducto;
import com.sofftekfrontend.app.repository.RepositorioProveedor;

@Service
public class ServiceProducto implements ServiceInteface<Producto>{

	@Autowired
	private RepositorioProducto repositorio;
	@Autowired
	private RepositorioProveedor repositorioProveedor;

	@Override
	public List<Producto> findAll() {
		return repositorio.findAll();
	}

	@Override
	public Producto findById(int id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto t) {
		return repositorio.save(t);
	}
	
	public Proveedor saveProducto(Producto t, int id) {
		Proveedor p = repositorioProveedor.findById(id).orElse(null);
		System.out.println(p.getNombre());
		p.agregarProducto(t);
		return repositorioProveedor.save(p);
	}

	@Override
	public void delete(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public void update(Producto t, int id) {
		Producto p = repositorio.findById(id).orElse(null);
		p.setNombreProducto(t.getNombreProducto());
		p.setPrecioProducto(t.getPrecioProducto());
		p.setStock(t.getStock());
		repositorio.save(p);
	}

}
