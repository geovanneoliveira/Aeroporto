package oo.aeroporto.controle.interf;

import java.util.Date;

import oo.aeroporto.pessoa.interf.PassageiroInterface;

public interface ViagemInterface {
	
	public void listarInformacoes();
	
	public void listarIdentificacoes();
	
	public void alterarOrigem(String origem);
	
	public void alterarDestino(String destino);
	
	public void alterarHoraEmbarque(Date hora);
	
	public void alterarHoraDesembarque( Date hora);
	
	public void alterarVagas(int quantidade);
	
	public void adicionarPassageiro(PassageiroInterface passageiro);
	
	public void retirarPassageiro(PassageiroInterface passageiro);
	
	public PassageiroInterface buscarPassageiro(int cod);
	
	public int passageirosQuantidade();
	
	public int getCod();
	
}
