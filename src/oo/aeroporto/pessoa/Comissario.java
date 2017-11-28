package oo.aeroporto.pessoa;
import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.interf.ComissarioInterface;
import oo.aeroporto.repositorio.RepComissario;
import oo.aeroporto.repositorio.interf.RepComissarioInterf;

public class Comissario extends Funcionario implements ComissarioInterface {

	
	//Attributes
	private int ANAC;
	private RepComissarioInterf repComissario;
	
	//Constructor
	public Comissario(String CPF, String nome, int idade, String telefoneProprio, String CTPS, int ANAC) throws ComissarioException {
		super(CPF, nome, idade, telefoneProprio, CTPS);
		this.ANAC = ANAC;
		
		repComissario = RepComissario.getInstance();
		repComissario.adicionar(this);
	}
	
	public String listarIdentificador(){
		String s = Integer.toString(ANAC);
		return s;
	}
	public int getANAC(){
		return this.ANAC;
	}
}
