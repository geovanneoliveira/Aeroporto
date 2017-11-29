package oo.aeroporto.controle;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.TorreControleException;
import oo.aeroporto.controle.interf.TorreControleInterface;

public class TorreDeControle implements TorreControleInterface{

	//Attributes
	private int quantidadeDePistas;
	private int counter = 0;
	private static TorreDeControle instance = null;
	
	//Constructor
	public static TorreDeControle getInstance(int quantidade) {
		if (instance == null) {
			instance = new TorreDeControle(quantidade);
		}
		return instance;
	}
	
	private TorreDeControle(int quantidadeDePistas) {
		this.quantidadeDePistas = quantidadeDePistas;
	}

	//Setters e Getters


	public int getQuantidadeDePistas() {
		return quantidadeDePistas;
	}

	public void setQuantidadeDePistas(int quantidadeDePistas) {
		this.quantidadeDePistas = quantidadeDePistas;
	}
	
	public int getCounter () {
		return this.counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	//Methods

	@Override
	public String status() {
		String msg = ("\nQuantidade de Pistas: "+this.quantidadeDePistas);
		msg += ("\nQuantidade de Pistas atualmente ocupadas: "+this.counter);
		return msg;
	}


	
}
