package com.sofftekfrontend.app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Orden extends PersistentEntity{
	@JsonBackReference
	@ManyToOne(targetEntity = Cliente.class)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@JoinColumn(name="id_vendedor")
	@OneToOne(optional = true)
	private Empleado empleado;
	
	@Column(name="fecha_generacion")
    private java.sql.Date fechaGeneracion;
	
	@Column(name="fecha_entrega")
    private java.sql.Date fechaEntrega;
	
	@Column(name="precio_total")
	private int precioTotal;
	
	@OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
	private List<DetalleOrden> listaDetalle;

	public Orden(List<DetalleOrden> listaDetalle) {
		this.listaDetalle = new ArrayList<DetalleOrden>();
	}
	
	
}
