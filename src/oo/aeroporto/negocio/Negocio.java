package oo.aeroporto.negocio;


import java.util.Date;

import oo.aeroporto.aviao.Airbus;
import oo.aeroporto.aviao.Aviao;
import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.Companhia;
import oo.aeroporto.controle.TorreDeControle;
import oo.aeroporto.controle.Viagem;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.TorreControleException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.controle.interf.TorreControleInterface;
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
	private TorreControleInterface torreDeControle;
	
	public Negocio(int quantidade) {
		
		repositorioAviao = RepAviao.getInstance();
		repositorioPiloto = RepPiloto .getInstance();
		repositorioComissario = RepComissario.getInstance();
		repositorioViagem = RepViagem.getInstance();
		repositorioCompanhia = RepCompanhia.getInstance();
		repositorioPassageiro = RepPassageiro.getInstance();
		torreDeControle = TorreDeControle.getInstance(quantidade);
		
	}
	
	//TORRE DE CONTROLE
	public TorreControleInterface obterTorre() {
		return torreDeControle;
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
		return companhia;
	}
	
	public CompanhiaInterface buscarCompanhiaNome(String nome) {
		CompanhiaInterface companhia = null;
		companhia = repositorioCompanhia.buscarPorNome(nome);
		return companhia;
	}

	//PILOTO
	
	public PilotoInterface CadastrarPiloto(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) throws PilotoException, CompanhiaException {
		if (companhia == null) throw new CompanhiaException("Companhia Inválida");
		PilotoInterface piloto = new Piloto(CPF, nome, idade, telefoneProprio, CTPS, breve, horasDeVoo);
		companhia.inserirPiloto(piloto);
		repositorioPiloto.adicionar(piloto);
		return piloto;
	}

	public void RemoverPiloto(CompanhiaInterface companhia, PilotoInterface piloto) throws PilotoException, CompanhiaException {
		companhia.removerPiloto(piloto);
		repositorioPiloto.deletar(piloto);
		piloto = null;
	}
	
	public PilotoInterface buscarPiloto(CompanhiaInterface companhia, int cod) {
		PilotoInterface piloto = null;
		piloto = companhia.buscarPiloto(cod);
		return piloto;
	}
	
		
	
	// COMISSARIO
	//@denini
	
	public ComissarioInterface cadastrarComissrio(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS, int ANAC) throws ComissarioException, CompanhiaException {
		ComissarioInterface comissario = new Comissario(CPF, nome, idade, telefoneProprio, CTPS, ANAC);
		if(companhia == null) throw new CompanhiaException("Companhia Invalida");
		companhia.inserirComissario(comissario);
		repositorioComissario.adicionar(comissario);
		return comissario;
	}
	
	public void removerComissario(CompanhiaInterface companhia, ComissarioInterface comissario) throws ComissarioException, CompanhiaException {
		if(companhia == null) throw new CompanhiaException("Companhia Invalida");
		companhia.removerComissario(comissario);
		repositorioComissario.deletar(comissario);
		comissario = null;
	}
	
	public ComissarioInterface buscarComissario(CompanhiaInterface companhia, int cod) throws CompanhiaException {
		if(companhia == null) throw new CompanhiaException("Companhia Invalida");
		ComissarioInterface comissario = null;
		comissario = companhia.buscarComissario(cod);
		return comissario;
	}
	
	// PASSAGEIRO
	
	public PassageiroInterface cadastrarPassageiro(ViagemInterface v,String CPF, String nome, int idade, String telefoneProprio, String telefoneDeEmergencia) throws PassageiroException, ViagemException {
		if(v == null) throw new ViagemException("Viagem Invalida");
		
		PassageiroInterface passageiro = new Passageiro(CPF, nome, idade, telefoneProprio, telefoneDeEmergencia);
		v.adicionarPassageiro(passageiro);
		repositorioPassageiro.adicionar(passageiro);
		return passageiro;
	}
	
	public void removerPassageiro(ViagemInterface v, PassageiroInterface passageiro) throws PassageiroException, ViagemException {
		if(v == null) throw new ViagemException("Viagem Invalida");
		
		repositorioPassageiro.deletar(passageiro);
		v.retirarPassageiro(passageiro);
		passageiro = null;
	}
	
	public PassageiroInterface buscarPassageiroCod(ViagemInterface v, String CPF) throws ViagemException {
		if(v == null) throw new ViagemException("Viagem Invalida");
		PassageiroInterface passageiro = null;
		passageiro = v.buscarPassageiro(CPF);

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
	
	public ViagemInterface cadastrarViagem(CompanhiaInterface companhia, int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque, Date dataHoraDeDesembarque,int vagasDisponiveis) throws ViagemException, CompanhiaException {
		if(companhia == null) throw new CompanhiaException("Companhia Inválida");
		
		ViagemInterface viagem = new Viagem(cod, aeroportoOrigem, aeroportoDestino, dataHoraDeEmbarque, dataHoraDeDesembarque, vagasDisponiveis);
		companhia.inserirViagem(viagem);
		repositorioViagem.adicionar(viagem);
		return viagem;
	}
	
	public void removerViagem(CompanhiaInterface companhia, ViagemInterface viagem) throws ViagemException, CompanhiaException {
		if(companhia == null) throw new CompanhiaException("Companhia Inválida");
		
		companhia.removerViagem(viagem);
		repositorioViagem.deletar(viagem);
		viagem = null;
		viagem = null;
	}
	
	public ViagemInterface buscarViagem(CompanhiaInterface companhia,int cod) throws CompanhiaException {
		if(companhia == null) throw new CompanhiaException("Companhia Inválida");
		
		ViagemInterface viagem = null;
		viagem = companhia.buscarViagem(cod);
		
		return viagem;	
		
	}
	
	// AVIAO
	
	public AviaoInterface cadastrarAviao(CompanhiaInterface companhia, int cod, int capacidade, String modelo) throws AviaoException, CompanhiaException {
		if(companhia == null) throw new CompanhiaException("Companhia Inválida");
		
		AviaoInterface aviao =null;
		if(modelo.equals("airbus")) {
			aviao = new Airbus(cod,capacidade);
			repositorioAviao.adicionar(aviao);
			companhia.inserirAviao(aviao);
			return aviao;
		}else if(modelo.equals("boeing")) {		//lebrando que so podem ser desse 2 tipos;
			aviao = new Airbus(cod,capacidade);
			repositorioAviao.adicionar(aviao);
			companhia.inserirAviao(aviao);
			return aviao;
		}
		if(aviao == null) throw new AviaoException("Aviao tem que ser airbus ou boenig");
		return null;
	}
	
	public void removerAviao(CompanhiaInterface companhia, AviaoInterface aviao) throws AviaoException, CompanhiaException {
		if(companhia == null) throw new CompanhiaException("Companhia Inválida");
		companhia.removerAviao(aviao);
		repositorioAviao.deletar(aviao);
		aviao = null;
	}
	
	public AviaoInterface buscarAviao(CompanhiaInterface companhia, int cod) throws CompanhiaException {
		if(companhia == null) throw new CompanhiaException("Companhia Inválida");
		
		AviaoInterface aviao = null;
		aviao = companhia.buscarAviao(cod);
		
		return aviao;	
	}
	
	//TORRE DE CONTROLE
	private void taxi(AviaoInterface aviao) throws TorreControleException{
		if (aviao == null) throw new TorreControleException("Falta Aviao");
		else if (aviao.checkList() == false) throw new TorreControleException("Checklist Incompleto");
		else if (aviao.getStatus() == 1) throw new TorreControleException("O avião já está na pista");
		else if (torreDeControle.getCounter() >= torreDeControle.getQuantidadeDePistas()) throw new TorreControleException("As pistas estão lotadas");
		else {
			torreDeControle.setCounter(torreDeControle.getCounter() - 1);
			aviao.setStatus(1);
		}
	}

	@Override
	public void decolar(AviaoInterface aviao) throws TorreControleException{
		try {
			this.taxi(aviao);
			torreDeControle.setCounter(torreDeControle.getCounter() - 1);
			aviao.setStatus(2);
		}catch(TorreControleException e) {
			throw new TorreControleException("Avião com o taxi negado. Motivo: "+e.getMessage());
		}
	}

	@Override
	public void aterrissar(AviaoInterface aviao) throws TorreControleException{
		try {
			this.taxi(aviao);
			torreDeControle.setCounter(torreDeControle.getCounter() - 1);
			aviao.setStatus(0);
		}catch (TorreControleException e){
			throw new TorreControleException("Avião com o taxi negado. Motivo: "+e.getMessage());
		}
	}
}
