package oo.aeroporto.view;

import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.pessoa.interf.PilotoInterface;

public class View {

	public static void main(String[] args) {
		
		Fachada f = new Fachada(2);
		CompanhiaInterface c = f.clickCadastrarCompanhia(1, "thomas");
		CompanhiaInterface b = f.clickCadastrarCompanhia(2, "eu");
		PilotoInterface p = f.clickCadastrarPiloto(c, "456", "tho", 45, "4654684", "5646", 120, 120);
		f.clickCadastrarPiloto(b, "456", "tho", 45, "4654684", "5646", 12, 120);
		f.clickRemoverPiloto(b, p);
		AviaoInterface a = f.cadastraAviao(5, 10, "airbus");
		f.clickDecolarAviao(a);
	}

}
