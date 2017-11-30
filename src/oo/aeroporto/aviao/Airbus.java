package oo.aeroporto.aviao;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public class Airbus extends Aviao implements AviaoInterface{
	
	//Constructor
	public Airbus(int cod, int capacidade) {
		super(cod, capacidade);
	}
	
	@Override
	public String listarInformacoes() {
		String s = super.listarInformacoes();
		s += ("\nModelo do Avião: Airbus");
		return s;
	}
	
	@Override
	public void adicionarPiloto(PilotoInterface piloto) throws AviaoException {
		if (piloto == null) throw new AviaoException("Piloto Inválido");
		else if (piloto.getHorasDeVoo() < 1000) throw new AviaoException("Piloto não possui as horas de voo necessárias");
		else super.adicionarPiloto(piloto);
	}
	
	@Override
	public boolean checkList() {
		if (this.quantComissarios() < 1) return false;
		else return super.checkList();
	}
}
