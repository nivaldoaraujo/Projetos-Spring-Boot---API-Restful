package com.aula.msemail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.msemail.entities.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}