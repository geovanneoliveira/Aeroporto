package oo.aeroporto.pessoa;

import oo.aeroporto.pessoa.interf.PessoaInterface;

public abstract class Pessoa implements PessoaInterface {

	//Attributes
	private String CPF;
	private String nome;
	private int idade;
	private String telefoneProprio;
	
	
	//Constructor
	public Pessoa(String CPF, String nome, int idade, String telefoneProprio) {
		this.CPF = CPF;
		this.nome = nome;
		this.idade = idade;
		this.telefoneProprio = telefoneProprio;
		
	}
	
	//Methods
	
	public String getNome() {
		return this.nome;
	}

	public String listarInformacoes() {
		String s = ("Nome:  " + this.nome + " CPF: " + this.CPF + " idade: " + this.idade + " telefone: " + this.telefoneProprio);
		System.out.println(s);
		return s;
	}
	
	public String listarIdentificador(){
		return this.CPF;
	}
}
