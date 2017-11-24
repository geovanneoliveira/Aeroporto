package oo.aeroporto.pessoa;

import java.util.ArrayList;
import oo.aeroporto.pessoa.interf.PassageiroInterface;

public class Passageiro extends Pessoa implements PassageiroInterface {
	
	//Attributes
	private ArrayList<String> telefoneDeEmergencia = new ArrayList<String>();

	
	//constructor
	public Passageiro(String CPF, String nome, int idade, String telefoneProprio,String telefoneDeEmergencia) {
		super(CPF, nome, idade, telefoneProprio);
		this.telefoneDeEmergencia.add(telefoneDeEmergencia);
	}

	
	//Setters e Getters
	public ArrayList<String> getTelefoneDeEmergencia() {
		return telefoneDeEmergencia;
	}


	public void setTelefoneDeEmergencia(String telefoneDeEmergencia) {
		this.telefoneDeEmergencia.add(telefoneDeEmergencia);
	}
	
	//Methods

		
}
