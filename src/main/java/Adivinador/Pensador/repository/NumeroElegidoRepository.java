package Adivinador.Pensador.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Adivinador.Pensador.entity.NumeroElegido;

@Repository("numeroElegidoRepository")

public interface NumeroElegidoRepository extends JpaRepository<NumeroElegido, Serializable>{
	
	public NumeroElegido findNumeroElegidoByNumero(String numero);
	
}
