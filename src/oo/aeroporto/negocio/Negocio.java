package oo.aeroporto.negocio;


import oo.aeroporto.controle.Companhia;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.repositorio.*;
import oo.aeroporto.repositorio.interf.*;


public class Negocio implements NegocioInterf{

	//attributes
	private RepAviaoInterf repositorioAviao;
	private RepPilotoInterf repositorioPiloto;
	private RepComissarioInterf repositorioComissario;
	private RepViagemInterf repositorioViagem;
	private RepCompanhiaInterf repositorioCompanhia;
	private RepPassageiroInterf repositorioPassageiro;
	
	public Negocio() {
		
		repositorioAviao = RepAviao.getInstance();
		repositorioPiloto = RepPiloto .getInstance();
		repositorioComissario = RepComissario.getInstance();
		repositorioViagem = RepViagem.getInstance();
		repositorioCompanhia = RepCompanhia.getInstance();
		repositorioPassageiro = RepPassageiro.getInstance();
		
	}
	
	//COMPANHIA
	public CompanhiaInterface CadastrarCompanhia(int id, String nome) throws CompanhiaException {
		
			CompanhiaInterface novaComp = new Companhia(id, nome);
			repositorioCompanhia.adicionar(novaComp);
			return novaComp;
			
	}
	
	public void RemoverCompanhia(CompanhiaInterface companhia) throws CompanhiaException {

			repositorioCompanhia.deletar(companhia);
			companhia = null;
			
	}
	
	public CompanhiaInterface buscarCompanhiaCod(int cod) {
		CompanhiaInterface companhia = null;
		companhia = repositorioCompanhia.buscarPorCod(cod);
		if(companhia == null) {
			System.out.println("Nenhuma Companhia localizada!");
			return companhia;
		}
		System.out.println("Companhia localizada com sucesso!");
		return companhia;
	}
	
	public CompanhiaInterface buscarCompanhiaNome(String nome) {
		CompanhiaInterface companhia = null;
		companhia = repositorioCompanhia.buscarPorNome(nome);
		if(companhia == null) {
			System.out.println("Nenhuma Companhia localizada!");
			return companhia;
		}
		System.out.println("Companhia localizada com sucesso!");
		return companhia;
	}


	
}
