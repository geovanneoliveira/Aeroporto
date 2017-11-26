package oo.aeroporto.repositorio.interf;

import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.interf.CompanhiaInterface;

public interface RepCompanhiaInterf {

	public void adicionar(CompanhiaInterface companhia) throws CompanhiaException;
	
	public void deletar(CompanhiaInterface companhia);
	
	public CompanhiaInterface buscarPorCod(int cod);
	
	public CompanhiaInterface buscarPorNome(String nome);
	
}
