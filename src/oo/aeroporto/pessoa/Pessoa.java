package oo.aeroporto.pessoa;

import java.util.ArrayList;

import oo.aeroporto.pessoa.interf.PessoaInterface;

public abstract class Pessoa implements PessoaInterface {

	//Attributes
	private String CPF;
	private String nome;
	private int idade;
	private ArrayList<String> telefoneProprio = new ArrayList<String>();
	
	
	//Constructor
	public Pessoa(String CPF, String nome, int idade, String telefoneProprio) {
		this.CPF = CPF;
		this.nome = nome;
		this.idade = idade;
		this.telefoneProprio.add(telefoneProprio);
		
	}
	
	
	//Setters e Getters
	public String getCPF() {
		return this.CPF;
	}
	
	public String getNome() {
		return this.nome;
	}

	
	//Methods
	//@denini
	
	public void listarInformacoes() {
		String s = ("Mome:  " + this.nome + " CPF: " + this.CPF + " idade: " + this.idade + " telefone(s): ");
		for(int i = 0; i < this.telefoneProprio.size()  ; i++) {  //provavelmente errado esse size() //se lembrar do -1
			s += (telefoneProprio.get(i) + " ");
		}
		System.out.println(s);
	}
	
	public void listarIdentificador(){
		System.out.println("CPF:" + this.CPF);
	}
}
