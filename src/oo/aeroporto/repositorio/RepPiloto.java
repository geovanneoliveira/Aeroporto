package oo.aeroporto.repositorio;

import java.util.ArrayList;

import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.PilotoInterface;
import oo.aeroporto.repositorio.interf.RepPilotoInterf;;

public class RepPiloto implements RepPilotoInterf{

	private ArrayList<PilotoInterface> repPiloto = new ArrayList<PilotoInterface>();
	private static RepPiloto instance = null;	//Singleton
	
	//Construtor
	private RepPiloto() {}
	
	//Singleton
	public static RepPiloto getInstance () {
		if(instance == null)
			instance = new RepPiloto();
		return instance;
	}

	@Override
	public void adicionar(PilotoInterface piloto) throws PilotoException {
		if(piloto == null){
			throw new PilotoException("Não é possível persistir um piloto nulo.");
		}
		if(this.buscarPorCod(piloto.getBreve()) != null){
			throw new PilotoException("Já existe um piloto com o brevê: " + piloto.getBreve() + " .");
		}
		repPiloto.add(piloto);
	}

	@Override
	public void deletar(PilotoInterface piloto) throws PilotoException {
		if(piloto == null) {
			throw new PilotoException("Não é possível remover um piloto nulo");
		}
		if(buscarPorCod(piloto.getBreve()) == null) {
			throw new PilotoException("Não é possível remover um piloto que não está no repositorio");

		}
		repPiloto.remove(piloto);
	}

	@Override
	public PilotoInterface buscarPorCod(int cod) {
		
		for(int i = 0; i < repPiloto.size(); ++i) {
			
			if(repPiloto.get(i).getBreve() == cod) {
				
				return repPiloto.get(i);
			}
		}
		
		return null;
	}

}
