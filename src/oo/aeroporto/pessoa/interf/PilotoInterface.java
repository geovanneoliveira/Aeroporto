package oo.aeroporto.pessoa.interf;

import oo.aeroporto.pessoa.exceptions.PilotoException;

public interface PilotoInterface extends FuncionarioInterface {
	
	public int getBreve();
	public double getHorasDeVoo();
	public void addHorasDeVoo(double hora) throws PilotoException; 
	
}
