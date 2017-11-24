package oo.aeroporto.controle.interf;

import oo.aeroporto.aviao.interf.AviaoInterface;

public interface TorreControleInterface {
	
	public void status();
	
	public boolean taxi(AviaoInterface aviao);
	
	public void decolar(AviaoInterface aviao);
	
	public void aterrissar (AviaoInterface aviao);
	
	public void setQuatidadeDePistas(int quatidadeDePistas);
	
	public int getQuatidadeDePistas();
	
	public int getCod();
	
}
