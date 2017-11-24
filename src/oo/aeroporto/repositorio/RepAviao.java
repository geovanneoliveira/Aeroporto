package oo.aeroporto.repositorio;

import java.util.ArrayList;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.repositorio.interf.RepAviaoInterf;


public class RepAviao implements RepAviaoInterf{

	//Attributes
	private ArrayList<AviaoInterface> repAviao = new ArrayList<AviaoInterface>();
	private static RepAviao instance = null; //Singleton
	
	//Constructor
	private RepAviao() {}
	
	//Singleton
	public static RepAviao getInstance(){
		if (instance == null){
			instance = new RepAviao();
		}
		return instance;
	}


	//Methods
	@Override
	public void adicionar(AviaoInterface aviao) {

		repAviao.add(aviao);
	}

	@Override
	public void deletar(AviaoInterface aviao) {
		
		repAviao.remove(aviao);
	}

	@Override
	public AviaoInterface buscarPorCod(int cod) {

		for(int i = 0; i < repAviao.size(); ++i) {
			
			if(repAviao.get(i).getCod() == cod) {
				
				return repAviao.get(i);
			}
		}
		return null;
	}

}
