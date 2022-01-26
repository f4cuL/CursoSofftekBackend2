package com.sofftekfrontend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofftekfrontend.app.models.DetalleOrden;

public interface RepositorioDetalleOrden extends JpaRepository<DetalleOrden, Integer> {

}
