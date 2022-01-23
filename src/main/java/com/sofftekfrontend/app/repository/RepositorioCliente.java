package com.sofftekfrontend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofftekfrontend.app.models.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente, Integer>{

}
