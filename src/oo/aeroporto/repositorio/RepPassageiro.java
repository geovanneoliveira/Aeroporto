package oo.aeroporto.repositorio;

import java.util.ArrayList;

import oo.aeroporto.pessoa.interf.PassageiroInterface;
import oo.aeroporto.repositorio.interf.RepPassageiroInterf;

public class RepPassageiro implements RepPassageiroInterf{

	private ArrayList<PassageiroInterface> repPassageiro = new ArrayList<PassageiroInterface>();
	private static RepPassageiro instance = null;	//Singleton
	
	//Construtor
	private RepPassageiro() {}
	
	public static RepPassageiro getInstance() {
		if(instance == null)
			instance = new RepPassageiro();
		return instance;
	}
	@Override
	public void adicionar(PassageiroInterface passageiro) {
		
		repPassageiro.add(passageiro);
	}

	@Override
	public void deletar(PassageiroInterface passageiro) {
		
		repPassageiro.remove(passageiro);
	}

	@Override
	public PassageiroInterface buscarPorCod(String cod) {

		for(int i = 0; i < repPassageiro.size(); ++i) {
			
			if(repPassageiro.get(i).getCPF().equals(cod)) {
				
				return repPassageiro.get(i);
			}
		}
		return null;
	}

	@Override
	public PassageiroInterface buscarPorNome(String nome) {
		
		for(int i = 0; i < repPassageiro.size(); ++i) {
			
			if(repPassageiro.get(i).getCPF().equals(nome)) {
				
				return repPassageiro.get(i);
			}
		}
		return null;
	}	
}
