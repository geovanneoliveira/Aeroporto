package oo.aeroporto.repositorio.interf;

import oo.aeroporto.controle.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public interface RepPilotoInterf {

	public void adicionar(PilotoInterface piloto) throws PilotoException;
	
	public void deletar(PilotoInterface piloto);
	
	public PilotoInterface buscarPorCod(int cod);
}
