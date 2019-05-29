package Adivinador.Pensador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Adivinador.Pensador.service.adivinadorService;

@RequestMapping("/ParteUno")
@RestController
@CrossOrigin

public class EjercicioUnoParteUnoController {
	
	@Autowired
	adivinadorService adivinadorService;
	
	@GetMapping("/adivinar/numero")
	public String adivinarNumero(@RequestParam(value="numero",required=true)String numero){
		return adivinadorService.adivinarNumero(numero);
	}
	
	@PostMapping("/elegir/numero")
	public void elegirNumero() {
		adivinadorService.numeroAleatorio();
	}

}
