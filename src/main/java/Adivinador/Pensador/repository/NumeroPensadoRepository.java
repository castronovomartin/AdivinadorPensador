package Adivinador.Pensador.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Adivinador.Pensador.entity.NumeroPensado;

@Repository("numeroPensadoRepository")

public interface NumeroPensadoRepository extends JpaRepository<NumeroPensado, Serializable>{
	
	public NumeroPensado findNumeroPensadoByNumeroPensado(String numeroPensado);
	
}
