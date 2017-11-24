package oo.aeroporto.controle;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.interf.TorreControleInterface;

public class TorreDeControle implements TorreControleInterface{

	//Attributes
	private int cod;
	private int quatidadeDePistas;
	private int counter = 0;
	
	//Constructor
	public TorreDeControle(int cod, int quantidadeDePistas) {
		this.cod = cod;
		this.quatidadeDePistas = quantidadeDePistas;
	}

	//Setters e Getters
	public int getCod() {
		return cod;
	}

	public int getQuatidadeDePistas() {
		return quatidadeDePistas;
	}

	public void setQuatidadeDePistas(int quatidadeDePistas) {
		this.quatidadeDePistas = quatidadeDePistas;
	}
	
	//Methods

	@Override
	public void status() {
		System.out.println("Cód da Torre: "+this.cod);
		System.out.println("Quantidade de Pistas: "+this.quatidadeDePistas);
		System.out.println("Quantidade de Pistas atualmente ocupadas: "+this.counter);
		
	}

	@Override	//verificar se aqui não era pra checar se o avião tem as coisas
	public boolean taxi(AviaoInterface aviao) {
		if (aviao.getPiloto() == null || aviao.getCoPiloto() == null || aviao.getViagem() == null) {
			return false;
		}
		if (this.counter < this.quatidadeDePistas) {
			this.counter++;
			return true;
		}
		return false;
	}

	@Override	//precisa colocar exception
	public void decolar(AviaoInterface aviao) {
		if (this.taxi(aviao) == true) {
			System.out.println("O avião de cód "+aviao.getCod()+" decolou");
			this.counter--;
		}
		else System.out.println("O aviao não pode decolar"); //tratar exeção aqui
	}

	@Override	//precisa colocar exception
	public void aterrissar(AviaoInterface aviao) {
		if (this.taxi(aviao) == true) {
			System.out.println("O avião de cód "+aviao.getCod()+" aterrissou");
			this.counter--;
		}
		else System.out.println("O aviao não pode aterrissar"); //tratar exeção aqui
	}
}
