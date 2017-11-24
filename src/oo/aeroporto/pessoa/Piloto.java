package oo.aeroporto.pessoa;

import oo.aeroporto.pessoa.interf.PilotoInterface;

public class Piloto extends Funcionario implements PilotoInterface{
	
	//Attributes
	private int breve;
	private double horasDeVoo;
	
	//Constructor
	public Piloto(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve,
			double horasDeVoo) {
		super(CPF, nome, idade, telefoneProprio, CTPS);
		this.breve = breve;
		this.horasDeVoo = horasDeVoo;
	}

	//Setters e getters

	public void setBreve(int breve) {
		this.breve = breve;
	}

	public double getHorasDeVoo() {
		return horasDeVoo;
	}

	public void setHorasDeVoo(double horasDeVoo) {
		this.horasDeVoo = horasDeVoo;
	}


	public String listarIdentificador(){
		String s = Integer.toString(breve);
		return s;
	}
	
	public int getBreve() {
		return this.breve;
	}
	
}
//NOTA: o atributo horasDeVoo nao esta sendo usado em nada