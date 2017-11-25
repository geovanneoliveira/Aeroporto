package oo.aeroporto.controle;

import java.util.Date;

import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.interf.PassageiroInterface;
import oo.aeroporto.repositorio.RepPassageiro;
import oo.aeroporto.repositorio.interf.RepPassageiroInterf;

import java.util.ArrayList;


public class Viagem implements ViagemInterface{

	//Attributes
	private int cod;
	private String aeroportoOrigem;
	private String aeroportoDestino;
	private Date dataHoraDeEmbarque;
	private Date dataHoraDeDesembarque;
	private long duracao;
	private int vagasDisponiveis;
	private ArrayList<PassageiroInterface> passageiros = new ArrayList<PassageiroInterface>();
	private RepPassageiroInterf repositorioPassageiro;
	
	public Viagem(int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque,
			Date dataHoraDeDesembarque, int vagasDisponiveis) {
		this(cod, aeroportoOrigem, aeroportoDestino, dataHoraDeEmbarque, dataHoraDeDesembarque,vagasDisponiveis, null);
	}
	
	public Viagem(int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque,
			Date dataHoraDeDesembarque, int vagasDisponiveis, ArrayList<PassageiroInterface> passageiro) {
		this.cod = cod;
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.dataHoraDeEmbarque = dataHoraDeEmbarque;
		this.dataHoraDeDesembarque = dataHoraDeDesembarque;
		this.vagasDisponiveis = vagasDisponiveis;
		
		if(passageiro != null)	this.passageiros = passageiro;
		setDuracao(dataHoraDeEmbarque,dataHoraDeDesembarque);
		this.repositorioPassageiro = RepPassageiro.getInstance();
	}



	
	//Methods 

	private void setDuracao(Date dataHoraDeEmbarque, Date dataHoraDeDesembarque) {
		this.duracao = dataHoraDeDesembarque.getTime() - dataHoraDeEmbarque.getTime();
	}	
	
	public String listarInformacoes() {
		String s = (" Aeroporto de origem: " + aeroportoOrigem + " Aeroporto de destino: " + aeroportoDestino + " Duração prevista: " +
					this.duracao + " Vagas Disponiveis: " + this.vagasDisponiveis + " Previsão para embarque: " + this.dataHoraDeEmbarque +
					" Previsão para desembarque: " + this.dataHoraDeDesembarque);
		return s;
	}
	
	public String listarIdentificador() {
		String s = ("Codigo : " + this.cod);
		return  s;
		
	}

	public void alterarOrigem(String novo) {
		if(novo != null) {
			this.aeroportoOrigem = novo;
		}
		else {
			System.out.println("erro ao alterar a origem");
		}
	}
	
	public void alterarDestino(String novo) {
		if(novo != null) {
			this.aeroportoDestino = novo;
		}
		else {
			System.out.println("erro ao alterar o destino");
		}
	}
	
	public void alterarHoraEmbarque(Date hora) {
		this.dataHoraDeEmbarque = hora;
		setDuracao(this.dataHoraDeEmbarque,this.dataHoraDeDesembarque);
	}
	
	public void alterarHoraDesembarque(Date hora) {
		this.dataHoraDeDesembarque = hora;
		setDuracao(this.dataHoraDeEmbarque,this.dataHoraDeDesembarque);
	}
	
	
	public void alterarVagas(int quantidade) {
		if(quantidade > 0 ) {
			this.vagasDisponiveis = quantidade;
		}
		else {
			System.out.println("Quantidade de vagas invalida");
		}
	}
	
	public void adicionarPassageiro(PassageiroInterface passageiro) {
		this.passageiros.add(passageiro);
		this.repositorioPassageiro.adicionar(passageiro);
	}
	
	public void retirarPassageiro(PassageiroInterface passageiro) {
		this.passageiros.remove(passageiro);
		this.repositorioPassageiro.deletar(passageiro);
	}
	
	public PassageiroInterface buscarPassageiro(int CPF) {
		for(int i = 0; i < this.passageiros.size(); ++i) {
			
			if(this.passageiros.get(i).getCPF().equals(CPF)) {
				
				return this.passageiros.get(i);
			}
		}
		
		return null;
	}
	
	public int passageirosQuantidade() {
		return this.passageiros.size();
	}
	
	public int getCod() {
		return cod;
	}
}

/**
*Conversor de STRING para DATE e TIME
*String str = "10:20";
*SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
*Date data = formatador.parse(str);
*Time time = new Time(data.getTime());
**/
