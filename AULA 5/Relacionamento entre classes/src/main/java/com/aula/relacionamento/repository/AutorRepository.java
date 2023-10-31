package com.aula.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.relacionamento.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
