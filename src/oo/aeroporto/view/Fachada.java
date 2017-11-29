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
	
	public CompanhiaInterface clickCadastrarCompanhia(int id, String nome) {
		CompanhiaInterface companhia = null;
		try {
		companhia = negocio.CadastrarCompanhia(id, nome);
		System.out.println("Companhia cadastrada com sucesso!");
		return companhia;
		
		} catch (CompanhiaException ce) {
			System.err.println("Erro ao cadastrar companhia, motivo: " + ce.getMessage());
			return null;
		}
	}
	
	public void clickRemoverCompanhia(CompanhiaInterface companhia) {
		try {
			negocio.RemoverCompanhia(companhia);
			System.out.println("Companhia Removida Com sucesso!");
		} catch (CompanhiaException ce){
			System.err.println("Erro ao Remover companhia, motivo: " + ce.getMessage());
		}
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
	
	public PilotoInterface clickCadastrarPiloto(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) {
		PilotoInterface piloto = null;
		try {
		piloto = negocio.CadastrarPiloto(companhia, CPF, nome, idade, telefoneProprio, CTPS, breve, horasDeVoo);
		System.out.println("Piloto cadastrado com sucesso!");
		return piloto;
		
		} catch (PilotoException pe) {
			System.err.println("Erro ao cadastrar piloto, motivo: " + pe.getMessage());
			return null;
		}catch (CompanhiaException ce) {
			System.err.println("Erro ao cadastrar piloto, motivo: " + ce.getMessage());
			return null;
		}
	}
	
	public void clickRemoverPiloto(CompanhiaInterface companhia, PilotoInterface piloto) {
		try {
			negocio.RemoverPiloto(companhia, piloto);
			System.out.println("Piloto Removido Com sucesso!");
		} catch (PilotoException pe){
			System.err.println("Erro ao Remover Piloto, motivo: " + pe.getMessage());
		} catch (CompanhiaException ce) {
			System.err.println("Erro ao Remover Piloto, motivo: " + ce.getMessage());
		}
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
	
	public ComissarioInterface clickCadastrarComissario(CompanhiaInterface companhia, String CPF, String nome, int idade, String telefoneProprio, String CTPS,int ANAC) throws PilotoException {
		ComissarioInterface comissario = null;
		try {
		comissario = negocio.cadastrarComissrio(companhia, CPF, nome, idade, telefoneProprio, CTPS, ANAC);
		System.out.println("Comissario cadastrado com sucesso!");
		return comissario;
		
		} catch (ComissarioException ce) {
			System.err.println("Erro ao cadastrar comissario, motivo: " + ce.getMessage());
			return null;
		} catch (CompanhiaException coe) {
			System.err.println("Erro ao cadastrar comissario, motivo: " + coe.getMessage());
			return null;

		}
	}
	
	public void clickRemoverComissario(ComissarioInterface comissario) {
		try {
			negocio.removerComissario(comissario);
			System.out.println("Comissario Removido Com sucesso!");
		} catch (ComissarioException ce){
			System.err.println("Erro ao Remover comissario, motivo: " + ce.getMessage());
		}
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
	
	public PassageiroInterface cadastrarPassageiro(String CPF, String nome, int idade, String telefoneProprio, String telefoneDeEmergencia) {
		PassageiroInterface passageiro = null;
		try {
			passageiro = negocio.cadastrarPassageiro(CPF, nome, idade, telefoneProprio, telefoneDeEmergencia);
			System.out.println("Comissario cadastrado com sucesso!");
			return passageiro;
		} catch (PassageiroException pe) {
			System.err.println("Erro ao cadastrar passageiro, motivo: " + pe.getMessage());
			return passageiro;

		}
	}
	
	public void clickRemoverPassageiro(PassageiroInterface passageiro) {
		try {
			negocio.removerPassageiro(passageiro);
			System.out.println("Passageiro Removido Com sucesso!");
		} catch (PassageiroException pe){
			System.err.println("Erro ao Remover Passageiro, motivo: " + pe.getMessage());
		}
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
	public ViagemInterface cadastrarViagem(int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque, Date dataHoraDeDesembarque,int vagasDisponiveis) {
		ViagemInterface viagem = null;
		try {
			viagem = negocio.cadastrarViagem(cod, aeroportoOrigem, aeroportoDestino, dataHoraDeEmbarque, dataHoraDeDesembarque, vagasDisponiveis);
			System.out.println("Viagem cadastrada com sucesso!");
			return viagem;
		} catch (ViagemException ve) {
			System.err.println("Erro ao cadastrar viagem, motivo: " + ve.getMessage());
			return viagem;
		}
		
	}
	
	public void removerViagem(ViagemInterface viagem){
		try {
			negocio.removerViagem(viagem);
			System.out.println("Viagem Removido Com sucesso!");
		} catch (ViagemException ve) {
			System.err.println("Erro ao Remover comissario, motivo: " + ve.getMessage());
		}
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
