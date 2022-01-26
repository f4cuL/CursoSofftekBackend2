package com.sofftekfrontend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofftekfrontend.app.models.Orden;

public interface RepositorioOrden extends JpaRepository<Orden, Integer> {

}
