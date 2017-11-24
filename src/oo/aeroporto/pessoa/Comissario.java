package oo.aeroporto.pessoa;
import oo.aeroporto.pessoa.interf.ComissarioInterface;

public class Comissario extends Funcionario implements ComissarioInterface {

	
	//Attributes
	private int ANAC;
	
	//Constructor
	public Comissario(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int ANAC) {
		super(CPF, nome, idade, telefoneProprio, CTPS);
		this.ANAC = ANAC;
	}
	
	//@denini
	public void listarIdentificador(){
		System.out.println("ANAC:" + this.ANAC);
	}
	public int getANAC(){
		return this.ANAC;
	}
}
