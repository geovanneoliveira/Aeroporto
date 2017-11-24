package oo.aeroporto.pessoa;

import oo.aeroporto.pessoa.interf.FuncionarioInterface;

public abstract class Funcionario extends Pessoa implements FuncionarioInterface{

	
	//Attributes
	private String CTPS;
	
	//Constructor
	public Funcionario(String CPF, String nome, int idade, String telefoneProprio, String CTPS) {
		super(CPF, nome, idade, telefoneProprio);
		this.CTPS = CTPS;
	}


	//Setters e Getters
	public String getCTPS() {
		return CTPS;
	}

	public void setCTPS(String cTPS) {
		CTPS = cTPS;
	}
	
	
	//Methods
	//@denini
	
	public void listarIdentificador(){
		System.out.println("CTPS: " + this.CTPS);
	}
	
}
