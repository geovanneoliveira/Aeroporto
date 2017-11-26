package oo.aeroporto.pessoa.interf;


public interface PilotoInterface extends FuncionarioInterface{
	
	public int getBreve();
	public double getHorasDeVoo();
	public void addHorasDeVoo(double hora); 
	
}
