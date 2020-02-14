package com.app.secondDoctrinaBackEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.secondDoctrinaBackEnd.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    //faz operacoes de acesso a dados

}
