package oo.aeroporto.main;

import oo.aeroporto.aviao.Airbus;
import oo.aeroporto.aviao.interf.*;
import oo.aeroporto.controle.interf.*;
import oo.aeroporto.pessoa.Comissario;
import oo.aeroporto.pessoa.Piloto;
import oo.aeroporto.pessoa.interf.*;
import oo.aeroporto.repositorio.interf.*;
import oo.aeroporto.controle.*;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.PilotoException;
import oo.aeroporto.controle.exceptions.TorreControleException;
import oo.aeroporto.repositorio.RepCompanhia;
import oo.aeroporto.repositorio.RepPiloto;

public class Main {
	
	private RepPilotoInterf repPiloto;
	private RepCompanhiaInterf repCompanhia;
	
	public Main() {
		this.repPiloto = RepPiloto.getInstance();
		this.repCompanhia = RepCompanhia.getInstance();
	}
	
	public CompanhiaInterface clickCadastrarCompanhia(int id, String nome) {
		CompanhiaInterface novaComp = new Companhia(id, nome);
		try {
			this.repCompanhia.adicionar(novaComp);
			System.out.println("Companhia cadastrada com sucesso!");
		} catch (CompanhiaException ce) {
			novaComp = null;
			System.err.println("Erro ao cadastrar companhia, motivo: " + ce.getMessage());
		}
		return novaComp;
	}
	
	public PilotoInterface clickCadastrarPiloto(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int breve, double horasDeVoo) {
		PilotoInterface novoPiloto = new Piloto(CPF, nome, idade, telefoneProprio, CTPS, breve, horasDeVoo);
		try {
			this.repPiloto.adicionar(novoPiloto);
			System.out.println("Piloto cadastrado com sucesso!");
		} catch (PilotoException pe) {
			novoPiloto = null;
			System.err.println("Erro ao cadastrar piloto, motivo: " + pe.getMessage());
		}
		return novoPiloto;
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
	
	/* MAIN */
	
	public static void main(String[] args) {
		/*Main main = new Main();
		CompanhiaInterface companhia = main.clickCadastrarCompanhia(1, "Gol");
		PilotoInterface piloto = main.clickCadastrarPiloto("08945641459", "Thomás", 19, "999843797","sfwe", 20, 450);
		main.clickCadastroPilotoEmCompanhia(companhia, piloto);
		main.clickCadastroPilotoEmCompanhia(companhia, piloto);*/
		TorreControleInterface torre = new TorreDeControle(4, 5);
		try {
			torre.taxi(null);
		}catch (TorreControleException e){
			System.err.println("Erro ao realizar o Taxi do avião, motivo: "+e.getMessage());
		}
	}
	
	

	public static void main0(String[] args) {

/*		
		CompanhiaInterface c1 = new Companhia(1, "TAM");
		
		RepCompanhiaInterf RepCompanhia = new RepAeroporto();
		
		RepCompanhia.adicionar(c1);
		
		a1.inserirCompanhia(RepCompanhia.buscar("TAM"));*/
		
		
		//GOSTEI DO IMPORT DA LINHA 13, TOP
		//Quem ta usando isso? @geo
		RepPilotoInterf rep = RepPiloto.getInstance();
		CompanhiaInterface a1 = new Companhia(0, "Gol Linhas Áereas");
		CompanhiaInterface a2 = new Companhia(1, "Avianca");
		PilotoInterface thomas = new Piloto("08945641459", "Thomás", 19, "999843797","sfwe", 20, 450);
		ComissarioInterface geo = new Comissario("12312312312", "geovanne",20,"997372597","ctps",100);
		AirbusInterface air = new Airbus(1, 13);
		try {
			a1.inserirPiloto(null);
		}catch (Exception e) {
			System.out.println("erro ao inser");
		} // se vc deixar dessa forma, teria de por um try catch ao redor de CADA UM inserir, então pra poupar trabalho
		// vamos criar métodos que simulem o click...
		a1.inserirComissario(geo);
		a1.inserirAviao(air);
		RepCompanhiaInterf r1 = RepCompanhia.getInstance();
		try {
			r1.adicionar(a1);
		} catch (CompanhiaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			r1.adicionar(a2);
		} catch (CompanhiaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r1.buscarPorCod(0).listarInformacoes();
		
		try {
			rep.adicionar(thomas);
		} catch (PilotoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep.buscarPorCod(20).listarInformacoes();
		
		a1.listarInformacoes();
		
		a1.buscarComissario(100).listarInformacoes();
		
		System.out.println(air.listarInformacoes());
		
		//p1.listarInformacoes();
		
		//RepPilotoInterf rep = RepPiloto.getInstance();
		//PilotoInterface teste = rep.buscarPorCod(20);
		//teste.listarInformacoes();
		//a1.removerPiloto(thomas);
		//PilotoInterface teste1 = rep.buscarPorCod(20);
		
	}

}
