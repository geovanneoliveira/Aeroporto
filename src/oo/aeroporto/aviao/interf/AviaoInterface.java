package oo.aeroporto.aviao.interf;

import java.util.ArrayList;

import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public interface AviaoInterface {
	
	public void listarInformacoes();
	
	public void listarIdentificacao();
	
	public void adicionarPiloto(PilotoInterface piloto);
	
	public void adicionarCoPiloto(PilotoInterface piloto);
	
	public void adicionarViagem(ViagemInterface viagem);
	
	public void adicionarComissario(ComissarioInterface comissario);
	
	public int getCod(); 
	
	public int getCapacidade();
	
	public PilotoInterface getPiloto();
	
	public PilotoInterface getCoPiloto();
	
	public ViagemInterface getViagem();
	
	public ArrayList<ComissarioInterface> getComissario();
		
	public int checkList();
	
	public int getStatus();
	
	public void setStatus(int n);
	
	public void retirarTodos();

	public int quantComissarios();


}
