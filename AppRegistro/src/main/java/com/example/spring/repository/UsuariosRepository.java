package com.example.spring.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Usuarios;

@Repository("usuariosrepository")
public interface UsuariosRepository extends JpaRepository<Usuarios, Serializable>{

	public abstract Usuarios findById(int id);
}
