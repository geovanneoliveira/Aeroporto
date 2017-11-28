package oo.aeroporto.controle.interf;

import java.util.Date;

import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.interf.PassageiroInterface;

public interface ViagemInterface {
	
	public String listarInformacoes();
	
	public String listarIdentificador();
	
	public void alterarOrigem(String origem);
	
	public void alterarDestino(String destino);
	
	public void alterarHoraEmbarque(Date hora);
	
	public void alterarHoraDesembarque( Date hora);
	
	public void alterarVagas(int quantidade);
	
	public void adicionarPassageiro(PassageiroInterface passageiro) throws PassageiroException;
	
	public void retirarPassageiro(PassageiroInterface passageiro) throws PassageiroException;
	
	public PassageiroInterface buscarPassageiro(int cod);
	
	public int passageirosQuantidade();
	
	public int getCod();
	
}
