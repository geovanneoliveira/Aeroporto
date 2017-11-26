package oo.aeroporto.aviao;

import oo.aeroporto.aviao.interf.AirbusInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public class Airbus extends Aviao implements AirbusInterface {
	
	//Constructor
	public Airbus(int cod, int capacidade) {
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
				s += ("\nModelo do Avião: Airbus");
		return s;
		
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
	

	public String servirRefeicao() {
		String s = "A refeição foi servida";
		return s;
	}

}
