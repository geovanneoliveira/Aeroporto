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

	
	//Getters e Setters
	

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getAeroportoOrigem() {
		return aeroportoOrigem;
	}

	public void setAeroportoOrigem(String aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}

	public String getAeroportoDestino() {
		return aeroportoDestino;
	}

	public void setAeroportoDestino(String aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}

	public Date getDataHoraDeEmbarque() {
		return dataHoraDeEmbarque;
	}

	public void setDataHoraDeEmbarque(Date dataHoraDeEmbarque) {
		this.dataHoraDeEmbarque = dataHoraDeEmbarque;
		setDuracao(this.dataHoraDeEmbarque,this.dataHoraDeDesembarque);
	}

	public Date getDataHoraDeDesembarque() {
		return dataHoraDeDesembarque;
	}

	public void setDataHoraDeDesembarque(Date dataHoraDeDesembarque) {
		this.dataHoraDeDesembarque = dataHoraDeDesembarque;
		setDuracao(this.dataHoraDeEmbarque,this.dataHoraDeDesembarque);
	}

	public long getDuracao() {
		return duracao;
	}

	private void setDuracao(Date dataHoraDeEmbarque, Date dataHoraDeDesembarque) {
		this.duracao = dataHoraDeDesembarque.getTime() - dataHoraDeEmbarque.getTime();
	}

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public ArrayList<PassageiroInterface> getPassageiro() {
		return passageiros;
	}
	

	
	
	
	
	//Methods @denini
	
	
	public void listarInformacoes() {
		System.out.println("Aeroporto de origem: " + aeroportoOrigem);
		System.out.println("Aeroporto de destino: " + aeroportoDestino);
		System.out.println("Duração prevista: " + this.duracao);
		System.out.println("Vagas Disponiveis: " + this.vagasDisponiveis);
		System.out.println("Previsão para embarque" + this.dataHoraDeEmbarque);
		System.out.println("Previsão para desembarque" + this.dataHoraDeDesembarque);
	}
	
	public void listarIdentificacoes() {
		System.out.println("Codigo da Viagem: " + this.cod);
		
		//acho que deve ter mais coisas aqui!
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
