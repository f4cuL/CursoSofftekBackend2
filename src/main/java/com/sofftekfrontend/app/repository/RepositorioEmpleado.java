package com.sofftekfrontend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofftekfrontend.app.models.Empleado;

public interface RepositorioEmpleado extends JpaRepository<Empleado, Integer>{

}
