package oo.aeroporto.negocio;

import java.sql.Date;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PassageiroInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public interface NegocioInterf {
	
	//	COMPANHIA
	public CompanhiaInterface CadastrarCompanhia(int id, String nome) throws CompanhiaException;
	
	public void RemoverCompanhia(CompanhiaInterface companhia) throws CompanhiaException;
	
	public CompanhiaInterface buscarCompanhiaCod(int cod);
	
	public CompanhiaInterface buscarCompanhiaNome(String nome);
	
	//	PILOTO
	public PilotoInterface CadastrarPiloto(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) throws PilotoException;
	
	public void RemoverPiloto(PilotoInterface piloto) throws PilotoException;
	
	public PilotoInterface buscarPiloto(int cod);
	
	// COMISSARIO
	public ComissarioInterface cadastrarComissrio(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int ANAC) throws ComissarioException;
	
	public void removerComissario(ComissarioInterface comissario) throws ComissarioException;
	
	public ComissarioInterface buscarComissario(int cod);
	
	// PASSAGEIRO
	public PassageiroInterface cadastrarPassageiro(String CPF, String nome, int idade, String telefoneProprio, String telefoneDeEmergencia) throws PassageiroException;
	
	public void removerPassageiro(PassageiroInterface passageiro) throws PassageiroException;
	
	public PassageiroInterface buscarPassageiroCod(String cod);
	
	public PassageiroInterface buscarPassageiroNome(String nome);
	
	// VIAGEM
	public ViagemInterface cadastrarViagem(int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque, Date dataHoraDeDesembarque,int vagasDisponiveis) throws ViagemException;
	
	public void removerViagem(ViagemInterface viagem) throws ViagemException;
	
	public ViagemInterface buscarViagem(int cod);
	
	// AVIAO
	public AviaoInterface cadastrarAviao(int cod, int capacidade, String modelo) throws AviaoException;
	
	public void removerAviao(AviaoInterface aviao) throws AviaoException;
	
	public AviaoInterface buscarAviao(int cod);
}
