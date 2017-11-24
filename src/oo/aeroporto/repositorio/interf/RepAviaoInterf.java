package oo.aeroporto.repositorio.interf;

import oo.aeroporto.aviao.interf.AviaoInterface;

public interface RepAviaoInterf {
	
	public void adicionar(AviaoInterface aviao);
	
	public void deletar(AviaoInterface aviao);
	
	public AviaoInterface buscarPorCod(int cod);

}
