package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.secondDoctrinaBackEnd.domain.Aluno;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno, Integer> {
    //faz operacoes de acesso a dados

}