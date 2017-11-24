package oo.aeroporto.controle.interf;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public interface CompanhiaInterface {
	
	public void listarInformacoes();
	
	public void inserirPiloto(PilotoInterface piloto);
	
	public void removerPiloto(PilotoInterface piloto);
	
	public PilotoInterface buscarPiloto(int codigo);
	
	public void inserirComissario(ComissarioInterface comissario);
	
	public void removerComissario(ComissarioInterface comissario);
	
	public ComissarioInterface buscarComissario(int codigo);
	
	public void inserirAviao(AviaoInterface aviao);
	
	public void removerAviao(AviaoInterface aviao);
	
	public AviaoInterface buscarAviao(int codigo);
	
	public void inserirViagem(ViagemInterface viagem);
	
	public void removerViagem(ViagemInterface viagem);
	
	public ViagemInterface buscarViagem(int codigo);
	
	public int getCod();
	
	public String getNome();
	
	
	
}
