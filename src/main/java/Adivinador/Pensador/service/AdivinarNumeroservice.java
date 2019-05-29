package Adivinador.Pensador.service;

import Adivinador.Pensador.entity.NumeroPensado;

public interface AdivinarNumeroservice {
	
	public String adivinarNumero();
	
	public String setearCaracteresCoincidentes(String numeroElegido, String numeroPensado, NumeroPensado num);	
}
