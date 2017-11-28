package oo.aeroporto.repositorio.interf;

import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.interf.PassageiroInterface;

public interface RepPassageiroInterf {

	public void adicionar(PassageiroInterface passageiro) throws PassageiroException;
	
	public void deletar(PassageiroInterface passageiro) throws PassageiroException;
	
	public PassageiroInterface buscarPorCod(String cod);
	
	public PassageiroInterface buscarPorNome(String nome);
}
