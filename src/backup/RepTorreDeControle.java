package backup;

import java.util.ArrayList;

import oo.aeroporto.controle.interf.TorreControleInterface;

public class RepTorreDeControle implements RepTorreDeControleInterf {

	private ArrayList<TorreControleInterface> repTorreDeControle = new ArrayList<TorreControleInterface>();
	private static RepTorreDeControle instance = null;	//Singleton

	//Construtor
	private RepTorreDeControle() {}
	
	//Singleton
	public static RepTorreDeControle getInstance() {
		if(instance == null) 
			instance = new RepTorreDeControle();
		return instance;
	}
	
	@Override
	public void adicionar(TorreControleInterface torre) {
		
		repTorreDeControle.add(torre);
	}

	@Override
	public void deletar(TorreControleInterface torre) {
		
		repTorreDeControle.remove(torre);
	}

	@Override
	public TorreControleInterface buscarPorCod(int cod) {
		
		for(int i = 0; i < repTorreDeControle.size(); ++i) {
			
			if(repTorreDeControle.get(i).getCod() ==  cod) {
				
				return repTorreDeControle.get(i);
			}
		}
		return null;
	}

}
