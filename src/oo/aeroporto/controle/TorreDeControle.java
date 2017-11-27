package oo.aeroporto.controle;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.TorreControleException;
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
	public String status() {
		String msg = ("Cód da Torre: "+this.cod);
		msg += ("\nQuantidade de Pistas: "+this.quatidadeDePistas);
		msg += ("\nQuantidade de Pistas atualmente ocupadas: "+this.counter);
		return msg;
	}

	@Override
	public boolean taxi(AviaoInterface aviao) throws TorreControleException{
		if (aviao == null) throw new TorreControleException("Falta Aviao");
		if (aviao.checkList() == 1) 
			return false;
		if (this.counter < this.quatidadeDePistas) {
			this.counter++;
			return true;
		}
		return false;
	}

	@Override
	public void decolar(AviaoInterface aviao) throws TorreControleException{
		if (this.taxi(aviao) == true) {
			this.counter--;
			aviao.setStatus(2);	//analisar o que é isso
		}
		else throw new TorreControleException("Avião com o cheklist ainda incompleto");
	}

	@Override
	public void aterrissar(AviaoInterface aviao) throws TorreControleException{
		if (this.taxi(aviao) == true) {
			aviao.setStatus(0);
			this.counter--;
		}
		else throw new TorreControleException("Avião com o cheklist ainda incompleto");
	}
}
