package Adivinador.Pensador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Adivinador.Pensador.entity.NumeroElegido;
import Adivinador.Pensador.repository.NumeroElegidoRepository;
import Adivinador.Pensador.service.ElegirNumeroService;

@Service("elegirNumeroService")

public class ElegirNumeroServiceImpl implements ElegirNumeroService{

	@Autowired
	NumeroElegidoRepository numeroElegidoRepository;
	
	@Override
	public String elegirNumero(String numero) {
		if(numero.length()!=4) {
			return "El número debe contener 4 digitos";
		}else {
			numeroElegidoRepository.save(new NumeroElegido(numero));
			return "Usted eligió el número " +numero+ ". Ahora la PC deberá advinar !!";
		}
			
	}

}
