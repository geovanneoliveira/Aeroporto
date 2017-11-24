package oo.aeroporto.repositorio;

import java.util.ArrayList;

import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.repositorio.interf.RepComissarioInterf;;

public class RepComissario implements RepComissarioInterf {

	private ArrayList<ComissarioInterface> repComissario = new ArrayList<ComissarioInterface>();
	private static RepComissario instance = null;	//Singleton
	
	//Construtor
	private RepComissario() {}
	
	//Singleton
	public static RepComissario getInstance() {
		if (instance == null)
			instance = new RepComissario();
		return instance;
	}

	@Override
	public void adicionar(ComissarioInterface comissario) {

		repComissario.add(comissario);
	}

	@Override
	public void deletar(ComissarioInterface comissario) {

		repComissario.remove(comissario);
	}

	@Override
	public ComissarioInterface buscarPorCod(int cod) {

		for(int i = 0; i < repComissario.size(); ++i) {
			
			if(repComissario.get(i).getANAC() == cod) {
				
				return repComissario.get(i);
			}
		}
	return null;

	}

}
