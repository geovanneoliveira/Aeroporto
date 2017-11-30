package oo.aeroporto.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
import oo.aeroporto.controle.Viagem;
import oo.aeroporto.controle.exceptions.CompanhiaException;
import oo.aeroporto.controle.exceptions.TorreControleException;
import oo.aeroporto.controle.exceptions.ViagemException;
import oo.aeroporto.controle.interf.CompanhiaInterface;
import oo.aeroporto.controle.interf.ViagemInterface;
import oo.aeroporto.pessoa.exceptions.ComissarioException;
import oo.aeroporto.pessoa.exceptions.PassageiroException;
import oo.aeroporto.pessoa.exceptions.PilotoException;
import oo.aeroporto.pessoa.interf.*;

public class View {

	public static void main(String[] args) throws ParseException {
		
		
		Fachada f = new Fachada(2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy hh:mm");

		
		CompanhiaInterface companhia = null;
		PilotoInterface piloto = null;
		AviaoInterface aviao = null;
		PassageiroInterface passageiro = null;
		ComissarioInterface comissario = null;
		ViagemInterface viagem = null;
		
		//NOSSO CODIGO ESTAVA ASSIM
		//PilotoInterface p = f.clickCadastrarPiloto(c, "456", "tho", 45, "4654684", "5646", 120, 120);
		//f.clickCadastrarPiloto(b, "456", "tho", 45, "4654684", "5646", 12, 120);
		//f.clickRemoverPiloto(b, p);
		//AviaoInterface a = f.cadastraAviao(5, 10, "airbus");
		//f.clickDecolarAviao(a);
		
		
		
		//COMPANHIA
		try {
			companhia = f.clickCadastrarCompanhia(01, "Tam");
			System.out.println("Companhia cadastrada com sucesso!");
		}catch (CompanhiaException ce) {
			System.err.println("Erro ao cadastrar companhia, motivo: " + ce.getMessage());
		}
		
		/*try {
			companhia = f.clickRemoverCompanhia(companhia);
			System.out.println("Companhia Removida Com sucesso!");
		}  catch (CompanhiaException ce){
			System.err.println("Erro ao Remover companhia, motivo: " + ce.getMessage());
		}*/
		
		
		
		//PILOTO
		
		try {
			piloto = f.clickCadastrarPiloto(companhia, "123", "JORGE", 30, "998765432", "321", 100, 1500);
			System.out.println("Piloto cadastrado com sucesso!");
		} catch (PilotoException | CompanhiaException ce) {
			System.err.println("Erro ao cadastrar piloto, motivo: " + ce.getMessage());
		}
		
		
		/*try {
			piloto = f.clickRemoverPiloto(companhia, piloto);
			System.out.println("Piloto Removido Com sucesso!");
		} catch (PilotoException | CompanhiaException ce) {
			System.err.println("Erro ao Remover Piloto, motivo: " + ce.getMessage());
		}*/
		
		
		//COMISSARIO
		try {
			comissario = f.clickCadastrarComissario(companhia, "1234", "CARVALHO", 40, "956783452", "4321", 500);
			System.out.println("Comissario cadastrado com sucesso!");
		} catch (ComissarioException | CompanhiaException coe) {
			System.err.println("Erro ao cadastrar comissario, motivo: " + coe.getMessage());	
		}
		
		/*try {
			comissario = f.clickRemoverComissario(companhia, comissario);
			System.out.println("Comissario Removido Com sucesso!");
		} catch (ComissarioException | CompanhiaException ce){
			System.err.println("Erro ao Remover comissario, motivo: " + ce.getMessage());
		}*/
		
		
		// VIAGEM
		
		
		try {
			viagem = f.cadastrarViagem(companhia, 1, "REC", "GAO", (Date) formatter.parse("01/01/2017 13:54"), (Date) formatter.parse("01/01/2017 18:50"), 12);
			System.out.println("Viagem cadastrada com sucesso!");
		} catch (ViagemException | CompanhiaException ve) {
			System.err.println("Erro ao cadastrar viagem, motivo: " + ve.getMessage());
		}
		
		
		/*try {
			viagem = f.removerViagem(companhia, viagem);
			System.out.println("Viagem Removido Com sucesso!");
		} catch (ViagemException | CompanhiaException ve) {
			System.err.println("Erro ao Remover comissario, motivo: " + ve.getMessage());
		}*/
		
		//PASSAGEIRO
		
		try {
			passageiro = f.cadastrarPassageiro(viagem, "12345", "ROMULO", 29, "987654233", "912345123");
			System.out.println("Passageiro cadastrado com sucesso!");
		} catch (PassageiroException | ViagemException pe) {
			System.err.println("Erro ao cadastrar passageiro, motivo: " + pe.getMessage());
		}
		
		
		/*try {
			passageiro = f.clickRemoverPassageiro(viagem, passageiro);
			System.out.println("Passageiro Removido Com sucesso!");
		} catch (PassageiroException | ViagemException pe){
			System.err.println("Erro ao Remover Passageiro, motivo: " + pe.getMessage());
		}*/
		
		

		
		//AVIAO
		
		try {
			aviao = f.cadastraAviao(companhia, 10, 10, "airbus");
			System.out.println("Aviao cadastrado com sucesso!");
		} catch (AviaoException | CompanhiaException ae) {
			System.err.println("Erro ao cadastrar aviao, motivo: " + ae.getMessage());
		}
		
		/*try {
			aviao = f.removerAviao(companhia, aviao);
			System.out.println("Aviao Removido Com sucesso!");
		} catch (AviaoException| CompanhiaException ae) {
			System.err.println("Erro ao Remover aviao, motivo: " + ae.getMessage());
		}*/
		
		System.out.println(companhia.listarInformacoes());
		
		
		System.out.println(comissario.getANAC());
		try {
			aviao.adicionarViagem(viagem);
			aviao.adicionarComissario(comissario);
			aviao.adicionarPiloto(piloto);
			aviao.adicionarCoPiloto(piloto);
			f.clickDecolarAviao(aviao);
		} catch (AviaoException | TorreControleException e) {
			System.err.println("Erro ao decolar aviao, motivo: " + e.getMessage());

		}
	}

}
