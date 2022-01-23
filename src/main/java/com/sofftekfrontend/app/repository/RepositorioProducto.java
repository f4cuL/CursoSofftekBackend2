package com.sofftekfrontend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofftekfrontend.app.models.Producto;

public interface RepositorioProducto extends JpaRepository<Producto, Integer>{

}
