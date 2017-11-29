package oo.aeroporto.aviao;

import java.util.ArrayList;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;


public abstract class Aviao implements AviaoInterface{

	//Attributes
	private int cod;
	private int capacidade;
	private int status; 
	private PilotoInterface piloto;
	private PilotoInterface coPiloto;
	private ViagemInterface viagem;
	private ArrayList<ComissarioInterface> comissario = new ArrayList<ComissarioInterface>();
	
	//Constructor
	public Aviao(int cod, int capacidade){
		this.cod = cod;
		this.capacidade = capacidade;
		this.piloto = null;
		this.coPiloto = null;
		this.viagem = null;
		this.comissario = null;
		this.status = 0;
	}
			
	
	//Method
	
	public String listarInformacoes() {
		String s = "\nCódigo do Avião: "+ getCod() + "\nCapacidade: "+ getCapacidade();
		if(getPiloto() != null) s+= "\nPiloto: "+getPiloto().getNome();
		if(getCoPiloto() != null) s+= "\nCo-Piloto: "+ getCoPiloto().getNome(); 
		if(getViagem() != null) s+="\nViagem do Avião: "+ getViagem().getCod();
		if(getComissario() != null) s+="\nComissários:" + quantComissarios();
		s += "\nSatus do Avião: "+ getStatus();
		return s;
	}
	
	
	public String listarIdentificacao() {
		String s = "Código do avião: " + this.cod;
		return s;
	}

	public void adicionarPiloto(PilotoInterface piloto) throws AviaoException{
		if (piloto == null) throw new AviaoException ("Piloto Inválido");
		else if (piloto.getBreve() == -1) throw new AviaoException("Piloto com breve incorreto");
		else this.piloto = piloto;
	}

	public void adicionarCoPiloto(PilotoInterface coPiloto) throws AviaoException{
		if (coPiloto == null) throw new AviaoException ("Co-Piloto Inválido");
		else if (coPiloto.getBreve() == -1) throw new AviaoException("Co-Piloto com Brevê incorreto");
		else this.coPiloto = coPiloto;
	}

	public void adicionarViagem(ViagemInterface viagem) {
		if((viagem.getPassageirosQuantidade() <= this.capacidade)) {
			this.viagem = viagem;
		}
	}
	
	public void adicionarComissario(ComissarioInterface comissario) {
		if(comissario.getANAC() > -1) {
			this.comissario.add(comissario);	
		}
	}

	public int getCod(){
		return cod;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public PilotoInterface getPiloto() {
		return piloto;
	}


	public PilotoInterface getCoPiloto() {
		return coPiloto;
	}


	public ViagemInterface getViagem() {
		return viagem;
	}

	public ArrayList<ComissarioInterface> getComissario() {
		return comissario;
	}

	public boolean checkList(){
		if(this.piloto != null)
			if(this.coPiloto != null)
				if(this.comissario.size() > 0)
					if(viagem != null) return true;
				
		return false;		
			
	}

	public int getStatus(){
		return this.status;
	}

	public void setStatus(int n) {
		this.status = n;
	}

	public void retirarTodos(){
		if(this.status == 0) {
			this.piloto = null;
			this.coPiloto = null;
			this.viagem = null;
			this.comissario = null;
		}
	}
	
	public int quantComissarios() {
		if (this.comissario == null) return 0;
		return this.comissario.size();
	}
	

}
