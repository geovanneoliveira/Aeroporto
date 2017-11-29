package oo.aeroporto.controle.interf;

import java.util.Date;

import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.interf.PassageiroInterface;

public interface ViagemInterface {
	
	public String listarInformacoes();
	
	public String listarIdentificador();
	
	public void alterarOrigem(String origem) throws ViagemException;
	
	public void alterarDestino(String destino) throws ViagemException;
	
	public void alterarHoraEmbarque(Date hora) throws ViagemException;
	
	public void alterarHoraDesembarque( Date hora) throws ViagemException;
	
	public void alterarVagas(int quantidade) throws PassageiroException;
	
	public void adicionarPassageiro(PassageiroInterface passageiro) throws PassageiroException;
	
	public void retirarPassageiro(PassageiroInterface passageiro) throws PassageiroException;
	
	public PassageiroInterface buscarPassageiro(String CPF);
	
	public int getPassageirosQuantidade();
	
	public int getCod();
	
}
