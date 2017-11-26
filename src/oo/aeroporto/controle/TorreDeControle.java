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
		System.out.println("C�d da Torre: "+this.cod);
		System.out.println("Quantidade de Pistas: "+this.quatidadeDePistas);
		System.out.println("Quantidade de Pistas atualmente ocupadas: "+this.counter);
		
	}

	@Override	//verificar se aqui n�o era pra checar se o avi�o tem as coisas
	public boolean taxi(AviaoInterface aviao) {
		if (aviao.getPiloto() == null || aviao.getCoPiloto() == null || aviao.getViagem() == null || aviao.getStatus() != 0) {
			return false;
		}
		if (this.counter < this.quatidadeDePistas) {
			this.counter++;
			aviao.setStatus(1);
			return true;
		}
		return false;
	}

	@Override	//precisa colocar exception
	public void decolar(AviaoInterface aviao) {
		if (aviao.getStatus() == 1) {
			System.out.println("O avi�o de c�d "+aviao.getCod()+" decolou");
			this.counter--;
			aviao.setStatus(2);
		}
		else System.out.println("O aviao n�o pode decolar"); //tratar exe��o aqui
	}

	@Override	//precisa colocar exception
	public void aterrissar(AviaoInterface aviao) {
		if (aviao.getStatus() == 2 && quatidadeDePistas > 0) {
			System.out.println("O avi�o de c�d "+aviao.getCod()+" aterrissou");
			aviao.setStatus(0);
		}
		else System.out.println("O aviao n�o pode aterrissar"); //tratar exe��o aqui
	}
}
