package oo.aeroporto.main;

import java.util.ArrayList;

import oo.aeroporto.repositorio.*;
import oo.aeroporto.aviao.Airbus;
import oo.aeroporto.aviao.interf.*;
import oo.aeroporto.controle.interf.*;
import oo.aeroporto.pessoa.Comissario;
import oo.aeroporto.pessoa.Piloto;
import oo.aeroporto.pessoa.interf.*;
import oo.aeroporto.repositorio.interf.*;
import sun.net.www.content.audio.aiff;
import oo.aeroporto.controle.*;
import oo.aeroporto.repositorio.RepCompanhia;
import oo.aeroporto.repositorio.RepPiloto;

public class Main {

	public static void main(String[] args) {

/*		
		CompanhiaInterface c1 = new Companhia(1, "TAM");
		
		RepCompanhiaInterf RepCompanhia = new RepAeroporto();
		
		RepCompanhia.adicionar(c1);
		
		a1.inserirCompanhia(RepCompanhia.buscar("TAM"));*/
		
		RepPilotoInterf rep = RepPiloto.getInstance();
		CompanhiaInterface a1 = new Companhia(0, "Gol Linhas �ereas");
		CompanhiaInterface a2 = new Companhia(1, "Avianca");
		PilotoInterface thomas = new Piloto("08945641459", "Thom�s", 19, "999843797","sfwe", 20, 450);
		ComissarioInterface geo = new Comissario("12312312312", "geovanne",20,"997372597","ctps",100);
		a1.inserirPiloto(thomas);
		a1.inserirComissario(geo);
		
		rep.buscarPorCod(20).listarInformacoes();
		
		a1.listarInformacoes();
		
		a1.buscarComissario(100).listarInformacoes();
		
		//p1.listarInformacoes();
		
		//RepPilotoInterf rep = RepPiloto.getInstance();
		//PilotoInterface teste = rep.buscarPorCod(20);
		//teste.listarInformacoes();
		//a1.removerPiloto(thomas);
		//PilotoInterface teste1 = rep.buscarPorCod(20);
		
	}

}
