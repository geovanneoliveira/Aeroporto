package oo.aeroporto.pessoa;

import oo.aeroporto.pessoa.interf.PassageiroInterface;

public class Passageiro extends Pessoa implements PassageiroInterface {
	
	//Attributes
	private String telefoneDeEmergencia;

	
	//constructor
	public Passageiro(String CPF, String nome, int idade, String telefoneProprio,String telefoneDeEmergencia) {
		super(CPF, nome, idade, telefoneProprio);
		this.telefoneDeEmergencia = telefoneDeEmergencia;
	}

	
	//Setters e Getters
	public String getTelefoneDeEmergencia() {
		return telefoneDeEmergencia;
	}


	public void setTelefoneDeEmergencia(String telefoneDeEmergencia) {
		this.telefoneDeEmergencia = telefoneDeEmergencia;
	}

	@Override
	public String getCPF() {
		return this.getCPF();
	}
			
}
