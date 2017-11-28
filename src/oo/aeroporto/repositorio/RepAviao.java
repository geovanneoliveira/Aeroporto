package oo.aeroporto.repositorio;

import java.util.ArrayList;

import oo.aeroporto.aviao.exception.AviaoException;
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
	public void adicionar(AviaoInterface aviao) throws AviaoException {
		if(aviao == null) {
			throw new AviaoException("N�o � poss�vel persistir um aviao nulo.");

		}
		if(buscarPorCod(aviao.getCod()) != null) {
			throw new AviaoException("J� existe um aviao com o c�digo " + aviao.getCod() + " .");

		}
		repAviao.add(aviao);
	}

	@Override
	public void deletar(AviaoInterface aviao) throws AviaoException {
		if(aviao == null) {
			throw new AviaoException("N�o � poss�vel remover um aviao nulo.");
		}
		if(buscarPorCod(aviao.getCod()) == null){
			throw new AviaoException("N�o � poss�vel remover um aviao que n�o est� no reposit�rio.");
		}
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
