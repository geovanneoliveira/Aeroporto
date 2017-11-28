package oo.aeroporto.negocio;

import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.interf.CompanhiaInterface;

public interface NegocioInterf {
	
	public CompanhiaInterface CadastrarCompanhia(int id, String nome) throws CompanhiaException;

}
