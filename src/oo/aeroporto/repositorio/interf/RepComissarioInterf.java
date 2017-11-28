package oo.aeroporto.repositorio.interf;

import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.interf.ComissarioInterface;


public interface RepComissarioInterf {

	public void adicionar(ComissarioInterface comissario) throws ComissarioException;
	
	public void deletar(ComissarioInterface comissario) throws ComissarioException;
	
	public ComissarioInterface buscarPorCod(int cod);
	
}
