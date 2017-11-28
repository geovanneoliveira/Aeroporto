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
		String s = "\nC�digo do Avi�o: "+ getCod() + "\nCapacidade: "+ getCapacidade();
		if(getPiloto() != null) s+= "\nPiloto: "+getPiloto().getNome();
		if(getCoPiloto() != null) s+= "\nCo-Piloto: "+ getCoPiloto().getNome(); 
		if(getViagem() != null) s+="\nViagem do Avi�o: "+ getViagem().getCod();
		if(getComissario() != null) s+="\nComiss�rios:" + quantComissarios();
		s += "\nSatus do Avi�o: "+ getStatus();
		s += ("\nModelo do Avi�o: Boeing");
		return s;

		
	}
	
	@Override
	public void adicionarPiloto(PilotoInterface piloto) {
		if (piloto.getHorasDeVoo() >= 800) super.adicionarPiloto(piloto);
		else System.out.println("N�o � poss�vel adicionar esse piloto ele n�o tem as horas de voo necessarias");
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
		String s = "A massagem est� sendo aplicadas nos clientes";
		return s;
		
	}

}
