package oo.aeroporto.controle.interf;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public interface CompanhiaInterface {
	
	public String listarInformacoes();
	
	public void inserirPiloto(PilotoInterface piloto) throws CompanhiaException;
	
	public void removerPiloto(PilotoInterface piloto) throws PilotoException;
	
	public PilotoInterface buscarPiloto(int codigo);
	
	public void inserirComissario(ComissarioInterface comissario) throws ComissarioException;
	
	public void removerComissario(ComissarioInterface comissario) throws ComissarioException;
	
	public ComissarioInterface buscarComissario(int codigo);
	
	public void inserirAviao(AviaoInterface aviao) throws AviaoException;
	
	public void removerAviao(AviaoInterface aviao) throws AviaoException;
	
	public AviaoInterface buscarAviao(int codigo);
	
	public void inserirViagem(ViagemInterface viagem) throws ViagemException;
	
	public void removerViagem(ViagemInterface viagem) throws ViagemException;
	
	public ViagemInterface buscarViagem(int codigo);
	
	public int getCod();
	
	public String getNome();
	
	
	
}
