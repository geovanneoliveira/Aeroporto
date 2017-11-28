package oo.aeroporto.repositorio;

import java.util.ArrayList;

import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.repositorio.interf.RepViagemInterf;

public class RepViagem  implements RepViagemInterf{

	private ArrayList<ViagemInterface> repViagem = new ArrayList<ViagemInterface>();
	private static RepViagem instance = null;	//Singleton
	
	//Construtor
	private RepViagem() {}
	
	//Singleton
	public static RepViagem getInstance() {
		if(instance == null)
			instance = new RepViagem();
		return instance;
	}

	@Override
	public void adicionar(ViagemInterface viagem) throws ViagemException {
		if(viagem == null) {
			throw new ViagemException("Não é possível persistir uma viagem nulo.");
		}
		if(buscarPorCod(viagem.getCod()) != null) {
			throw new ViagemException("Já existe uma viagem com o cod :" + viagem.getCod() + " .");
		}
		repViagem.add(viagem);
	}

	@Override
	public void deletar(ViagemInterface viagem) throws ViagemException {
		if(viagem == null) {
			throw new ViagemException("Não é possível remover uma viagem nula.");
		}
		if(buscarPorCod(viagem.getCod()) == null) {
			throw new ViagemException("Não é possível remover uma viagem que não está no repositório");
		}
		repViagem.remove(viagem);
	}

	@Override
	public ViagemInterface buscarPorCod(int cod) {

		for(int i = 0; i < repViagem.size(); ++i) {
			
			if(repViagem.get(i).getCod() == cod) {
				
				return repViagem.get(i);
			}
		}
		return null;
	}
}
