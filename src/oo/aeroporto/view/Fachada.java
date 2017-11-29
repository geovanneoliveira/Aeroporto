package oo.aeroporto.view;



import java.sql.Date;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
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
	public Fachada() {
		negocio = new Negocio();
	}
	
	
	//Buttons
	
	
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
	
	public PilotoInterface clickCadastrarPiloto(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) throws PilotoException {
		PilotoInterface piloto = null;
		try {
		piloto = negocio.CadastrarPiloto(CPF, nome, idade, telefoneProprio, CTPS, breve, horasDeVoo);
		System.out.println("Piloto cadastrado com sucesso!");
		return piloto;
		
		} catch (PilotoException pe) {
			System.err.println("Erro ao cadastrar piloto, motivo: " + pe.getMessage());
			return null;
		}
	}
	
	public void clickRemoverPiloto(PilotoInterface piloto) {
		try {
			negocio.RemoverPiloto(piloto);
			System.out.println("Piloto Removido Com sucesso!");
		} catch (PilotoException pe){
			System.err.println("Erro ao Remover Piloto, motivo: " + pe.getMessage());
		}
	}
	
	public PilotoInterface clickBuscarPiloto(int cod) {
		PilotoInterface piloto = null;
		piloto = negocio.buscarPiloto(cod);
		
		if(piloto == null) {
			System.out.println("Nenhuma Piloto localizada!");
			return piloto;
		}
		System.out.println("Piloto localizado com sucesso!");
		return piloto;
	}
	
	//COMISSARIO
	
	public ComissarioInterface clickCadastrarComissario(String CPF, String nome, int idade, String telefoneProprio, String CTPS,int ANAC) throws PilotoException {
		ComissarioInterface comissario = null;
		try {
		comissario = negocio.cadastrarComissrio(CPF, nome, idade, telefoneProprio, CTPS, ANAC);
		System.out.println("Comissario cadastrado com sucesso!");
		return comissario;
		
		} catch (ComissarioException ce) {
			System.err.println("Erro ao cadastrar comissario, motivo: " + ce.getMessage());
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
	
		
	
	
	
	
	
	
	
	
	
	
	
	public PilotoInterface clickCadasjktrarPiloto(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) {
		try {
			PilotoInterface novoPiloto = new Piloto(CPF, nome, idade, telefoneProprio, CTPS, breve, horasDeVoo);
			System.out.println("Piloto cadastrado com sucesso!");
			return novoPiloto;
		} catch (PilotoException pe) {
			
			System.err.println("Erro ao cadastrar piloto, motivo: " + pe.getMessage());
		}
		return null;
	}
	
	
	public void clickCadastroPilotoEmCompanhia(CompanhiaInterface companhia, PilotoInterface piloto) {
		try {
			if(companhia == null){
				throw new CompanhiaException("Companhia não foi encotrada.");
			}
			if(piloto == null){
				throw new CompanhiaException("Piloto não foi encotrado.");
			}
			
			companhia.inserirPiloto(piloto);
			System.out.println("Piloto " + piloto.getNome() + " adicionado para companhia " + companhia.getNome());
		} catch (CompanhiaException ce) {
			System.err.println("Erro ao cadastrar piloto em companhia, motivo: " + ce.getMessage());
		}
	}
	
	
	
	//PASSAGEIROS
	
	
	public PassageiroInterface clickCadastrarPassageiro(String CPF, String nome, int idade, String telefoneProprio,String telefoneDeEmergencia) {
		try {
			PassageiroInterface novoPassageiro = new Passageiro(CPF, nome, idade, telefoneProprio, telefoneDeEmergencia);
			System.out.println("Passagei cadastrado com sucesso!");
			return novoPassageiro;
		} catch (PassageiroException pe) {
			System.err.println("Erro ao Cadastrar piloto, motivo: " + pe.getMessage());
		}
		return null;
	}
	
	
	public void clickDeletarPassageiro(PassageiroInterface passageiro) {
			
		}
		
	
	
}
