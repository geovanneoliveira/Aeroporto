package oo.aeroporto.negocio;


import java.sql.Date;

import oo.aeroporto.aviao.Airbus;
import oo.aeroporto.aviao.Aviao;
import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.Companhia;
import oo.aeroporto.controle.Viagem;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.Comissario;
import oo.aeroporto.pessoa.Passageiro;
import oo.aeroporto.pessoa.Piloto;
import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PassageiroInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;
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
			return companhia;
		}
		return companhia;
	}
	
	public CompanhiaInterface buscarCompanhiaNome(String nome) {
		CompanhiaInterface companhia = null;
		companhia = repositorioCompanhia.buscarPorNome(nome);
		
		if(companhia == null) {
			return companhia;
		}
		return companhia;
	}

	//PILOTO
	
	public PilotoInterface CadastrarPiloto(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) throws PilotoException {
	
		PilotoInterface piloto = new Piloto(CPF, nome, idade, telefoneProprio, CTPS, breve, horasDeVoo);
		repositorioPiloto.adicionar(piloto);
		return piloto;
	}

	public void RemoverPiloto(PilotoInterface piloto) throws PilotoException {
		repositorioPiloto.deletar(piloto);
		piloto = null;
	}
	
	public PilotoInterface buscarPiloto(int cod) {
		PilotoInterface piloto = null;
		piloto = repositorioPiloto.buscarPorCod(cod);
		
		if(piloto == null) {
			return piloto;
		}
		return piloto;
	}
	
	public double obterHorasDeVoo(PilotoInterface piloto) throws PilotoException {
		if(piloto == null) {
			throw new PilotoException("Piloto inválido!");
		}
		double horas =  piloto.getHorasDeVoo();
		return horas;
	}
	
	// COMISSARIO
	
	public ComissarioInterface cadastrarComissrio(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int ANAC) throws ComissarioException {
		ComissarioInterface comissario = new Comissario(CPF, nome, idade, telefoneProprio, CTPS, ANAC);
		repositorioComissario.adicionar(comissario);
		return comissario;
	}
	
	public void removerComissario(ComissarioInterface comissario) throws ComissarioException {
		repositorioComissario.deletar(comissario);
		comissario = null;
	}
	
	public ComissarioInterface buscarComissario(int cod) {
		ComissarioInterface comissario = null;
		comissario = repositorioComissario.buscarPorCod(cod);
		
		if(comissario == null) {
			return comissario;
		}
		return comissario;
	}
	
	// PASSAGEIRO
	
	public PassageiroInterface cadastrarPassageiro(String CPF, String nome, int idade, String telefoneProprio, String telefoneDeEmergencia) throws PassageiroException {
		PassageiroInterface passageiro = new Passageiro(CPF, nome, idade, telefoneProprio, telefoneDeEmergencia);
		repositorioPassageiro.adicionar(passageiro);
		return passageiro;
	}
	
	public void removerPassageiro(PassageiroInterface passageiro) throws PassageiroException {
		repositorioPassageiro.deletar(passageiro);
		passageiro = null;
	}
	
	public PassageiroInterface buscarPassageiroCod(String cod) {
		PassageiroInterface passageiro = null;
		passageiro = repositorioPassageiro.buscarPorCod(cod);
		
		if(passageiro == null) {
			return passageiro;
		}
		return passageiro;
	}
	
	public PassageiroInterface buscarPassageiroNome(String nome) {
		PassageiroInterface passageiro = null;
		passageiro = repositorioPassageiro.buscarPorNome(nome);
		
		if(passageiro == null) {
			return passageiro;
		}
		return passageiro;
	}
	
	// VIAGEM
	
	public ViagemInterface cadastrarViagem(int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque, Date dataHoraDeDesembarque,int vagasDisponiveis) throws ViagemException {
		ViagemInterface viagem = new Viagem(cod, aeroportoOrigem, aeroportoDestino, dataHoraDeEmbarque, dataHoraDeDesembarque, vagasDisponiveis);
		repositorioViagem.adicionar(viagem);
		return viagem;
	}
	
	public void removerViagem(ViagemInterface viagem) throws ViagemException {
		repositorioViagem.deletar(viagem);
		viagem = null;
	}
	
	public ViagemInterface buscarViagem(int cod) {
		ViagemInterface viagem = null;
		viagem = repositorioViagem.buscarPorCod(cod);
		
		if(viagem == null) {
			return viagem;
		}
		return viagem;	
		
	}
	
	// AVIAO
	
	public AviaoInterface cadastraAviao(int cod, int capacidade, String modelo) throws AviaoException {
		if(modelo.equals("airbus")) {
			AviaoInterface aviao = new Airbus(cod,capacidade);
			repositorioAviao.adicionar(aviao);
			return aviao;
		}else if(modelo.equals("boeing")) {
			AviaoInterface aviao = new Airbus(cod,capacidade);
			repositorioAviao.adicionar(aviao);
			return aviao;
		}
		return null;
	}
	
	public void removerAviao(AviaoInterface aviao) throws AviaoException {
		repositorioAviao.deletar(aviao);
		aviao = null;
	}
	
	public AviaoInterface buscarAviao(int cod) {
		AviaoInterface aviao = null;
		aviao = repositorioAviao.buscarPorCod(cod);
		
		if(aviao == null) {
			return aviao;
		}
		return aviao;	
	}
}
