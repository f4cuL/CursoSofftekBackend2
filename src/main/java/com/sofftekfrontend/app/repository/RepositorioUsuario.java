package com.sofftekfrontend.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofftekfrontend.app.models.Usuario;


public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>  {
	Usuario findByUsername(String userName);
}
