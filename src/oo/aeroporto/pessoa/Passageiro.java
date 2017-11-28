package oo.aeroporto.pessoa;

import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.interf.PassageiroInterface;
import oo.aeroporto.repositorio.RepPassageiro;
import oo.aeroporto.repositorio.interf.RepPassageiroInterf;

public class Passageiro extends Pessoa implements PassageiroInterface {
	
	//Attributes
	private String telefoneDeEmergencia;
	private RepPassageiroInterf repPassageiro;

	
	//constructor
	public Passageiro(String CPF, String nome, int idade, String telefoneProprio,String telefoneDeEmergencia) throws PassageiroException {
		super(CPF, nome, idade, telefoneProprio);
		this.telefoneDeEmergencia = telefoneDeEmergencia;
		repPassageiro = RepPassageiro.getInstance();
		repPassageiro.adicionar(this);
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
