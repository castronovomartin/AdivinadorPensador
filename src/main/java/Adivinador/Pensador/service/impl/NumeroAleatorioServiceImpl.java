package Adivinador.Pensador.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import Adivinador.Pensador.service.numeroAleatorioService;

@Service("numeroAleatorioService")

public class NumeroAleatorioServiceImpl implements numeroAleatorioService{

	@Override
	public String numeroAleatorio() {
		String aleatorio = "";
		Random random = new Random();
		//GENERO 4 NUMEROS ENTEROS
		
		while (aleatorio.length()!=4) {
			int randomInteger = random.nextInt(10);
			if(!aleatorio.contains(String.valueOf(randomInteger))) {
				aleatorio += String.valueOf(randomInteger);
			}
		}		
		
		return aleatorio;
	}

}
