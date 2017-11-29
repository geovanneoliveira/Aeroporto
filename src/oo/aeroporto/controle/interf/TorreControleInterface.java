package oo.aeroporto.controle.interf;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.TorreControleException;

public interface TorreControleInterface {
	
	public String status();
	
	public void decolar(AviaoInterface aviao) throws TorreControleException;
	
	public void aterrissar(AviaoInterface aviao) throws TorreControleException;
	
	public void setQuantidadeDePistas(int quatidadeDePistas);
	
	public int getQuantidadeDePistas();
	
	public int getCod();
	
}
