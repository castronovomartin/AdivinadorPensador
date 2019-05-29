package Adivinador.Pensador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Adivinador.Pensador.service.AdivinarNumeroservice;
import Adivinador.Pensador.service.ElegirNumeroService;

@RequestMapping("/ParteDos")
@RestController
@CrossOrigin

public class EjercicioUnoParteDosController {
	
	@Autowired
	ElegirNumeroService elegirNumeroService;
	@Autowired
	AdivinarNumeroservice adivinarNumeroservice;
	
	@PostMapping("/elegir/numero")
	public String elegirNumero(@RequestParam(value="numero",required=true)String numero) {
		return elegirNumeroService.elegirNumero(numero);
	}
	
	@PutMapping("adivinar/numero")
	public String adivinarNumero() {
		return adivinarNumeroservice.adivinarNumero();
	}

}
