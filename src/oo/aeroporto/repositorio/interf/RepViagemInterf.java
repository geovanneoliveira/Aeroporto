package oo.aeroporto.repositorio.interf;

import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.ViagemInterface;

public interface RepViagemInterf {
	
public void adicionar(ViagemInterface viagem) throws ViagemException;
	
	public void deletar(ViagemInterface viagem) throws ViagemException;
	
	public ViagemInterface buscarPorCod(int cod);


}
