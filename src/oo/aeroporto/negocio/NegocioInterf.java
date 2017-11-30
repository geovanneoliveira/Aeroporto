package oo.aeroporto.negocio;

import java.util.Date;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.TorreControleException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.controle.interf.TorreControleInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PassageiroInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public interface NegocioInterf {
	
	
	//TORRE DE CONTROLE
	public TorreControleInterface obterTorre();
	
	//	COMPANHIA
	public CompanhiaInterface CadastrarCompanhia(int id, String nome) throws CompanhiaException;
	
	public void RemoverCompanhia(CompanhiaInterface companhia) throws CompanhiaException;
	
	public CompanhiaInterface buscarCompanhiaCod(int cod);
	
	public CompanhiaInterface buscarCompanhiaNome(String nome);
	
	//	PILOTO
	public PilotoInterface CadastrarPiloto(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) throws PilotoException, CompanhiaException;
	
	public void RemoverPiloto(CompanhiaInterface companhia, PilotoInterface piloto) throws PilotoException, CompanhiaException;
	
	public PilotoInterface buscarPiloto(CompanhiaInterface companhia, int cod);
	
	// COMISSARIO
	public ComissarioInterface cadastrarComissrio(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS, int ANAC) throws ComissarioException, CompanhiaException;
	
	public void removerComissario(CompanhiaInterface companhia, ComissarioInterface comissario) throws ComissarioException, CompanhiaException;
	
	public ComissarioInterface buscarComissario(CompanhiaInterface companhia, int cod) throws CompanhiaException;
	
	// PASSAGEIRO
	public PassageiroInterface cadastrarPassageiro(ViagemInterface v,String CPF, String nome, int idade, String telefoneProprio, String telefoneDeEmergencia) throws PassageiroException, ViagemException;
	
	public void removerPassageiro(ViagemInterface v, PassageiroInterface passageiro) throws PassageiroException, ViagemException;
	
	public PassageiroInterface buscarPassageiroCod(ViagemInterface v, String CPF) throws ViagemException;
	
	public PassageiroInterface buscarPassageiroNome(String nome);
	
	// VIAGEM
	public ViagemInterface cadastrarViagem(CompanhiaInterface companhia, int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque, Date dataHoraDeDesembarque,int vagasDisponiveis) throws ViagemException, CompanhiaException;
	
	public void removerViagem(CompanhiaInterface companhia, ViagemInterface viagem) throws ViagemException, CompanhiaException ;
	
	public ViagemInterface buscarViagem(CompanhiaInterface companhia,int cod) throws CompanhiaException;
	
	// AVIAO
	public AviaoInterface cadastrarAviao(CompanhiaInterface companhia, int cod, int capacidade, String modelo) throws AviaoException, CompanhiaException;
	
	public void removerAviao(CompanhiaInterface companhia, AviaoInterface aviao) throws AviaoException, CompanhiaException;
	
	public AviaoInterface buscarAviao(CompanhiaInterface companhia, int cod) throws CompanhiaException;
	
	//TORRE CONTROLE
	public void decolar(AviaoInterface aviao) throws TorreControleException;
	public void aterrissar(AviaoInterface aviao) throws TorreControleException;
}
