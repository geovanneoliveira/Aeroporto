package oo.aeroporto.controle;



import java.util.ArrayList;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
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
	public Companhia(int cod, String nome) {
		this(cod,nome,null,null,null);
	}
	
	public Companhia(int cod, String nome, ArrayList<AviaoInterface> aviao, ArrayList<PilotoInterface> piloto, 
			ArrayList<ComissarioInterface> comissario) {
		this(cod,nome,aviao,piloto,comissario,null);
	}
	
	public Companhia(int cod, String nome, ArrayList<AviaoInterface> aviao, ArrayList<PilotoInterface> piloto, 
			ArrayList<ComissarioInterface> comissario, ArrayList<ViagemInterface> viagem) {
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
	public void listarInformacoes() {

		System.out.println("Nome: " + this.nome + " cod: " + this.cod);
		System.out.println("Avião (ões): ");
		for(int i = 0 ; i < aviao.size(); i++){
			System.out.print(i+1 + " ");
			aviao.get(i).listarIdentificacao();
			
		}
		System.out.println("\nPiloto(s): ");
		for(int i = 0 ; i < piloto.size(); i++){
			System.out.print(i+1 + " ");
			piloto.get(i).listarIdentificador();
			
		}
		System.out.println("\nComissario(s): ");
		for(int i = 0 ; i < comissario.size(); i++){
			System.out.print(i+1 + " ");
			comissario.get(i).listarIdentificador();
			
		}System.out.println("\nViagem(ns): ");
		for(int i = 0 ; i < viagem.size(); i++){
			System.out.print(i+1 + " ");
			viagem.get(i).listarIdentificacoes();
			
		}
		
	}

	@Override
	public void inserirPiloto(PilotoInterface piloto) throws Exception{  //C
		if(piloto == null)  {
			throw new Exception("aeee");
			
		}else {
			this.piloto.add(piloto);	
			this.repositorioPiloto.adicionar(piloto);
		}
		
	}

	@Override
	public void removerPiloto(PilotoInterface piloto) {
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
	public void inserirComissario(ComissarioInterface comissario) {
		this.comissario.add(comissario);
		this.repositorioComissario.adicionar(comissario);
	}

	@Override
	public void removerComissario(ComissarioInterface comissario) {
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
	public void inserirAviao(AviaoInterface aviao) {
		this.aviao.add(aviao);
		this.repositorioAviao.adicionar(aviao);
	}

	@Override
	public void removerAviao(AviaoInterface aviao) {
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
	public void inserirViagem(ViagemInterface viagem) {
		this.viagem.add(viagem);
		this.repositorioViagem.adicionar(viagem);
	}

	@Override
	public void removerViagem(ViagemInterface viagem) {
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
