package com.sofftekfrontend.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categoria extends PersistentEntity{
	@Column(name="nombre_categoria")
	@NotBlank
	private String nombreCategoria;
}
