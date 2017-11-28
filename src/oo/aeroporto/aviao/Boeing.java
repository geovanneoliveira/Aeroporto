package oo.aeroporto.aviao;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.BoeingInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public class Boeing extends Aviao  implements BoeingInterface{
	
	//Attributes
	
	
	//Constructor
	public Boeing(int cod, int capacidade) throws AviaoException {
		super(cod, capacidade);
	}
	

	@Override
	public String listarInformacoes() {
		String s = "\nCódigo do Avião: "+ getCod() + "\nCapacidade: "+ getCapacidade();
		if(getPiloto() != null) s+= "\nPiloto: "+getPiloto().getNome();
		if(getCoPiloto() != null) s+= "\nCo-Piloto: "+ getCoPiloto().getNome(); 
		if(getViagem() != null) s+="\nViagem do Avião: "+ getViagem().getCod();
		if(getComissario() != null) s+="\nComissários:" + quantComissarios();
		s += "\nSatus do Avião: "+ getStatus();
		s += ("\nModelo do Avião: Boeing");
		return s;

		
	}
	
	@Override
	public void adicionarPiloto(PilotoInterface piloto) {
		if (piloto.getHorasDeVoo() >= 800) super.adicionarPiloto(piloto);
		else System.out.println("Não é possível adicionar esse piloto ele não tem as horas de voo necessarias");
	}
	
	@Override
	public int checkList(){
		if (this.quantComissarios() >= 2) return super.checkList();
		else {
			System.out.println("Quantidade de Comissarios insuficiente");
			return 1;
		}
	}
	
	public String massagem() {
		String s = "A massagem está sendo aplicadas nos clientes";
		return s;
		
	}

}
