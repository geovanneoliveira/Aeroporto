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
import oo.aeroporto.repositorio.RepAviao;
import oo.aeroporto.repositorio.RepComissario;
import oo.aeroporto.repositorio.RepCompanhia;
import oo.aeroporto.repositorio.RepPiloto;
import oo.aeroporto.repositorio.RepViagem;
import oo.aeroporto.repositorio.interf.RepAviaoInterf;
import oo.aeroporto.repositorio.interf.RepComissarioInterf;
import oo.aeroporto.repositorio.interf.RepCompanhiaInterf;
import oo.aeroporto.repositorio.interf.RepPilotoInterf;
import oo.aeroporto.repositorio.interf.RepViagemInterf;

public class Companhia  implements CompanhiaInterface {

	//Attributes
	private int cod;
	private String nome;
	private ArrayList<AviaoInterface> aviao = new ArrayList<AviaoInterface>();
	private ArrayList<PilotoInterface> piloto = new ArrayList<PilotoInterface>();
	private ArrayList<ComissarioInterface> comissario = new ArrayList<ComissarioInterface>();
	private ArrayList<ViagemInterface> viagem = new ArrayList<ViagemInterface>();
	private RepAviaoInterf repositorioAviao;
	private RepPilotoInterf repositorioPiloto;
	private RepComissarioInterf repositorioComissario;
	private RepViagemInterf repositorioViagem;
	private RepCompanhiaInterf repositorioCompanhia;

	
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
		
		this.repositorioAviao = RepAviao.getInstance();
		this.repositorioComissario = RepComissario.getInstance();
		this.repositorioPiloto = RepPiloto.getInstance();
		this.repositorioViagem = RepViagem.getInstance();
		this.repositorioCompanhia = RepCompanhia.getInstance();
		this.repositorioCompanhia.adicionar(this);
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
	
	
	//Method	

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
		this.piloto.remove(piloto);
		this.repositorioPiloto.deletar(piloto);
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
		this.comissario.add(comissario);
		this.repositorioComissario.adicionar(comissario);
	}

	@Override
	public void removerComissario(ComissarioInterface comissario) throws ComissarioException {
		this.comissario.remove(comissario);
		this.repositorioComissario.deletar(comissario);
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
		this.aviao.add(aviao);
		this.repositorioAviao.adicionar(aviao);
	}

	@Override
	public void removerAviao(AviaoInterface aviao) throws AviaoException {
		this.aviao.remove(aviao);
		this.repositorioAviao.deletar(aviao);
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
		this.viagem.add(viagem);
		this.repositorioViagem.adicionar(viagem);
	}

	@Override
	public void removerViagem(ViagemInterface viagem) throws ViagemException {
		this.viagem.remove(viagem);
		this.repositorioViagem.deletar(viagem);
		
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
