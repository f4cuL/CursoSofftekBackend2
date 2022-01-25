package com.sofftekfrontend.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sofftekfrontend.app.models.Categoria;
import com.sofftekfrontend.app.models.Proveedor;
import com.sofftekfrontend.app.repository.RepositorioCategorias;
import com.sofftekfrontend.app.repository.RepositorioProveedor;

@Service
public class ServiceProveedor implements ServiceInteface<Proveedor> {
	@Autowired
	private RepositorioProveedor repo;
	@Autowired
	private RepositorioCategorias repositorioCategoria;

	public List<Proveedor> findAll() {
		return repo.findAll();
	}

	public Proveedor findById(int id) {
		return repo.findById(id).orElse(null);
	}

	public Proveedor save(Proveedor p) {
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

	public Page<Proveedor> findAllPaginated(int page, int size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	public Proveedor addCategoriaToProveedor(int proveedor, int categoria) {
		Proveedor p = repo.findById(proveedor).orElse(null);
		Categoria cat = repositorioCategoria.findById(categoria).orElse(null);
		if (!p.getListaCategorias().contains(cat)) {
			p.agregarCategoria(cat);
		}
		return repo.save(p);
	}

	public List<Categoria> getCategoriasByIdProveedor(int proveedor) {
		Proveedor p = repo.findById(proveedor).orElse(null);
		return p.getListaCategorias();
	}

	public void removeCategoriaFromProveedor(int proveedor, int categoria) {
		Proveedor p = repo.findById(proveedor).orElse(null);
		Categoria cat = repositorioCategoria.findById(categoria).orElse(null);
		p.getListaCategorias().remove(p.getListaCategorias().indexOf(cat));
		repo.save(p);
	}

}
