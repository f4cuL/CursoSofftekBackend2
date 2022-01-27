package com.sofftekfrontend.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="producto")
public class Producto extends PersistentEntity{
	@JoinColumn(name = "id_proveedor")
	@JsonBackReference
	@ManyToOne(targetEntity = Proveedor.class)
	//TODO Hacer TDO para Proveedor
	private Proveedor proveedor;
	
	@Column(name="nombre_producto")
	@NotBlank
	private String nombreProducto;
	
	@Positive
	@Column(name="precio_producto")
	private double precioProducto;
	
	@Min(0)
	@Column
	private int stock;
}
