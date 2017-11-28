package oo.aeroporto.repositorio;

import java.util.ArrayList;

import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.repositorio.interf.RepCompanhiaInterf;

public class RepCompanhia implements RepCompanhiaInterf {

	//Attributes
	private ArrayList<CompanhiaInterface> repCompanhia = new ArrayList<CompanhiaInterface>();
	private static RepCompanhia instance = null; //Singleton
	
	//Construtor
	private RepCompanhia(){}
	
	//Singleton
	public static RepCompanhia getInstance(){
		if (instance == null){
			instance = new RepCompanhia();
		}
		return instance;
	}

	//Methods
	@Override
	public void adicionar(CompanhiaInterface companhia) throws CompanhiaException {
		if(companhia == null){
			throw new CompanhiaException("Não é possível persistir um companhia nula.");
		}
		if(this.buscarPorCod(companhia.getCod()) != null){
			throw new CompanhiaException("Já existe uma companhia com o código " + companhia.getCod() + " .");
		}
		repCompanhia.add(companhia);
	}

	@Override
	public void deletar(CompanhiaInterface companhia) throws CompanhiaException {
		if(companhia == null) {
			throw new CompanhiaException("Não é possível remover uma companhia nula.");

		}
		if(buscarPorCod(companhia.getCod()) == null) {
			throw new CompanhiaException("Não é possível remover uma companhia que não está no repositório");
		}
		repCompanhia.remove(companhia);
		
	}

	@Override
	public CompanhiaInterface buscarPorCod(int cod) {
		
		for(int i = 0; i < repCompanhia.size(); ++i) {
			
			if(repCompanhia.get(i).getCod() == cod) {
				return repCompanhia.get(i);
			}
		}
		return null;
	}

	@Override
	public CompanhiaInterface buscarPorNome(String nome) {

		for(int i = 0; i < repCompanhia.size(); ++i) {
			
			if(repCompanhia.get(i).getNome().equals(nome)) {
				
				return repCompanhia.get(i);
			}
		}
		return null;
	}
}
