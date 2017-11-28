package oo.aeroporto.aviao;

import java.util.ArrayList;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;
import oo.aeroporto.repositorio.RepAviao;
import oo.aeroporto.repositorio.interf.RepAviaoInterf;



public abstract class Aviao implements AviaoInterface{

	//Attributes
	private int cod;
	private int capacidade;
	private int status; 
	private PilotoInterface piloto;
	private PilotoInterface coPiloto;
	private ViagemInterface viagem;
	private ArrayList<ComissarioInterface> comissario = new ArrayList<ComissarioInterface>();
	private RepAviaoInterf repAviao;
	
	//Constructor
	public Aviao(int cod, int capacidade) {
		this.cod = cod;
		this.capacidade = capacidade;
		this.piloto = null;
		this.coPiloto = null;
		this.viagem = null;
		this.comissario = null;
		this.status = 0;
		
		repAviao = RepAviao.getInstance();
		repAviao.adicionar(this);
	}
			
	
	//Method
	
	public String listarInformacoes() {
		return null;
	}
	
	
	public String listarIdentificacao() {
		String s = "Código do avião: " + this.cod;
		return s;
	}

	public void adicionarPiloto(PilotoInterface piloto) {
		if(piloto.getBreve() > -1) {
			this.piloto = piloto;
		}
	}

	public void adicionarCoPiloto(PilotoInterface coPiloto) {
		if(piloto.getBreve() > -1) {
			this.coPiloto = coPiloto;
		}		
	}

	public void adicionarViagem(ViagemInterface viagem) {
		if((viagem.passageirosQuantidade() <= this.capacidade)) {
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

	public int checkList(){
		if(this.piloto != null)
			if(this.coPiloto != null)
				if(this.comissario.size() > 0)
					if(viagem != null) return 0;
				
		return 1;		
			
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
		return this.comissario.size();
	}
	

}
