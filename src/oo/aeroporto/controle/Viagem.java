package oo.aeroporto.controle;

import java.util.Date;
import java.util.ArrayList;


import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.interf.PassageiroInterface;


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

	
	
	public Viagem(int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque,
			Date dataHoraDeDesembarque, int vagasDisponiveis) throws ViagemException {
		this(cod, aeroportoOrigem, aeroportoDestino, dataHoraDeEmbarque, dataHoraDeDesembarque,vagasDisponiveis, null);
	}
	
	public Viagem(int cod, String aeroportoOrigem, String aeroportoDestino, Date dataHoraDeEmbarque,
			Date dataHoraDeDesembarque, int vagasDisponiveis, ArrayList<PassageiroInterface> passageiro) throws ViagemException {
		this.cod = cod;
		this.aeroportoOrigem = aeroportoOrigem;
		this.aeroportoDestino = aeroportoDestino;
		this.dataHoraDeEmbarque = dataHoraDeEmbarque;
		this.dataHoraDeDesembarque = dataHoraDeDesembarque;
		this.vagasDisponiveis = vagasDisponiveis;
		
		if(passageiro != null)	this.passageiros = passageiro;
		setDuracao(dataHoraDeEmbarque,dataHoraDeDesembarque);
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

	public void alterarOrigem(String novo) throws ViagemException{
		if(novo != null) {
			this.aeroportoOrigem = novo;
		}
		else {
			throw new ViagemException("a Origem não deve ser nula!.");
		}
	}
	
	public void alterarDestino(String novo) throws ViagemException {
		if(novo != null) {
			this.aeroportoDestino = novo;
		}
		else {
			throw new ViagemException("O destino não deve ser nulo!");
		}
	}
	
	public void alterarHoraEmbarque(Date hora) throws ViagemException  {
		if(hora == null) {
			throw new ViagemException("O horario não deve ser nulo!");
		}
		this.dataHoraDeEmbarque = hora;
		setDuracao(this.dataHoraDeEmbarque,this.dataHoraDeDesembarque);
	}
	
	public void alterarHoraDesembarque(Date hora) throws ViagemException {
		if(hora == null) {
			throw new ViagemException("O horario não deve ser nulo!");
		}
		this.dataHoraDeDesembarque = hora;
		setDuracao(this.dataHoraDeEmbarque,this.dataHoraDeDesembarque);
	}
	
	public int getPassageirosQuantidade() {
		return this.passageiros.size();
	}
	
	public int getCod() {
		return cod;
	}
	
	public void alterarVagas(int quantidade) throws PassageiroException{
		if(quantidade > 0 ) {
			this.vagasDisponiveis = quantidade;
		}
		else {
			throw new PassageiroException("Quantidade de vagas invalida!");
		}
	}

	
	public void adicionarPassageiro(PassageiroInterface passageiro) throws PassageiroException {
		if(passageiro == null) {
			throw new PassageiroException("Passageiro não pode ser null!");
		}
		if(buscarPassageiro(passageiro.getCPF()) != null) {
			throw new PassageiroException("Passageiro já existe!");
		}
		this.passageiros.add(passageiro);
	}
	
	public void retirarPassageiro(PassageiroInterface passageiro) throws PassageiroException {
		if(passageiro == null) {
			throw new PassageiroException("Passageiro não pode ser null!");
		}
		if(buscarPassageiro(passageiro.getCPF()) == null) {
			throw new PassageiroException("Passageiro não existe!");
		}
		this.passageiros.remove(passageiro);
	}
	
	public PassageiroInterface buscarPassageiro(String CPF) {
		for(int i = 0; i < this.passageiros.size(); ++i) {
			
			if(this.passageiros.get(i).getCPF().equals(CPF)) {
				
				return this.passageiros.get(i);
			}
		}
		
		return null;
	}
}
	
/**
*Conversor de STRING para DATE e TIME
*String str = "10:20";
*SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
*Date data = formatador.parse(str);
*Time time = new Time(data.getTime());
**/
