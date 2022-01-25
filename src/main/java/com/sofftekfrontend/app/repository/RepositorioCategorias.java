package com.sofftekfrontend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofftekfrontend.app.models.Categoria;

public interface RepositorioCategorias extends JpaRepository<Categoria, Integer> {

}
