package Adivinador.Pensador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Adivinador.Pensador.entity.NumeroElegido;
import Adivinador.Pensador.repository.NumeroElegidoRepository;
import Adivinador.Pensador.repository.NumeroPensadoRepository;
import Adivinador.Pensador.service.adivinadorService;
import Adivinador.Pensador.service.numeroAleatorioService;

@Service("adivinadorService")

public class adivinadorServiceImpl implements adivinadorService{

	//REPOSITORY
	@Autowired
	NumeroElegidoRepository numeroElegidoRepository;
	@Autowired
	NumeroPensadoRepository numeroPensadoRepository;
	//SERVICE
	@Autowired
	numeroAleatorioService numeroAleatorioService;
	
	@Override
	public String adivinarNumero(String numero) {
		
		String numeroElegido = numeroElegidoRepository.findAll().get(0).getNumero();
		int bien = 0;
		int regular = 0;
		
		if(numero.length()!=4) {
			return "El número debe contener 4 digitos";
		}else {
			if(numero.equals(numeroElegido)){
				numeroElegidoRepository.delete(numeroElegidoRepository.findNumeroElegidoByNumero(numeroElegido));
				if(!numeroPensadoRepository.findAll().isEmpty()) {
					numeroPensadoRepository.deleteAll();
				}
				return "4 bien, 0 regular, JUEGO TERMINADO!";
			}else {
				//CUENTA CANTIDAD DE DIGITOS "bien" Y "regular
				for(int i = 0; i<4 ; i++) {
					if(numero.charAt(i)==numeroElegido.charAt(i)) {
						bien += 1;						
					}else {
						if(numeroElegido.indexOf(numero.charAt(i))!=-1) {
							regular +=1;
						}
					}
				}
				return bien + " bien " + regular + " regular";
			}
		}
		
	}

	@Override
	public void numeroAleatorio() {
		numeroElegidoRepository.save(new NumeroElegido(numeroAleatorioService.numeroAleatorio()));
	}

}
