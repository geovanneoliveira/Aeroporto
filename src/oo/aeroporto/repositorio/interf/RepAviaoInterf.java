package oo.aeroporto.repositorio.interf;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;

public interface RepAviaoInterf {
	
	public void adicionar(AviaoInterface aviao) throws AviaoException;
	
	public void deletar(AviaoInterface aviao) throws AviaoException;
	
	public AviaoInterface buscarPorCod(int cod);

}
