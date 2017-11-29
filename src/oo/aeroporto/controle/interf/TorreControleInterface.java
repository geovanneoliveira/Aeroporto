package oo.aeroporto.controle.interf;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.TorreControleException;

public interface TorreControleInterface {
	
	public String status();
	
	public void setQuantidadeDePistas(int quatidadeDePistas);
	
	public int getQuantidadeDePistas();
	
	public void setCounter(int counter);
	
	public int getCounter();
		
}
