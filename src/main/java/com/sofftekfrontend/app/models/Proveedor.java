package com.sofftekfrontend.app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "proovedor")
public class Proveedor extends PersistentEntity{
	
	public Proveedor() {
		this.listaProductos =new ArrayList<>();
		this.listaCategorias = new ArrayList<>();
	}

	@Column
	@NotBlank
	private String nombre;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Producto> listaProductos;
	
	@Column
	@NotBlank
	private String direccion;
	
	
	@Column
	@Size(min = 11, max=11)
	private String cuit;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(
			name = "proveedor_categoria", joinColumns = {
			@JoinColumn(name = "id_proveedor") },
			inverseJoinColumns = { @JoinColumn(name = "id_categoria") })
	private List<Categoria> listaCategorias;
	
	public void agregarProducto(Producto ... producto) {
		for (Producto p : producto) {
			p.setProveedor(this);
			listaProductos.add(p);
		}
	}
	public void agregarCategoria(Categoria ... categoria) {
		for (Categoria c : categoria) {
			listaCategorias.add(c);
		}
	}
	public void removerCategoria(int id) {
		for (Categoria c : listaCategorias) {
			if (c.getId()==id) {
				listaCategorias.remove(c);
			}
		}
	}
	
}