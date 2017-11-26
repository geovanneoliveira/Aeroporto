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
		String s = "\nC�digo do Avi�o: "+ getCod() + "\nCapacidade: "+ getCapacidade();
				if(getPiloto() != null) s+= "\nPiloto: "+getPiloto().getNome();
				if(getCoPiloto() != null) s+= "\nCo-Piloto: "+ getCoPiloto().getNome(); 
				if(getViagem() != null) s+="\nViagem do Avi�o: "+ getViagem().getCod();
				if(getComissario() != null) s+="\nComiss�rios:" + quantComissarios();
				s += "\nSatus do Avi�o: "+ getStatus();
				s += ("\nModelo do Avi�o: Airbus");
		return s;
		
	}
	
	@Override
	public void adicionarPiloto(PilotoInterface piloto) {
		if (piloto.getHorasDeVoo() >= 1000) super.adicionarPiloto(piloto);
		else System.out.println("N�o � poss�vel adicionar esse pilot, ele n�o tem as horas de voo necessarias");
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
		String s = "A refei��o foi servida";
		return s;
	}

}
