package oo.aeroporto.view;



import java.util.Date;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.TorreControleException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.controle.interf.TorreControleInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.negocio.*;
import oo.aeroporto.pessoa.Passageiro;
import oo.aeroporto.pessoa.Piloto;
import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PassageiroInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public class Fachada {

	NegocioInterf negocio = null;
	
	//Constructor
	public Fachada(int quantidade) {
		negocio = new Negocio(quantidade);
	}
	
	
	//Buttons
	
	//TORRE DE CONTROLE
	public TorreControleInterface obterTorre() {
		return negocio.obterTorre();
	}
	
	public void clickDecolarAviao(AviaoInterface aviao) throws AviaoException, TorreControleException{
		if (aviao == null) throw new AviaoException("Avião Inválido");
		negocio.decolar(aviao);
	}
	
	public void clickPousarAviao(AviaoInterface aviao) throws AviaoException, TorreControleException {
		if (aviao == null) throw new AviaoException("Avião Inválido");
		negocio.aterrissar(aviao);
	}
	//COMPANHIA
	
	public CompanhiaInterface clickCadastrarCompanhia(int id, String nome) throws CompanhiaException {
		CompanhiaInterface companhia = null;
		companhia = negocio.CadastrarCompanhia(id, nome);
		return companhia;
	}
	
	public CompanhiaInterface clickRemoverCompanhia(CompanhiaInterface companhia) throws CompanhiaException {
			negocio.RemoverCompanhia(companhia);
			return null;
	}
	
	
	public CompanhiaInterface clickBuscarCompanhiaPorCod(int cod) throws CompanhiaException{
		CompanhiaInterface companhia = null;
		companhia = negocio.buscarCompanhiaCod(cod);
		if(companhia == null) throw new CompanhiaException("Nenhuma Companhia localizada!");
		else return companhia;
	}
	
	public CompanhiaInterface clickBuscarCompanhiaPorNome(String nome) throws CompanhiaException {
		CompanhiaInterface companhia = null;
		companhia = negocio.buscarCompanhiaNome(nome);
		if(companhia == null) throw new CompanhiaException("Nenhuma Companhia localizada!");
		else return companhia;
	}
	
	
	//PILOTO
	
	public PilotoInterface clickCadastrarPiloto(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) throws PilotoException, CompanhiaException {
		PilotoInterface piloto = null;
		piloto = negocio.CadastrarPiloto(companhia, CPF, nome, idade, telefoneProprio, CTPS, breve, horasDeVoo);
		return piloto;

	}
	
	public PilotoInterface clickRemoverPiloto(CompanhiaInterface companhia, PilotoInterface piloto) throws PilotoException, CompanhiaException {
		if (piloto == null) throw new PilotoException("Piloto Invalido");
		else if (companhia == null)	throw new CompanhiaException("Companhia nao existe");
		negocio.RemoverPiloto(companhia, piloto);
		return null;
		
	}
	
	public PilotoInterface clickBuscarPiloto(CompanhiaInterface companhia, int cod) throws PilotoException{
		PilotoInterface piloto = null;
		piloto = negocio.buscarPiloto(companhia,cod);
		if (piloto == null) throw new PilotoException("Nenhum Piloto localizado!");
		else return piloto;
	}
	
	//COMISSARIO
	
	public ComissarioInterface clickCadastrarComissario(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS,int ANAC) throws ComissarioException, CompanhiaException {
		ComissarioInterface comissario = null;
		comissario = negocio.cadastrarComissrio(companhia, CPF, nome, idade, telefoneProprio, CTPS, ANAC);
		return comissario;
		
	}
	
	public ComissarioInterface clickRemoverComissario(CompanhiaInterface companhia, ComissarioInterface comissario) throws ComissarioException, CompanhiaException {
		if (comissario == null) throw new ComissarioException("comissario Invalido");
		else if (companhia == null)	throw new CompanhiaException("Companhia nao existe");	
		negocio.removerComissario(companhia, comissario);
		return null;
		
	}
	
	public ComissarioInterface clickBuscarComissario(CompanhiaInterface companhia, int cod) throws CompanhiaException {
		ComissarioInterface comissario = null;
		comissario = negocio.buscarComissario(companhia, cod);
		if (comissario == null) throw new CompanhiaException("Nenhum Comissario localizado!");
		else return comissario;
	}
	
	//PASSAGEIRO
	
	public PassageiroInterface cadastrarPassageiro(ViagemInterface v,String CPF, String nome, int idade, String telefoneProprio, String telefoneDeEmergencia) throws PassageiroException, ViagemException {
			PassageiroInterface passageiro = null;
			passageiro = negocio.cadastrarPassageiro(v, CPF, nome, idade, telefoneProprio, telefoneDeEmergencia);
			return passageiro;
		
	}
	
	public PassageiroInterface clickRemoverPassageiro(ViagemInterface v, PassageiroInterface passageiro) throws PassageiroException, ViagemException {
		if (passageiro == null) throw new PassageiroException("Passageiro Invalido");
		else if (v == null)	throw new ViagemException("Viagem nao existe");		
		negocio.removerPassageiro(v,passageiro);
		return null;
			
	}
	
	public PassageiroInterface clickBuscarPassageiroPorCod(ViagemInterface v, String cod) throws ViagemException, PassageiroException {
		PassageiroInterface passageiro = null;
		passageiro = negocio.buscarPassageiroCod(v,cod);
		if (passageiro == null) throw new PassageiroException("Nenhum Passageiro localizado!");
		else return passageiro;
	}
	
	public PassageiroInterface clickBuscarPassageiroPorNome(String nome) throws PassageiroException{
		PassageiroInterface passageiro = null;
		passageiro = negocio.buscarPassageiroNome(nome);
		if (passageiro == null) throw new PassageiroException("Nenhum Passageiro localizado!");
		else return passageiro;
	}
	
	
	// VIAGEM
	public ViagemInterface cadastrarViagem(CompanhiaInterface companhia, int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque, Date dataHoraDeDesembarque,int vagasDisponiveis) throws ViagemException, CompanhiaException {
		ViagemInterface viagem = null;
			viagem = negocio.cadastrarViagem(companhia, cod, aeroportoOrigem, aeroportoDestino, dataHoraDeEmbarque, dataHoraDeDesembarque, vagasDisponiveis);
			return viagem;

		
	}
	
	public ViagemInterface removerViagem(CompanhiaInterface companhia, ViagemInterface viagem) throws ViagemException, CompanhiaException{
		if (viagem == null) throw new ViagemException("Viagem Invalido");
		else if (companhia == null)	throw new CompanhiaException("Companhia nao existe");		
		negocio.removerViagem(companhia, viagem);
		return null;
	}
	
	public ViagemInterface buscarViagem(CompanhiaInterface companhia, int cod) throws CompanhiaException, ViagemException {
		ViagemInterface viagem = null;
			viagem = negocio.buscarViagem(companhia, cod);
			if(viagem == null) throw new ViagemException("A Viagem não foi localizada");
			else return viagem;
		
	}
	
	
	// AVIAO
	public AviaoInterface cadastraAviao(CompanhiaInterface companhia, int cod, int capacidade, String modelo) throws CompanhiaException, AviaoException {
		AviaoInterface aviao = null;
			aviao = negocio.cadastrarAviao(companhia,cod, capacidade, modelo);
			return aviao;
		
	}
	
	public AviaoInterface removerAviao(CompanhiaInterface companhia, AviaoInterface aviao) throws CompanhiaException, AviaoException {
		if (aviao == null) throw new AviaoException("Avião Invalido");
		else if (companhia == null)	throw new CompanhiaException("Companhia nao existe");
		negocio.removerAviao(companhia, aviao);
		return null;
	}
	
	public AviaoInterface buscarAviao(CompanhiaInterface companhia, int cod) throws CompanhiaException, AviaoException {
		AviaoInterface aviao = null;
		aviao = negocio.buscarAviao(companhia, cod);
		if (aviao == null) throw new AviaoException("Nenhum Aviao localizado!");
		else return aviao;
	}
	
}
