package oo.aeroporto.repositorio.interf;

import oo.aeroporto.pessoa.interf.PassageiroInterface;

public interface RepPassageiroInterf {

	public void adicionar(PassageiroInterface passageiro);
	
	public void deletar(PassageiroInterface passageiro);
	
	public PassageiroInterface buscarPorCod(String cod);
	
	public PassageiroInterface buscarPorNome(String nome);
}
