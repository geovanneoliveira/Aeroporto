package oo.aeroporto.aviao;

import oo.aeroporto.aviao.interf.AirbusInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public class Airbus extends Aviao implements AirbusInterface {

	//Attributes
	
	//Constructor
	public Airbus(int cod, int capacidade) {
		super(cod, capacidade);
		// TODO Comissario.size() == 3 & piloto.getHorasDeVoo() > 1000
	}
	
	@Override
	public void listarInformacoes() {
		System.out.println("Modelo do Avião: Airbus");
		super.listarInformacoes();
		
	}
	
	@Override
	public void adicionarPiloto(PilotoInterface piloto) {
		if (piloto.getHorasDeVoo() >= 1000) super.adicionarPiloto(piloto);
		else System.out.println("Não é possível adicionar esse pilot, ele não tem as horas de voo necessarias");
	}
	
	@Override
	public int checkList(){
		if (this.quantComissarios() >= 3) return super.checkList();
		else {
			System.out.println("Quantidade de Comissarios insuficiente");
			return 1;
		}
	}
	

	public void servirRefeicao() {
		System.out.println("A refeição foi servida");
	}

}
