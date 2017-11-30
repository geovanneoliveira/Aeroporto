package oo.aeroporto.view;

import oo.aeroporto.aviao.exception.AviaoException;
import oo.aeroporto.aviao.interf.AviaoInterface;
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

	public static void main(String[] args) {
		
		
		Fachada f = new Fachada(2);

		
		
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
		
		try {
			f.clickRemoverCompanhia(companhia);
			System.out.println("Companhia Removida Com sucesso!");
		}  catch (CompanhiaException ce){
			System.err.println("Erro ao Remover companhia, motivo: " + ce.getMessage());
		}
		
		
		
		//PILOTO
		
		try {
			piloto = f.clickCadastrarPiloto(companhia, "123", "JORGE", 30, "998765432", "321", 100, 1500);
			System.out.println("Piloto cadastrado com sucesso!");
		} catch (PilotoException | CompanhiaException ce) {
			System.err.println("Erro ao cadastrar piloto, motivo: " + ce.getMessage());
		}
		
		
		try {
			f.clickRemoverPiloto(companhia, piloto);
			System.out.println("Piloto Removido Com sucesso!");
		} catch (PilotoException | CompanhiaException ce) {
			System.err.println("Erro ao Remover Piloto, motivo: " + ce.getMessage());
		}
		
		
		//COMISSARIO
		try {
			f.clickCadastrarComissario(companhia, "1234", "CARVALHO", 40, "956783452", "4321", 500);
			System.out.println("Comissario cadastrado com sucesso!");
		} catch (ComissarioException | CompanhiaException coe) {
			System.err.println("Erro ao cadastrar comissario, motivo: " + coe.getMessage());	
		}
		
		try {
			f.clickRemoverComissario(companhia, comissario);
			System.out.println("Comissario Removido Com sucesso!");
		} catch (ComissarioException | CompanhiaException ce){
			System.err.println("Erro ao Remover comissario, motivo: " + ce.getMessage());
		}
		
		
		
		//PASSAGEIRO
		
		try {
			passageiro = f.cadastrarPassageiro(viagem, "12345", "ROMULO", 29, "987654233", "912345123");
			System.out.println("Comissario cadastrado com sucesso!");
		} catch (PassageiroException | ViagemException pe) {
			System.err.println("Erro ao cadastrar passageiro, motivo: " + pe.getMessage());
		}
		
		
		try {
			f.clickRemoverPassageiro(viagem, passageiro);
			System.out.println("Passageiro Removido Com sucesso!");
		} catch (PassageiroException | ViagemException pe){
			System.err.println("Erro ao Remover Passageiro, motivo: " + pe.getMessage());
		}
		
		
		// VIAGEM
		
		try {
			viagem = f.cadastrarViagem(companhia, "1", "REC", "GAO", dataHoraDeEmbarque, dataHoraDeDesembarque, 12);
			System.out.println("Viagem cadastrada com sucesso!");
		} catch (ViagemException | CompanhiaException ve) {
			System.err.println("Erro ao cadastrar viagem, motivo: " + ve.getMessage());
		}
		
		
		try {
			f.removerViagem(companhia, viagem);
			System.out.println("Viagem Removido Com sucesso!");
		} catch (ViagemException | CompanhiaException ve) {
			System.err.println("Erro ao Remover comissario, motivo: " + ve.getMessage());
		}
		
		//AVIAO
		
		try {
		
		
		
		
		
		
		try {
			f.clickPousarAviao(a);
			System.out.println("Pouso realizado com sucesso!");
		} catch (AviaoException | TorreControleException e) {
			System.err.print("Não foi possível pousar o avião. Motivo: "+e.getMessage());
		}
	}

}
