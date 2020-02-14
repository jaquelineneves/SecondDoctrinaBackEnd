package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.secondDoctrinaBackEnd.domain.Modulo;

@Repository
public interface ModuloRepository  extends JpaRepository<Modulo, Integer> {
    //faz operacoes de acesso a dados

}