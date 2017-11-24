package oo.aeroporto.repositorio.interf;

import oo.aeroporto.controle.interf.TorreControleInterface;;

public interface RepTorreDeControleInterf {

	public void adicionar(TorreControleInterface torre);
	
	public void deletar(TorreControleInterface torre);
	
	public TorreControleInterface buscarPorCod(int cod);

}
