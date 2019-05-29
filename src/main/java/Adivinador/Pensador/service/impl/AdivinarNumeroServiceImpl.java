package Adivinador.Pensador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Adivinador.Pensador.entity.NumeroPensado;
import Adivinador.Pensador.repository.NumeroElegidoRepository;
import Adivinador.Pensador.repository.NumeroPensadoRepository;
import Adivinador.Pensador.service.AdivinarNumeroservice;
import Adivinador.Pensador.service.adivinadorService;
import Adivinador.Pensador.service.numeroAleatorioService;

@Service("adivinarNumeroService")

public class AdivinarNumeroServiceImpl implements AdivinarNumeroservice{

	@Autowired
	NumeroElegidoRepository numeroElegidoRepository;
	@Autowired
	NumeroPensadoRepository numeroPensadoRepository;
	@Autowired
	numeroAleatorioService numeroAleatorioService;
	@Autowired
	adivinadorService adivinadorService;
		
	@Override
	public String adivinarNumero() {
		
		NumeroPensado num;
		String numeroFinalElegido;
		String numeroElegido = numeroElegidoRepository.findAll().get(0).getNumero(); //1234
		String numeroAleatorio;
		String numeroPensado = "";
		
		if(!numeroPensadoRepository.findAll().isEmpty()) {
			num = numeroPensadoRepository.findAll().get(0);
			numeroPensado = num.getNumeroPensado();
		}else {
			num = new NumeroPensado();
			num.setNumeroPensado("");
		}	
		
		numeroAleatorio = numeroAleatorioService.numeroAleatorio();
		System.out.println("El numero elegido es = " +numeroElegido+ " y el aleatorio es = " +numeroAleatorio );
		
		if(numeroPensado.equals("")){
			numeroFinalElegido = setearCaracteresCoincidentes(numeroElegido, numeroAleatorio, num);
		
		}else { //SI YA FUE SELECCIONADO UN NÚMERO, GUARDAREMOS LOS DIGITOS BIEN ELEGIDOS Y NOS ASEGURAREMOS QUE NO SE REPITAN PARA AUMENTAR ÉXITO
			numeroFinalElegido = setearCaracteresCoincidentes(numeroElegido, numeroAleatorio, num);
		}
		
		return "El numero pensado fue " +numeroFinalElegido+ ": " +  adivinadorService.adivinarNumero(numeroFinalElegido);
		
	}

	@Override
	public String setearCaracteresCoincidentes(String numeroElegido, String numeroAleatorio, NumeroPensado numero) {
		String numeroFinalElegido = numeroAleatorio;
		System.out.println("El número aleatorio pensado antes de modificar es = " +numeroFinalElegido);
		//MODIFICO NÚMERO ALEATORIO, PARA FIJAR LOS DÍGITOS QUE YA HABÍAN SIDO ADIVINADOS
		
		char [] cadena = numeroAleatorio.toCharArray();
		
		for(int i=0; i<4; i++) { 
			
//			char [] cadena = numeroAleatorio.toCharArray();
			switch (i) {
			case 0:	
				if(!(numero.getPrimerNumero()==null)){
					cadena[i] = (numero.getPrimerNumero()).charAt(0);
					System.out.println("Modifico primer dígito por = " +cadena[i]);
					numeroFinalElegido = String.valueOf(cadena);
					System.out.println("AHORA QUEDÓ = " +numeroFinalElegido);
//					break;
				}	
				break;
			case 1:
				if(!(numero.getSegundoNumero()==null)){
					cadena[i] = (numero.getSegundoNumero()).charAt(0);
					System.out.println("Modifico segundo dígito por = " +cadena[i]);
					numeroFinalElegido = String.valueOf(cadena);
					System.out.println("AHORA QUEDÓ = " +numeroFinalElegido);
//					break;
				}		
				break;
			case 2:
				if(!(numero.getTercerNumero()==null)){
					cadena[i] = (numero.getTercerNumero()).charAt(0);
					System.out.println("Modifico tercero dígito por = " +cadena[i]);
					numeroFinalElegido = String.valueOf(cadena);
					System.out.println("AHORA QUEDÓ = " +numeroFinalElegido);
//					break;
				}	
				break;
			case 3:
				if(!(numero.getCuartoNumero()==null)){
					cadena[i] = (numero.getCuartoNumero()).charAt(0);
					System.out.println("Modifico cuarto dígito por = " +cadena[i]);
					numeroFinalElegido = String.valueOf(cadena);
					System.out.println("AHORA QUEDÓ = " +numeroFinalElegido);
//					break;
				}
				break;
			
			}
			
//			numeroFinalElegido = String.valueOf(cadena);
			
			
		
		

//		numero.setNumeroPensado(numeroFinalElegido);
//		numeroFinalElegido = numero.getNumeroPensado();
			
		}
		
		for(int i=0; i<4; i++) { 
			
			if (numeroFinalElegido.charAt(i)==numeroElegido.charAt(i)) {
				System.out.println("Digito coincidente = " +numeroFinalElegido.charAt(i));
				switch (i) {
				//ESTO YA LO HACE PERFECTO
				case 0:
					System.out.println("Seteo el primer dígito coincidente");
					numero.setPrimerNumero(String.valueOf(numeroFinalElegido.charAt(i)));
					break;
				case 1:
					System.out.println("Seteo el segundo dígito coincidente");
					numero.setSegundoNumero(String.valueOf(numeroFinalElegido.charAt(i)));
					break;
				case 2:
					System.out.println("Seteo el tercer dígito coincidente");
					numero.setTercerNumero(String.valueOf(numeroFinalElegido.charAt(i)));
					break;
				case 3:
					System.out.println("Seteo el cuarto dígito coincidente");
					numero.setCuartoNumero(String.valueOf(numeroFinalElegido.charAt(i)));
					break;
				}
			}
			
		}
		
		
		
		numero.setNumeroPensado(numeroFinalElegido);
		numeroFinalElegido = numero.getNumeroPensado();
		
		System.out.println("El número aleatorio una vez modificado es = " +numeroFinalElegido);
		
		numeroPensadoRepository.save(numero);
		
		return numeroFinalElegido;
	}

}
