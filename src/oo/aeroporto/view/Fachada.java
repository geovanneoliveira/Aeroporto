package oo.aeroporto.view;

import oo.aeroporto.controle.Companhia;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.negocio.*;
import oo.aeroporto.pessoa.Passageiro;
import oo.aeroporto.pessoa.Piloto;
import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.PassageiroInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;
import oo.aeroporto.repositorio.interf.*;

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
	
	
	
	
	
	
	
	
	
	
		
	
	public PilotoInterface clickCadastrarPiloto(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) {
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
