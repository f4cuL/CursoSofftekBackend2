package com.sofftekfrontend.app.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofftekfrontend.app.models.DetalleOrden;
import com.sofftekfrontend.app.models.DetalleOrdenKey;
import com.sofftekfrontend.app.models.Orden;
import com.sofftekfrontend.app.models.Producto;
import com.sofftekfrontend.app.repository.RepositorioCliente;
import com.sofftekfrontend.app.repository.RepositorioDetalleOrden;
import com.sofftekfrontend.app.repository.RepositorioOrden;
import com.sofftekfrontend.app.repository.RepositorioProducto;


@Service
public class ServiceOrden implements ServiceInteface<Orden>{

	@Autowired
	RepositorioOrden repo;
	@Autowired
	RepositorioCliente repoCliente;
	@Autowired
	RepositorioProducto repoProducto;
	@Autowired
	RepositorioDetalleOrden repoDetalleOrden;
	
	@Override
	public List<Orden> findAll() {
		return repo.findAll();
	}

	@Override
	public Orden findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Orden save(Orden t) {
		return repo.save(t);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void update(Orden t, int id) {
		
	}

	public void createCart(List<Producto> lista, int idCliente) {
		Orden o = new Orden();
		o.setCliente(repoCliente.findById(idCliente).orElse(null));
		Orden ordenPersistida = save(o);
		double suma=0;
		for (Producto p : lista) {
			Producto productoPersistido = repoProducto.findById(p.getId()).orElse(null);
			productoPersistido.setStock(productoPersistido.getStock()-p.getStock());
			repoProducto.save(productoPersistido);
			DetalleOrden aux = new DetalleOrden();
			aux.setCantidad(p.getStock());
			aux.setPrecioVentaUnitario(p.getPrecioProducto());
			suma = suma + (p.getPrecioProducto()*p.getStock());
			aux.setProducto(productoPersistido);
			aux.setOrden(ordenPersistida);
			ordenPersistida.agregarDetalleOrden(aux);
		}
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ordenPersistida.setFechaGeneracion(date);
		ordenPersistida.setPrecioTotal(suma);
		save(ordenPersistida);
		
	}
	
}
