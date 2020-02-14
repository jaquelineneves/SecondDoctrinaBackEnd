package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.secondDoctrinaBackEnd.domain.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
    //faz operacoes de acesso a dados	
}
