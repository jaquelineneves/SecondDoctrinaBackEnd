package com.app.secondDoctrinaBackEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.secondDoctrinaBackEnd.domain.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{
    //faz operacoes de acesso a dados

}
