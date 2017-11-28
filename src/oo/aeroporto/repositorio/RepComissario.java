package oo.aeroporto.repositorio;

import java.util.ArrayList;

import oo.aeroporto.pessoa.exceptions.ComissarioException;
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
	public void adicionar(ComissarioInterface comissario) throws ComissarioException{
		if(comissario == null) {
			throw new ComissarioException("N�o � poss�vel persistir um comissario nulo.");

		}
		if(buscarPorCod(comissario.getANAC()) != null) {
			throw new ComissarioException("J� existe um comissario com o ANAC: " + comissario.getANAC() + " .");

		}
		repComissario.add(comissario);
	}

	@Override
	public void deletar(ComissarioInterface comissario) throws ComissarioException {
		if(comissario == null) {
			throw new ComissarioException("N�o � poss�vel remover um comissario nulo.");

		}
		if(buscarPorCod(comissario.getANAC()) == null) {
			throw new ComissarioException("N�o � poss�vel remover um comissario que n�o est� no reposit�rio");
		}
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
