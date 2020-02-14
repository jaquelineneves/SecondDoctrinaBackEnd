package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.secondDoctrinaBackEnd.domain.Disciplina;

@Repository
public interface DisciplinaRepository  extends JpaRepository<Disciplina, Integer> {
    //faz operacoes de acesso a dados

}