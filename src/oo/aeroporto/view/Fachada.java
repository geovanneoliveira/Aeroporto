package oo.aeroporto.view;



import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
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
