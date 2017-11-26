package oo.aeroporto.repositorio.interf;

import oo.aeroporto.pessoa.interf.ComissarioInterface;


public interface RepComissarioInterf {

	public void adicionar(ComissarioInterface comissario);
	
	public void deletar(ComissarioInterface comissario);
	
	public ComissarioInterface buscarPorCod(int cod);
	
}
