package oo.aeroporto.controle;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.TorreControleException;
import oo.aeroporto.controle.interf.TorreControleInterface;

public class TorreDeControle implements TorreControleInterface{

	//Attributes
	private int cod;
	private int quantidadeDePistas;
	private int counter = 0;
	
	//Constructor
	public TorreDeControle(int cod, int quantidadeDePistas) {
		this.cod = cod;
		this.quantidadeDePistas = quantidadeDePistas;
	}

	//Setters e Getters
	public int getCod() {
		return cod;
	}

	public int getQuantidadeDePistas() {
		return quantidadeDePistas;
	}

	public void setQuantidadeDePistas(int quantidadeDePistas) {
		this.quantidadeDePistas = quantidadeDePistas;
	}
	
	//Methods

	@Override
	public String status() {
		String msg = ("C�d da Torre: "+this.cod);
		msg += ("\nQuantidade de Pistas: "+this.quantidadeDePistas);
		msg += ("\nQuantidade de Pistas atualmente ocupadas: "+this.counter);
		return msg;
	}


	private void taxi(AviaoInterface aviao) throws TorreControleException{
		if (aviao == null) throw new TorreControleException("Falta Aviao");
		else if (aviao.checkList() == false) throw new TorreControleException("Checklist Incompleto");
		else if (aviao.getStatus() == 1) throw new TorreControleException("O avi�o j� est� na pista");
		else if (this.counter >= this.quantidadeDePistas) throw new TorreControleException("As pistas est�o lotadas");
		else {
			this.counter++;
			aviao.setStatus(1);
		}
	}

	@Override
	public void decolar(AviaoInterface aviao) throws TorreControleException{
		try {
			this.taxi(aviao);
			this.counter--;
			aviao.setStatus(2);
		}catch(TorreControleException e) {
			throw new TorreControleException("Avi�o com o taxi negado\nMotivo: "+e.getMessage());
		}
	}

	@Override
	public void aterrissar(AviaoInterface aviao) throws TorreControleException{
		try {
			this.taxi(aviao);
			this.counter--;
			aviao.setStatus(0);
		}catch (TorreControleException e){
			throw new TorreControleException("Avi�o com o taxi negado\nMotivo: "+e.getMessage());
		}
	}
}
