package oo.aeroporto.repositorio.interf;

import oo.aeroporto.controle.interf.ViagemInterface;

public interface RepViagemInterf {
	
public void adicionar(ViagemInterface viagem);
	
	public void deletar(ViagemInterface viagem);
	
	public ViagemInterface buscarPorCod(int cod);


}
