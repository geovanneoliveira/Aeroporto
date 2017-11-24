package oo.aeroporto.aviao;

import oo.aeroporto.aviao.interf.BoeingInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public class Boeing extends Aviao  implements BoeingInterface{
	
	//Attributes
	
	
	//Constructor
	public Boeing(int cod, int capacidade) {
		super(cod, capacidade);
		// TODO Comissario.size() == 2 && piloto.getHorasDeVoo() > 800
	}
	

	@Override
	public void listarInformacoes() {
		System.out.println("Modelo do Avi�o: Boening");
		super.listarInformacoes();
		
	}
	
	@Override
	public void adicionarPiloto(PilotoInterface piloto) {
		if (piloto.getHorasDeVoo() >= 800) super.adicionarPiloto(piloto);
		else System.out.println("N�o � poss�vel adicionar esse pilot, ele n�o tem as horas de voo necessarias");
	}
	
	@Override
	public int checkList(){
		if (this.quantComissarios() >= 2) return super.checkList();
		else {
			System.out.println("Quantidade de Comissarios insuficiente");
			return 1;
		}
	}
	
	public void massagem() {
		System.out.println("A massagem est� sendo aplicadas nos clientes");
		
	}

}
