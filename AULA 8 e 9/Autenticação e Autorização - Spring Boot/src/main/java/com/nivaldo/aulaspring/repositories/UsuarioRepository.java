package com.nivaldo.aulaspring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nivaldo.aulaspring.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByEmail(String email);
}
