package oo.aeroporto.view;



import java.sql.Date;

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
	
	public void clickDecolarAviao(AviaoInterface aviao) {
		if (aviao == null) {
			System.err.println("Avião Inválido");
			return;
		}
		try{
			negocio.decolar(aviao);
		}catch (TorreControleException e) {
			System.err.println(e.getMessage());
		}
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
	
	public void clickRemoverCompanhia(CompanhiaInterface companhia) throws CompanhiaException {
			negocio.RemoverCompanhia(companhia);
	}
	
	
	public CompanhiaInterface clickBuscarCompanhiaPorCod(int cod) {
		CompanhiaInterface companhia = null;
		companhia = negocio.buscarCompanhiaCod(cod);
		
		if(companhia == null) {
			System.out.println("Nenhuma Companhia localizada!");
			return companhia;
		}
		System.out.println("Companhia localizada com sucesso!");
		return companhia;
	}
	
	public CompanhiaInterface clickBuscarCompanhiaPorNome(String nome) {
		CompanhiaInterface companhia = null;
		companhia = negocio.buscarCompanhiaNome(nome);
		
		if(companhia == null) {
			System.out.println("Nenhuma Companhia localizada!");
			return companhia;
		}
		System.out.println("Companhia localizada com sucesso!");
		return companhia;
	}
	
	
	//PILOTO
	
	public PilotoInterface clickCadastrarPiloto(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) throws PilotoException, CompanhiaException {
		PilotoInterface piloto = null;
		piloto = negocio.CadastrarPiloto(companhia, CPF, nome, idade, telefoneProprio, CTPS, breve, horasDeVoo);
		return piloto;

	}
	
	public void clickRemoverPiloto(CompanhiaInterface companhia, PilotoInterface piloto) throws PilotoException, CompanhiaException {
			negocio.RemoverPiloto(companhia, piloto);
		
	}
	
	public PilotoInterface clickBuscarPiloto(CompanhiaInterface companhia, int cod) {
		PilotoInterface piloto = null;
		piloto = negocio.buscarPiloto(companhia,cod);
		
		if(piloto == null) {
			System.out.println("Nenhuma Piloto localizada!");
			return piloto;
		}
		System.out.println("Piloto localizado com sucesso!");
		return piloto;
	}
	
	//COMISSARIO
	
	public ComissarioInterface clickCadastrarComissario(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS,int ANAC) throws ComissarioException, CompanhiaException {
		ComissarioInterface comissario = null;
		comissario = negocio.cadastrarComissrio(companhia, CPF, nome, idade, telefoneProprio, CTPS, ANAC);
		return comissario;
		
	}
	
	public void clickRemoverComissario(ComissarioInterface comissario) throws ComissarioException {
			negocio.removerComissario(comissario);
		
	}
	
	public ComissarioInterface clickBuscarComissario(int cod) {
		ComissarioInterface comissario = null;
		comissario = negocio.buscarComissario(cod);
		
		if(comissario == null) {
			System.out.println("Nenhuma Comissario localizada!");
			return comissario;
		}
		System.out.println("Comissario localizado com sucesso!");
		return comissario;
	}
	
	//PASSAGEIRO
	
	public PassageiroInterface cadastrarPassageiro(String CPF, String nome, int idade, String telefoneProprio, String telefoneDeEmergencia) throws PassageiroException {
			PassageiroInterface passageiro = null;
			passageiro = negocio.cadastrarPassageiro(CPF, nome, idade, telefoneProprio, telefoneDeEmergencia);
			return passageiro;
		
	}
	
	public void clickRemoverPassageiro(PassageiroInterface passageiro) throws PassageiroException {
			negocio.removerPassageiro(passageiro);
			
	}
	
	public PassageiroInterface clickBuscarPassageiroPorCod(String cod) {
		PassageiroInterface passageiro = null;
		passageiro = negocio.buscarPassageiroCod(cod);
		
		if(passageiro == null) {
			System.out.println("Nenhum Passageiro localizado!");
			return passageiro;
		}
		System.out.println("Passageiro localizado com sucesso!");
		return passageiro;
	}
	
	public PassageiroInterface clickBuscarPassageiroPorNome(String nome) {
		PassageiroInterface passageiro = null;
		passageiro = negocio.buscarPassageiroNome(nome);
		
		if(passageiro == null) {
			System.out.println("Nenhum Passageiro localizado!");
			return passageiro;
		}
		System.out.println("Passageiro localizado com sucesso!");
		return passageiro;
	}
	
	
	// VIAGEM
	public ViagemInterface cadastrarViagem(int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque, Date dataHoraDeDesembarque,int vagasDisponiveis) throws ViagemException {
		ViagemInterface viagem = null;
			viagem = negocio.cadastrarViagem(cod, aeroportoOrigem, aeroportoDestino, dataHoraDeEmbarque, dataHoraDeDesembarque, vagasDisponiveis);
			return viagem;

		
	}
	
	public void removerViagem(ViagemInterface viagem) throws ViagemException{
			negocio.removerViagem(viagem);
		
	}
	
	public ViagemInterface buscarViagem(int cod) {
		ViagemInterface viagem = null;
			viagem = negocio.buscarViagem(cod);
			
			if(viagem == null) {
				System.out.println("Nenhum Passageiro localizado!");
				return viagem;
			}
			System.out.println("Passageiro localizado com sucesso!");
			return viagem;
		
	}
	
	
	// AVIAO
	public AviaoInterface cadastraAviao(int cod, int capacidade, String modelo) {
		AviaoInterface aviao = null;
		try {
			aviao = negocio.cadastrarAviao(cod, capacidade, modelo);
			System.out.println("Aviao cadastrado com sucesso!");
			return aviao;
		} catch (AviaoException ae) {
			System.err.println("Erro ao cadastrar aviao, motivo: " + ae.getMessage());
			return aviao;
		}
	}
	
	public void removerAviao(AviaoInterface aviao) {
		try {
			negocio.removerAviao(aviao);
			System.out.println("Aviao Removido Com sucesso!");
		} catch (AviaoException ae) {
			System.err.println("Erro ao Remover aviao, motivo: " + ae.getMessage());
		}
	}
	
	public AviaoInterface buscarAviao(int cod) {
		AviaoInterface aviao = null;
		aviao = negocio.buscarAviao(cod);
		
		if(aviao == null) {
			System.out.println("Nenhum Aviao localizado!");
			return aviao;
		}
		System.out.println("Aviao localizado com sucesso!");
		return aviao;
	}
	
}
