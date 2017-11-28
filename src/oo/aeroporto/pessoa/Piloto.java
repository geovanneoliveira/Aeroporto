package oo.aeroporto.pessoa;

import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.PilotoInterface;
import oo.aeroporto.repositorio.RepPiloto;
import oo.aeroporto.repositorio.interf.RepPilotoInterf;

public class Piloto extends Funcionario implements PilotoInterface{
	
	//Attributes
	private int breve;
	private double horasDeVoo;
	private RepPilotoInterf repPiloto;
	
	//Constructor
	public Piloto(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve,
			double horasDeVoo) throws PilotoException {
		super(CPF, nome, idade, telefoneProprio, CTPS);
		this.breve = breve;
		this.horasDeVoo = horasDeVoo;
		repPiloto = RepPiloto.getInstance();
		repPiloto.adicionar(this);
	}

	//Setters e getters

	public double getHorasDeVoo() {
		return horasDeVoo;
	}
	
	public String listarIdentificador(){
		String s = Integer.toString(breve);
		return s;
	}
	
	public int getBreve() {
		return this.breve;
	}
	
	public void addHorasDeVoo(double hora) {
		if(hora > 0)
		this.horasDeVoo += hora;
	}
	
}
