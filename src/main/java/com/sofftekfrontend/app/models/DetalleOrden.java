package com.sofftekfrontend.app.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_orden")
public class DetalleOrden extends PersistentEntity{
	
	
	//@MapsId("idOrden")
	@JoinColumn(name="id_orden")
	@JsonIgnore
	@ManyToOne(targetEntity = Orden.class, cascade = CascadeType.ALL)
	private Orden orden;
	
	//@MapsId("idProducto")
	@JoinColumn(name="id_producto")
	@ManyToOne(targetEntity = Producto.class, cascade = CascadeType.ALL)
	private Producto producto;
	
	@Column
	int cantidad;
	
	@Column(name = "precio_venta_unitario")
	double precioVentaUnitario;
	
}
