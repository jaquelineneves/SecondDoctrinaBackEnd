package com.app.secondDoctrinaBackEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.secondDoctrinaBackEnd.domain.NotaDisciplina;

@Repository
public interface NotaDisciplinaRepository extends JpaRepository<NotaDisciplina, Integer>{
    //faz operacoes de acesso a dados

}
