package com.aula.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.relacionamento.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
