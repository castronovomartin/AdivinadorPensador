package Adivinador.Pensador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "numeros_pensados")

public class NumeroPensado {
	
	//ATRIBUTOS
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;
			
	@Column(name = "numero")
	private String numeroPensado;
		
	@Column(name = "primer_numero")
	private String primerNumero;
		
	@Column(name = "segundo_numero")
	private String segundoNumero;
		
	@Column(name = "tercer_numero")
	private String tercerNumero;
		
	@Column(name = "cuarto_numero")
	private String cuartoNumero;

	//CONSTRUCTOR VACÍO
	public NumeroPensado() {
		super();
	}
	
	public NumeroPensado(String numeroPensado) {
		super();
		this.numeroPensado = numeroPensado;
	}

	//GET AND SET
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroPensado() {
		return numeroPensado;
	}

	public void setNumeroPensado(String numeroPensado) {
		this.numeroPensado = numeroPensado;
	}

	public String getPrimerNumero() {
		return primerNumero;
	}

	public void setPrimerNumero(String primerNumero) {
		this.primerNumero = primerNumero;
	}

	public String getSegundoNumero() {
		return segundoNumero;
	}

	public void setSegundoNumero(String segundoNumero) {
		this.segundoNumero = segundoNumero;
	}

	public String getTercerNumero() {
		return tercerNumero;
	}

	public void setTercerNumero(String tercerNumero) {
		this.tercerNumero = tercerNumero;
	}

	public String getCuartoNumero() {
		return cuartoNumero;
	}

	public void setCuartoNumero(String cuartoNumero) {
		this.cuartoNumero = cuartoNumero;
	}	
}
