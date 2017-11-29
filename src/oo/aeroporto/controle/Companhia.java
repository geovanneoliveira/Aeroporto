package oo.aeroporto.controle;



import java.util.ArrayList;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public class Companhia  implements CompanhiaInterface {

	//Attributes
	private int cod;
	private String nome;
	private ArrayList<AviaoInterface> aviao = new ArrayList<AviaoInterface>();
	private ArrayList<PilotoInterface> piloto = new ArrayList<PilotoInterface>();
	private ArrayList<ComissarioInterface> comissario = new ArrayList<ComissarioInterface>();
	private ArrayList<ViagemInterface> viagem = new ArrayList<ViagemInterface>();


	
	//Constructor
	public Companhia(int cod, String nome) throws CompanhiaException {
		this(cod,nome,null,null,null);
	}
	
	public Companhia(int cod, String nome, ArrayList<AviaoInterface> aviao, ArrayList<PilotoInterface> piloto, 
			ArrayList<ComissarioInterface> comissario) throws CompanhiaException {
		this(cod,nome,aviao,piloto,comissario,null);
	}
	
	public Companhia(int cod, String nome, ArrayList<AviaoInterface> aviao, ArrayList<PilotoInterface> piloto, 
			ArrayList<ComissarioInterface> comissario, ArrayList<ViagemInterface> viagem) throws CompanhiaException {
		this.cod = cod;
		this.nome = nome;
		
		if(aviao != null) 		this.aviao = aviao;
		if(piloto != null)		this.piloto = piloto;
		if(comissario !=null)	this.comissario = comissario;
		if(viagem != null)		this.viagem = viagem;
		
	}
	
	//Getters e Setters
	public int getCod() {
		return this.cod;
	}
	
	public String getNome() {
		return this.nome;
	}

	public ArrayList<AviaoInterface> getAviao() {
		return aviao;
	}

	public ArrayList<PilotoInterface> getPiloto() {
		return piloto;
	}

	public ArrayList<ComissarioInterface> getComissario() {
		return comissario;
	}

	public ArrayList<ViagemInterface> getViagem() {
		return viagem;
	}
		

	@Override
	public String listarInformacoes() {
		
		String s = ("\nNome: " + this.nome + "\ncod: " + this.cod);
		
		if(aviao != null) {
			s += ("\nAvião (ões): ");
			for(int i = 0 ; i < aviao.size(); i++){
				s += (i+1 + " ");
				s += aviao.get(i).listarIdentificacao();
				
			}
		}
		
		if(piloto != null) {
			s += ("\nPiloto(s): ");
			for(int i = 0 ; i < piloto.size(); i++){
				s +=(i+1 + " ");
				s += piloto.get(i).listarIdentificador();
				
			}
		}
		
		if(comissario != null) {
			s += ("\nComissario(s): ");
			for(int i = 0 ; i < comissario.size(); i++){
				s += (i+1 + " ");
				s += comissario.get(i).listarIdentificador();
			}
				
		}
		
		if(viagem != null) {
			s +=("\nViagem(ns): ");
			for(int i = 0 ; i < viagem.size(); i++){
				s +=(i+1 + " ");
				s += viagem.get(i).listarIdentificador();
				
			}
		}
		
		return s;
	}

	@Override
	public void inserirPiloto(PilotoInterface piloto) throws CompanhiaException {  //C
		if(piloto == null)  {
			throw new CompanhiaException("Piloto inválido.");
		}
		if(this.buscarPiloto(piloto.getBreve()) != null){
			throw new CompanhiaException("Esse piloto já pertence a essa companhia.");
		}
		this.piloto.add(piloto);
		
	}

	@Override
	public void removerPiloto(PilotoInterface piloto) throws PilotoException {
		if (piloto == null) throw new PilotoException("Piloto inválido");
		else if (this.buscarPiloto(piloto.getBreve()) == null) throw new PilotoException("Esse piloto não existe nessa companhia");
		else this.piloto.remove(piloto);
	}

	@Override
	public PilotoInterface buscarPiloto(int codigo) {
		
		for(int i = 0; i < piloto.size(); ++i) {

			if(piloto.get(i).getBreve() == codigo) {
				return piloto.get(i);
			}
		}
		return null;
	}

	@Override
	public void inserirComissario(ComissarioInterface comissario) throws ComissarioException {
		if (comissario == null) throw new ComissarioException("Comissário Inválido");
		else if (this.buscarComissario(comissario.getANAC()) != null) throw new ComissarioException("Esse comissário já pertence a companhia");
		else this.comissario.add(comissario);
	}

	@Override
	public void removerComissario(ComissarioInterface comissario) throws ComissarioException {
		if (comissario == null) throw new ComissarioException("Comissário Inválido");
		else if (this.buscarComissario(comissario.getANAC()) == null) throw new ComissarioException("Esse Comissário não existe nessa companhia");
		else this.comissario.remove(comissario);
	}

	@Override
	public ComissarioInterface buscarComissario(int codigo) {
		
		for(int i = 0; i < comissario.size(); ++i) {
			
			if(this.comissario.get(i).getANAC() == codigo) {
				
				return this.comissario.get(i);
			}
		}
		return null;
	}


	@Override
	public void inserirAviao(AviaoInterface aviao) throws AviaoException {
		if (aviao == null) throw new AviaoException("Avião Inválido");
		else if (this.buscarAviao(aviao.getCod()) != null) throw new AviaoException("O Avião já existe nessa Companhia");
		else this.aviao.add(aviao);
	}

	@Override
	public void removerAviao(AviaoInterface aviao) throws AviaoException {
		if (aviao == null) throw new AviaoException("Avião Inválido");
		else if (this.buscarAviao(aviao.getCod()) == null) throw new AviaoException("Esse avião não existe nessa companhia");
		else this.aviao.remove(aviao);
	}

	@Override
	public AviaoInterface buscarAviao(int codigo) {
		
		for(int i = 0; i < aviao.size(); ++i) {
			
			if(this.aviao.get(i).getCod() == codigo) {
				
				return this.aviao.get(i);
			}
		}
		return null;
	}

	@Override
	public void inserirViagem(ViagemInterface viagem) throws ViagemException {
		if (viagem == null) throw new ViagemException("Viagem inválida");
		else if (this.buscarViagem(viagem.getCod()) != null) throw new ViagemException("Essa viagem já está adicionada nessa companhia");
		else this.viagem.add(viagem);
	}

	@Override
	public void removerViagem(ViagemInterface viagem) throws ViagemException {
		if (viagem == null) throw new ViagemException("Viagem Inválida");
		else if (this.buscarViagem(viagem.getCod()) == null) throw new ViagemException("Essa viagem não existe nessa companhia");
		else this.viagem.remove(viagem);	
	}

	@Override
	public ViagemInterface buscarViagem(int codigo) {
		
		for(int i = 0; i < viagem.size(); ++i) {
			
			if(this.viagem.get(i).getCod() == codigo) {
				
				return this.viagem.get(i);
			}
		}
		return null;
	}
}
