package com.sofftekfrontend.app.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Table(name="user", schema = "public")
public class Usuario extends PersistentEntity{
	@NotBlank
	@Column(name="username")
	private String username;
	
	@NotBlank
	@Column(name="password", nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Rol rol;
}
